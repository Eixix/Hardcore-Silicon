package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotFuel;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotGrinderOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
//import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityBlastFurnace;

public class ContainerBlastFurnace extends ContainerBasicMachine {

	public ContainerBlastFurnace(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT1, 56, 35));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT2, 36, 35));
		//Input-Slot 3
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT3, 36, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityBlastFurnace.OUTPUT1, 116, 50));
		//Output-Slot 2
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityBlastFurnace.OUTPUT2, 116, 20));
	}

	/**
	 * aka." shiftClickHandler - implement it or crash the game"
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex){
		ItemStack itemStack1 = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);
		// only try moving items if the slot is valid and has items
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack2 = slot.getStack();
			itemStack1 = itemStack2.copy();
			// Item to be transferred is in the output slot. Try inserting it to
			// the players inventory
			if (slotIndex == TileEntityBlastFurnace.OUTPUT1) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}
				slot.onSlotChange(itemStack2, itemStack1);
				// The item is in the players inventory and has to be inserted
				// into a free input slot
			} else if (slotIndex != TileEntityBlastFurnace.INPUT1 && slotIndex != TileEntityBlastFurnace.INPUT2 && slotIndex != TileEntityBlastFurnace.INPUT3) {
				// Check if the input slots are free
				if (!((Slot) inventorySlots.get(TileEntityBlastFurnace.INPUT1)).getHasStack() || !((Slot) inventorySlots.get(TileEntityBlastFurnace.INPUT2)).getHasStack() || !((Slot) inventorySlots.get(TileEntityBlastFurnace.INPUT3)).getHasStack()) {
					if (!mergeItemStack(itemStack2, TileEntityBlastFurnace.INPUT1, TileEntityBlastFurnace.INPUT2, TileEntityBlastFurnace.INPUT3 +1,
							false)) {
						return null;
					}
					// The item is in the players inventory, but not in the
					// action bar. try putting it in the action bar
				} else if (slotIndex >= sizeInventory && slotIndex < sizeInventory + 27) {
					if (!mergeItemStack(itemStack2, sizeInventory + 27, sizeInventory + 36, false)) {
						return null;
					}
					// Item is in the action bar, try putting it in the
					// inventory
				} else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36) {
					if (!mergeItemStack(itemStack2, sizeInventory + 1, sizeInventory + 27, false)) {
						return null;
					}
				}
				// The item is in one of the machine slots, try placing it in
				// the players inventory or action bar
			} else if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, false)) {
				return null;
			}

			if (itemStack2.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemStack2.stackSize == itemStack1.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(playerIn, itemStack2);
		}
		return itemStack1;	
	}


}

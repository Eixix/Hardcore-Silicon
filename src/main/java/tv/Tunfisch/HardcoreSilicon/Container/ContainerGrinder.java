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
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public class ContainerGrinder extends ContainerBasicMachine {


	public ContainerGrinder(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer inventory) {
		// Input-Slot
		addSlotToContainer(new Slot(tileMachine, TileEntityGrinder.INPUT, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotGrinderOutput(inventory.player, tileMachine,
				TileEntityGrinder.OUTPUT, 116, 35));
		// Fuel-Slot
		addSlotToContainer(new SlotFuel(tileMachine, TileEntityGrinder.FUEL, 26, 35));
	}

	/**
	 * aka." shiftClickHandler - implement it or crash the game"
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex) {
		ItemStack itemStack1 = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack2 = slot.getStack();
			itemStack1 = itemStack2.copy();
			// Output Slot
			if (slotIndex == TileEntityGrinder.OUTPUT) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}

				slot.onSlotChange(itemStack2, itemStack1);
				// Input Slot
			} else if (slotIndex != TileEntityGrinder.INPUT
					&& slotIndex != TileEntityGrinder.FUEL) {
				// Check if there is a grinding recipe for the stack
				ItemStack[] in = { itemStack2 };
				String machine = NameHelper.getName(BlockRegister.blockGrinder);
				if (!((Slot)inventorySlots.get(TileEntityGrinder.INPUT)).getHasStack()) {
					if (!mergeItemStack(itemStack2, 0, 1, false)) {
						return null;
					}
					// If fuel, place in fuel slot
				} else if (SlotFuel.isFuel(itemStack2)) {
					if (!mergeItemStack(itemStack2, 2, 3, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory && slotIndex < sizeInventory + 27) {
					if (!mergeItemStack(itemStack2, sizeInventory + 27, sizeInventory + 36, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36) {
					if (!mergeItemStack(itemStack2, sizeInventory + 1, sizeInventory + 27, false)) {
						return null;
					}
				}
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

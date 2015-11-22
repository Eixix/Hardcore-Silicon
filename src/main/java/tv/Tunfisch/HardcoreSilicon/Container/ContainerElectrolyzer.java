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
import tv.Tunfisch.HardcoreSilicon.GrinderRecipes;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotFuel;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotGrinderOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public class ContainerElectrolyzer extends ContainerBasicMachine {

	public ContainerElectrolyzer(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}
	
	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		//Input-Slot 1
	    addSlotToContainer(new Slot(tileMachine, TileEntityElectrolyzer.INPUT1, 56, 35));
	    //Input-Slot 2
	    addSlotToContainer(new Slot(tileMachine, TileEntityElectrolyzer.INPUT2, 36, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput( tileMachine, TileEntityElectrolyzer.OUTPUT, 116, 35));
		
	} 
	

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex) {
		ItemStack itemStack1 = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack2 = slot.getStack();
			itemStack1 = itemStack2.copy();
			//Output Slot	
			if (slotIndex == TileEntityElectrolyzer.OUTPUT) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}

				slot.onSlotChange(itemStack2, itemStack1);
			//Input Slot	
			} else if (slotIndex != TileEntityElectrolyzer.INPUT1) {
				//Check if there is a grinding recipe for the stack
				ItemStack[] in = {itemStack2};
				if (HardcoreSilicon.mrh.getOutput(in , NameHelper.getName(BlockRegister.blockElectrolyzer)) != null) {
					if (!mergeItemStack(itemStack2, 0, 1, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory && slotIndex < sizeInventory + 27){
					if (!mergeItemStack(itemStack2, sizeInventory + 27, sizeInventory + 36, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36
						&& !mergeItemStack(itemStack2, sizeInventory + 1, sizeInventory + 27, false)){
					return null;
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

package tv.Tunfisch.HardcoreSilicon.TileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerBlastFurnace;

public class TileEntityBlastFurnace extends TileEntityBasicMachine {
	// Enumerate the slots
	//Convention: Start counting by 0. 0 has to be an input slot and the last slot is always the output slot
	public static final int INPUT1 = 0, INPUT2 = 1, INPUT3 = 2, OUTPUT1 = 3, OUTPUT2 = 4;

	private static final int[] slotsTop = new int[] { INPUT1, INPUT2, INPUT3 };
	private static final int[] slotsBottom = new int[] { OUTPUT1, OUTPUT2 };
	private static final int[] slotsSides = new int[] {};

	/**
	 * The output is the last custom slot so, starting by zero it has to be 
	 * the output slots number plus one.
	 */
	@Override
	public int getCustomSlotsCount(){
		return OUTPUT2 +1;
		
	}
	
	@Override
	public int timeToProcessOneItem(ItemStack parItemStack) {
		return 500;
	}

	@Override
	public ItemStack[] getInputs(){
		ItemStack[] stackarray = {machineItemStacks[INPUT1], machineItemStacks[INPUT2], machineItemStacks[INPUT3]};
		return stackarray;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerBlastFurnace(playerInventory, this);
	}

	@Override
	public int getFirstOutputSlotNumber() {
		return OUTPUT1;
	}

	/**
	 * No fuel needed -1
	 */
	@Override
	public int getFuelSlotNumber() {
		return -1;
	}

	@Override
	public int getInputCount() {
		return 3;
	}

}
package tv.Tunfisch.HardcoreSilicon.TileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerCrystalizer;

public class TileEntityCrystalizer extends TileEntityBasicMachine {
	// Enumerate the slots
	//Convention: Start counting by 0. 0 has to be an input slot and the last slot is always the output slot
	public static final int INPUT = 0, FUEL = 1, OUTPUT = 2;

	private static final int[] slotsTop = new int[] { INPUT, FUEL };
	private static final int[] slotsBottom = new int[] { OUTPUT };
	private static final int[] slotsSides = new int[] {};

	/**
	 * The output is the last custom slot so, starting by zero it has to be 
	 * the output slots number plus one.
	 */
	@Override
	public int getCustomSlotsCount(){
		return OUTPUT +1;
	}
	
	@Override
	public String getName() {
		return "tile.BlockCrystalizer.name";
	}
	
	@Override
	public int timeToProcessOneItem(ItemStack parItemStack) {
		return 200;
	}

	@Override
	public ItemStack[] getInputs(){
		ItemStack[] stackarray = {machineItemStacks[INPUT]};
		return stackarray;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":crystalizer";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerCrystalizer(playerInventory, this);
	}

	@Override
	public int getFirstOutputSlotNumber() {
		return OUTPUT;
	}

	/**
	 * No fuel needed -1
	 */
	@Override
	public int getFuelSlotNumber() {
		return FUEL;
	}

	@Override
	public int getInputCount() {
		return 1;
	}

}
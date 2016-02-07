package tv.Tunfisch.HardcoreSilicon.TileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerGrinder;

public class TileEntityGrinder extends TileEntityBasicMachine {
	// Enumerate the slots
	// Convention: Start counting by 0. 0 has to be an input slot and the last
	// slot is always the output slot
	public static final int INPUT = 0, FUEL = 1, OUTPUT = 2;

	private static final int[] slotsTop = new int[] { INPUT };
	private static final int[] slotsBottom = new int[] { FUEL };
	private static final int[] slotsSides = new int[] { OUTPUT };

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerGrinder(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":grinder";
	}

	@Override
	public int getCustomSlotsCount() {
		return OUTPUT + 1;
	}

	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getFirstOutputSlotNumber() {
		return OUTPUT;
	}

	@Override
	public String getName() {
		return "tile.BlockGrinder.name";
	}
	
	@Override
	public int timeToProcessOneItem(ItemStack parItemStack) {
		return 200;
	}

	@Override
	public ItemStack[] getInputs() {
		ItemStack[] in = {machineItemStacks[INPUT]};
		return in;
	}

	@Override
	public int getFuelSlotNumber() {
		return FUEL;
	}
}

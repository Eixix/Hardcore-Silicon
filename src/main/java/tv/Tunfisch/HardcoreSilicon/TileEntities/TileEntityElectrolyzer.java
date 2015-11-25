package tv.Tunfisch.HardcoreSilicon.TileEntities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;

public class TileEntityElectrolyzer extends TileEntityBasicMachine {
	// Enumerate the slots
	//Convention: Start counting by 0. 0 has to be an input slot and the last slot is always the output slot
	public static final int INPUT1 = 0, INPUT2 = 1, OUTPUT = 2;

	private static final int[] slotsTop = new int[] { INPUT1, INPUT2 };
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
		return NameHelper.getName(BlockRegister.blockElectrolyzer);
	}
	
	@Override
	public int timeToProcessOneItem(ItemStack parItemStack) {
		return 200;
	}

	@Override
	public ItemStack[] getInputs(){
		ItemStack[] stackarray = {machineItemStacks[INPUT1], machineItemStacks[INPUT2]};
		return stackarray;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public String getGuiID() {
		return Reference.MOD_ID + ":electrolyzer";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerElectrolyzer(playerInventory, this);
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
		return -1;
	}

	@Override
	public int getInputCount() {
		return 2;
	}

}
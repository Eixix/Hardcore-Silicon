package tv.Tunfisch.HardcoreSilicon.TileEntities;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;

public abstract class TileEntityBasicMachine extends TileEntityLockable
		implements IUpdatePlayerListBox, ISidedInventory {
	protected int timeCanProcess;
	protected int currentItemProcessTime;
	protected int ticksProcessingItemSoFar;
	protected int ticksPerItem;
	protected int fuelValue;
	protected String machineCustomName;
	protected ItemStack[] machineItemStacks = new ItemStack[this.getCustomSlotsCount()];

	/**
	 * Gets the number of custom slots added by the TileEntity
	 * 
	 * @return Number of custom Slots
	 */
	public abstract int getCustomSlotsCount();

	/**
	 * Gets the number of the fuel Slot. If the machine does not need fuel, set
	 * -1.
	 * 
	 * @return Fuel Slot number
	 */
	public abstract int getFuelSlotNumber();

	/**
	 * Gets the amount of input slots.
	 * 
	 * @return Input Slot count
	 */
	public abstract int getInputCount();

	/**
	 * Gets the first Output slot number. As the amount of other custom slots is
	 * unknown, the first output slot number is needed to iterate through all
	 * outputs
	 * 
	 * @return Number of the first output slot
	 */
	public abstract int getFirstOutputSlotNumber();

	@Override
	/**
	 * Name pls
	 */
	public abstract String getName();

	/**
	 * Time in millisecond to process or to process some particular item
	 * 
	 * @param parItemStack
	 *            Some item that is softer/harder
	 * @return Time to Process in millis
	 */
	public abstract int timeToProcessOneItem(ItemStack parItemStack);

	/**
	 * Gets the content of all Inputs of the TileEntity
	 * 
	 * @return Alle ItemStacks form all Inputs
	 */
	public abstract ItemStack[] getInputs();

	@Override
	public void update() {
		boolean hasBeenProcessing = processingSomething();
		boolean changedProcessingState = false;

		if (processingSomething()) {
			timeCanProcess--;
		}

		if (!worldObj.isRemote) {
			// if something in the input slots
			if (!this.oneInputEmpty()) {
				// start Processing
				if (!processingSomething() && canProcess()) {

					timeCanProcess = 150;

					if (processingSomething()) {
						changedProcessingState = true;
					}
				}

				// continue Processing
				if (processingSomething() && canProcess()) {
					ticksProcessingItemSoFar++;

					// check if completed Processing an item
					if (ticksProcessingItemSoFar == ticksPerItem) {
						ticksProcessingItemSoFar = 0;
						ticksPerItem = this.timeToProcessOneItem(machineItemStacks[0]);
						this.processItem();
						changedProcessingState = true;
					}
				} else {
					ticksProcessingItemSoFar = 0;
				}
			}
		}

		if (changedProcessingState) {
			markDirty();
		}
	}

	/**
	 * Checks if the Processer is able to Process
	 * 
	 * @return
	 */
	private boolean canProcess() {
		// If nothing in input slot
		if (this.oneInputEmpty()) {
			return false;
		} else if (this.getFuelSlotNumber() != -1 && fuelValue == 0) {
			if (machineItemStacks[this.getFuelSlotNumber()] != null) {
				if (machineItemStacks[this.getFuelSlotNumber()]
						.isItemEqual(new ItemStack(ItemRegister.itemBatteryBasic))) {
					// If you can take an item away, take it away
					if (machineItemStacks[this.getFuelSlotNumber()].stackSize > 1)
						--machineItemStacks[this.getFuelSlotNumber()].stackSize;
					// If stacksize equals 0 delete itemStack
					else machineItemStacks[this.getFuelSlotNumber()] = null;
					fuelValue += 8;
				} else if (machineItemStacks[this.getFuelSlotNumber()].isItemEqual(new ItemStack(Items.water_bucket))) {
					// Empty water bucket
					machineItemStacks[this.getFuelSlotNumber()] = new ItemStack(Items.bucket);
					fuelValue += 4;
				}
			}
			
			return false; 
		} else {
			// Check if it has a Processing recipe
			ItemStack[] in = this.getInputs();
			String machine = this.getName();
			ItemStack[] itemstack = HardcoreSilicon.mrh.getOutput(in, machine);
			if (itemstack == null)
				return false;
			for (int i = 0; i < itemstack.length; i++) {
				if (itemstack[i] == null)
					return false;
			}
			// Check if all outputs are empty
			int count = 0;
			for (int i = this.getFirstOutputSlotNumber(); i < this.getCustomSlotsCount(); i++) {
				if (machineItemStacks[i] == null)
					count++;
			}
			// if count meets the number of outputs its ready to go
			if (count == Math.abs(this.getFirstOutputSlotNumber() - this.getCustomSlotsCount())) {
				return true;
			}
			// Check if items in the output are the same as the ones to be
			// produced
			int j = 0;
			for (int i = this.getFirstOutputSlotNumber(); i < this.getCustomSlotsCount(); i++) {
				if (machineItemStacks[i] != null && machineItemStacks[i].getItem() != itemstack[j].getItem()) {
					return false;
				}
				j++;
			}
			// Check if the max stack size is reached
			int k = 0;
			for (int i = this.getFirstOutputSlotNumber(); i < this.getCustomSlotsCount(); i++) {
				int result;
				if (machineItemStacks[i] != null) {
					result = machineItemStacks[i].stackSize + itemstack[k].stackSize;
					if (result > getInventoryStackLimit() || result > machineItemStacks[i].getMaxStackSize())
						return false;
				}
				k++;
			}
			return true;
		}
	}

	public void processItem() {
		if (this.canProcess()) {
			// Fetch recipe output
			ItemStack[] in = this.getInputs();
			ItemStack[] itemstack = HardcoreSilicon.mrh.getOutput(in, this.getName());
			// Check if output slot/s is/are empty
			int j = 0;
			for (int i = this.getFirstOutputSlotNumber(); i < this.getCustomSlotsCount(); i++) {
				// Calculate Stacksize
				double chanche = HardcoreSilicon.mrh.getOutputChanche(in, itemstack[j], this.getName());
				int stacksize = itemstack[j].stackSize;
				if (stacksize >= 1 && chanche < 1) {
					for (int k = 0; k < itemstack[j].stackSize; k++) {
						// Check if the Crafter is unlucky
						if (Math.random() > chanche)
							stacksize--;
					}
				}
				// Put the output in the output Slot, if there is any
				if (stacksize > 0) {
					if (machineItemStacks[i] == null) {
						machineItemStacks[i] = new ItemStack(itemstack[j].getItem(), stacksize);
					} else if (machineItemStacks[i].getItem() == (itemstack[j].getItem())) {
						machineItemStacks[i].stackSize += stacksize;
					}
				}
				j++;
			}

			// Reduce input stack size by 1
			for (int i = 0; i < this.getInputCount(); i++) {
				if (machineItemStacks[i] != null)
					machineItemStacks[i].stackSize--;
			}
			// Reduce fuel value if needed
			if (this.getFuelSlotNumber() != -1)
				fuelValue--;
			// Check if there is still input left and return buckets
			for (int i = 0; i < this.getInputCount(); i++) {
				if (machineItemStacks[i].stackSize <= 0) {
					if (this.isBucket(machineItemStacks[i])) {
						machineItemStacks[i] = new ItemStack(Items.bucket);
					} else {
						machineItemStacks[i] = null;
					}
				}
			}
		}

	}

	/**
	 * Checks if the given stacks is an bucket with a fluid inside.
	 * 
	 * @param stack
	 *            The stack to be checked
	 * @return true if lava or water bucket
	 */
	private boolean isBucket(ItemStack stack) {
		return stack.isItemEqual(new ItemStack(Items.water_bucket))
				|| stack.isItemEqual(new ItemStack(Items.lava_bucket));
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer playerIn) {
		return worldObj.getTileEntity(pos) != this ? false
				: playerIn.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
	}

	@Override
	public boolean shouldRefresh(World parWorld, BlockPos parPos, IBlockState parOldState, IBlockState parNewState) {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return machineItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return machineItemStacks[index];
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean processingSomething() {
		return true;
	}

	// this function indicates whether container texture should be drawn
	@SideOnly(Side.CLIENT)
	public static boolean func_174903_a(IInventory parIInventory) {
		return true;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (machineItemStacks[index] != null) {
			ItemStack itemstack;

			if (machineItemStacks[index].stackSize <= count) {
				itemstack = machineItemStacks[index];
				machineItemStacks[index] = null;
				return itemstack;
			} else {
				itemstack = machineItemStacks[index].splitStack(count);
				if (machineItemStacks[index].stackSize == 0) {
					machineItemStacks[index] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then
	 * 
	 * drop whatever it returns as an EntityItem - like when you close a
	 * workbench GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if (machineItemStacks[index] != null) {
			ItemStack itemstack = machineItemStacks[index];
			machineItemStacks[index] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean isSameItemStackAlreadyInSlot = stack != null && stack.isItemEqual(machineItemStacks[index])
				&& ItemStack.areItemStackTagsEqual(stack, machineItemStacks[index]);
		machineItemStacks[index] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		for (int i = 0; i < this.getInputCount(); i++) {
			if (index == i && !isSameItemStackAlreadyInSlot) {
				ticksPerItem = timeToProcessOneItem(stack);
				ticksProcessingItemSoFar = 0;
				markDirty();
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		machineItemStacks = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbtTagCompound.getByte("Slot");

			if (b0 >= 0 && b0 < machineItemStacks.length) {
				machineItemStacks[b0] = ItemStack.loadItemStackFromNBT(

				nbtTagCompound);
			}
		}

		timeCanProcess = compound.getShort("ProcessTime");
		ticksProcessingItemSoFar = compound.getShort("CookTime");
		ticksPerItem = compound.getShort("CookTimeTotal");
		fuelValue = compound.getShort("FuelValue");

		if (compound.hasKey("CustomName", 8)) {
			machineCustomName = compound.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setShort("ProcessTime", (short) timeCanProcess);
		compound.setShort("CookTime", (short) ticksProcessingItemSoFar);
		compound.setShort("CookTimeTotal", (short) ticksPerItem);
		compound.setShort("FuelValue", (short) fuelValue);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < machineItemStacks.length; ++i) {
			if (machineItemStacks[i] != null) {
				NBTTagCompound nbtTagCompound = new NBTTagCompound();
				nbtTagCompound.setByte("Slot", (byte) i);
				machineItemStacks[i].writeToNBT(nbtTagCompound);
				nbttaglist.appendTag(nbtTagCompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (hasCustomName()) {
			compound.setString("CustomName", machineCustomName);
		}
	}

	@Override
	public int getField(int id) {
		switch (id) {
		case 0:
			return timeCanProcess;
		case 1:
			return currentItemProcessTime;
		case 2:
			return ticksProcessingItemSoFar;
		case 3:
			return ticksPerItem;
		case 4:
			return fuelValue;
		case 5:
			return this.getCustomSlotsCount();
		case 6:
			return this.getFirstOutputSlotNumber();
		case 7:
			return this.getInputCount();
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			timeCanProcess = value;
			break;
		case 1:
			currentItemProcessTime = value;
			break;
		case 2:
			ticksProcessingItemSoFar = value;
			break;
		case 3:
			ticksPerItem = value;
			break;
		case 4:
			fuelValue = value;
		default:
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 8;
	}

	@Override
	public void clear() {
		for (int i = 0; i < machineItemStacks.length; ++i) {
			machineItemStacks[i] = null;
		}
	}

	@Override
	public boolean hasCustomName() {
		return machineCustomName != null && machineCustomName.length() > 0;
	}

	public void setCustomInventoryName(String parCustomName) {
		machineCustomName = parCustomName;
	}

	@Override
	public boolean canExtractItem(int parSlotIndex, ItemStack parStack, EnumFacing parFacing) {
		return true;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		for (int i = 0; i < this.getInputCount(); i++) {
			if (index == i)
				return true;
		}
		return false;
	}

	public boolean oneInputEmpty() {
		for (int i = 0; i < this.getInputCount(); i++) {
			if (machineItemStacks[i] == null)
				return true;
		}
		return false;
	}
}

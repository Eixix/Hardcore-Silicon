package tv.Tunfisch.HardcoreSilicon.Grinder;

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

public class ContainerGrinder extends Container {
	private final IInventory tileGrinder;
	private final int sizeInventory;
	private int ticksGrindingItemSoFar;
	private int ticksPerItem;
	private int timeCanGrind;

	public ContainerGrinder(InventoryPlayer parInventoryPlayer, IInventory parIInventory) {
		// DEBUG
		System.out.println("ContainerGrinder constructor()");

		tileGrinder = parIInventory;
		sizeInventory = tileGrinder.getSizeInventory();
		//Input-Slot
		addSlotToContainer(new Slot(tileGrinder, TileEntityGrinder.slotEnum.INPUT_SLOT.ordinal(), 56, 35));
		//Output-Slot
		addSlotToContainer(new SlotGrinderOutput(parInventoryPlayer.player, tileGrinder,
				TileEntityGrinder.slotEnum.OUTPUT_SLOT.ordinal(), 116, 35));
        //Fuel-Slot
		addSlotToContainer(new SlotGrinderFuel(tileGrinder, TileEntityGrinder.slotEnum.FUEL_SLOT.ordinal(), 26, 35));
		// add player inventory slots
		// note that the slot numbers are within the player inventory so can
		// be same as the tile entity inventory
		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(parInventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// add hotbar slots
		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(parInventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting listener) {
		super.addCraftingToCrafters(listener);
		listener.func_175173_a(this, tileGrinder);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) crafters.get(i);

			if (ticksGrindingItemSoFar != tileGrinder.getField(2)) {
				icrafting.sendProgressBarUpdate(this, 2, tileGrinder.getField(2));
			}

			if (timeCanGrind != tileGrinder.getField(0)) {
				icrafting.sendProgressBarUpdate(this, 0, tileGrinder.getField(0));
			}

			if (ticksPerItem != tileGrinder.getField(3)) {
				icrafting.sendProgressBarUpdate(this, 3, tileGrinder.getField(3));
			}
		}

		ticksGrindingItemSoFar = tileGrinder.getField(2);
		timeCanGrind = tileGrinder.getField(0);
		ticksPerItem = tileGrinder.getField(3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		tileGrinder.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileGrinder.isUseableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex) {
		ItemStack itemStack1 = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack2 = slot.getStack();
			itemStack1 = itemStack2.copy();
			//Fuel Slot
			if (slotIndex == TileEntityGrinder.slotEnum.FUEL_SLOT.ordinal()) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}

				slot.onSlotChange(itemStack2, itemStack1);
			//Output Slot	
			}else if (slotIndex == TileEntityGrinder.slotEnum.OUTPUT_SLOT.ordinal()) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}

				slot.onSlotChange(itemStack2, itemStack1);
			//Input Slot	
			} else if (slotIndex != TileEntityGrinder.slotEnum.INPUT_SLOT.ordinal()) {
				//Check if there is a grinding recipe for the stack
				if (GrinderRecipes.instance().getGrindingResult(itemStack2) != null) {
					if (!mergeItemStack(itemStack2, 0, 1, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory && slotIndex < sizeInventory + 27) // player
																							// inventory
																							// slots
				{
					if (!mergeItemStack(itemStack2, sizeInventory + 27, sizeInventory + 36, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36
						&& !mergeItemStack(itemStack2, sizeInventory + 1, sizeInventory + 27, false)) // hotbar
																										// slots
				{
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
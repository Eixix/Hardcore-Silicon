package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public abstract class ContainerBasicMachine extends Container {
	protected final IInventory tileMachine;
	protected final int sizeInventory;
	protected int ticksProcessingItemSoFar;
	protected int ticksPerItem;
	protected int timeCanProcess;
	protected int fuel;

	public ContainerBasicMachine(InventoryPlayer playerInventory, IInventory inventory) {
		tileMachine = inventory;
		sizeInventory = tileMachine.getSizeInventory();
		this.addSlots(playerInventory);
		// add player inventory slots
		// note that the slot numbers are within the player inventory so can
		// be same as the tile entity inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		// add hotbar slots
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}

	/**
	 * Add your custom slots here
	 * @param inventory the players inventory
	 */
	protected abstract void addSlots(InventoryPlayer inventory);

	@Override
	public void addCraftingToCrafters(ICrafting listener) {
		super.addCraftingToCrafters(listener);
		listener.func_175173_a(this, tileMachine);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) crafters.get(i);

			if (ticksProcessingItemSoFar != tileMachine.getField(2)) {
				icrafting.sendProgressBarUpdate(this, 2, tileMachine.getField(2));
			}

			if (timeCanProcess != tileMachine.getField(0)) {
				icrafting.sendProgressBarUpdate(this, 0, tileMachine.getField(0));
			}

			if (ticksPerItem != tileMachine.getField(3)) {
				icrafting.sendProgressBarUpdate(this, 3, tileMachine.getField(3));
			}

			if (fuel != tileMachine.getField(4)) {
				icrafting.sendProgressBarUpdate(this, 4, tileMachine.getField(4));
			}
			
		}

		ticksProcessingItemSoFar = tileMachine.getField(2);
		timeCanProcess = tileMachine.getField(0);
		ticksPerItem = tileMachine.getField(3);
		fuel = tileMachine.getField(4);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		tileMachine.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileMachine.isUseableByPlayer(playerIn);
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
			if (this.slotIndexIsOutput(slotIndex)) {
				if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}
				slot.onSlotChange(itemStack2, itemStack1);
				// The item is in the players inventory and has to be inserted
				// into a free input slot
			} else if (this.slotIndexIsNotInput(slotIndex)) {
				// Check if the input slots are free
				if (this.isOneInputSlotEmpty(slotIndex)) {
					if (!mergeItemStack(itemStack2, 0, tileMachine.getField(7), false)) {
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

	private boolean slotIndexIsOutput(int slotIndex){
		for(int i = tileMachine.getField(6); i < tileMachine.getField(5); i++){
			if(slotIndex == i) return true;
		}
		return false;
	}
	
	private boolean slotIndexIsNotInput(int slotIndex){
		for(int i= 0; i < tileMachine.getField(7);i++){
			if(slotIndex == i) return false;
		}
		return true;
	}
	
	private boolean isOneInputSlotEmpty(int slotIndex){
		for(int i= 0; i < tileMachine.getField(7);i++){
			if(!((Slot) inventorySlots.get(i)).getHasStack()) return true;
		}
		return false;
	}

}

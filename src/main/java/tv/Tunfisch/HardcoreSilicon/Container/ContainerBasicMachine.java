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
import tv.Tunfisch.HardcoreSilicon.Slots.SlotFuel;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotGrinderOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public abstract class ContainerBasicMachine extends Container {
	protected final IInventory tileMachine;
	protected final int sizeInventory;
	protected int ticksProcessingItemSoFar;
	protected int ticksPerItem;
	protected int timeCanProcess;

	public ContainerBasicMachine(InventoryPlayer playerInventory, IInventory inventory) {
		tileMachine = inventory;
		sizeInventory = tileMachine.getSizeInventory();
		this.addSlots(playerInventory);
		// add player inventory slots
		// note that the slot numbers are within the player inventory so can
		// be same as the tile entity inventory
		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		// add hotbar slots
		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
	
	protected abstract void addSlots(InventoryPlayer inventory);
	
	@Override
	public abstract ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex);
	
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
		}

		ticksProcessingItemSoFar = tileMachine.getField(2);
		timeCanProcess = tileMachine.getField(0);
		ticksPerItem = tileMachine.getField(3);
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
	
}

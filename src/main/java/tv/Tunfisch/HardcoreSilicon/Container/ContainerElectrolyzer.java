package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;

public class ContainerElectrolyzer extends ContainerBasicMachine {

	public ContainerElectrolyzer(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1
		addSlotToContainer(new Slot(tileMachine, TileEntityElectrolyzer.INPUT1, 36, 35));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityElectrolyzer.INPUT2, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityElectrolyzer.OUTPUT, 116, 35));
	}
}
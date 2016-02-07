package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityMillingMachine;

public class ContainerMillingMachine extends ContainerBasicMachine {

	public ContainerMillingMachine(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1
		addSlotToContainer(new Slot(tileMachine, TileEntityMillingMachine.INPUT1, 36, 35));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityMillingMachine.INPUT2, 56, 35));
		// Output-Slot 1
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityMillingMachine.OUTPUT1, 116, 35));
		// Output-Slot 2
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityMillingMachine.OUTPUT2, 136, 35));
		// Output-Slot 3
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityMillingMachine.OUTPUT3, 156, 35));
	}
}
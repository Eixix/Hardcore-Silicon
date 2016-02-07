package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityAssembler;

public class ContainerAssembler extends ContainerBasicMachine {

	public ContainerAssembler(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1
		addSlotToContainer(new Slot(tileMachine, TileEntityAssembler.INPUT1, 36, 15));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityAssembler.INPUT2, 36, 35));
		// Input-Slot 3
		addSlotToContainer(new Slot(tileMachine, TileEntityAssembler.INPUT3, 36, 55));
		// Output-Slot 
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityAssembler.OUTPUT, 116, 35));
	}

}

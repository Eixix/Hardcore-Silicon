package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotWhitelist;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityUVR;

public class ContainerUVR extends ContainerBasicMachine {

	public ContainerUVR(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1 (Template-Slot)
		Item[] templates = {Items.coal};
		addSlotToContainer(new SlotWhitelist(tileMachine, TileEntityUVR.INPUT1, 36, 35, templates));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityUVR.INPUT2, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityUVR.OUTPUT, 116, 35));
	}
}
package tv.Tunfisch.HardcoreSilicon.Container;


import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotWhitelist;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityCrystalizer;

public class ContainerCrystalizer extends ContainerBasicMachine {

	public ContainerCrystalizer(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Water Slot
		addSlotToContainer(new SlotWhitelist(tileMachine, TileEntityCrystalizer.FUEL, 36, 35, new Item[]{Items.water_bucket}));
		// Input-Slot 
		addSlotToContainer(new Slot(tileMachine, TileEntityCrystalizer.INPUT, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityCrystalizer.OUTPUT, 116, 35));
	}
}
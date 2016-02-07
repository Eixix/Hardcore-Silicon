package tv.Tunfisch.HardcoreSilicon.Container;


import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotGrinderOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotWhitelist;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public class ContainerGrinder extends ContainerBasicMachine {


	public ContainerGrinder(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer inventory) {
		// Input-Slot
		addSlotToContainer(new Slot(tileMachine, TileEntityGrinder.INPUT, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotGrinderOutput(inventory.player, tileMachine,
				TileEntityGrinder.OUTPUT, 116, 35));
		// Fuel-Slot
		addSlotToContainer(new SlotWhitelist(tileMachine, TileEntityGrinder.FUEL, 26, 35, new Item[]{ItemRegister.itemBatteryBasic}));
	}
}
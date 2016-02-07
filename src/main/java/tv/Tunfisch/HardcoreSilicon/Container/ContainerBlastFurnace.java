package tv.Tunfisch.HardcoreSilicon.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityBlastFurnace;

public class ContainerBlastFurnace extends ContainerBasicMachine {

	public ContainerBlastFurnace(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Input-Slot 1
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT1, 16, 35));
		// Input-Slot 2
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT2, 36, 35));
		// Input-Slot 3
		addSlotToContainer(new Slot(tileMachine, TileEntityBlastFurnace.INPUT3, 56, 35));
		// Output-Slot 1
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityBlastFurnace.OUTPUT1, 116, 35));
		// Output-Slot 2
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityBlastFurnace.OUTPUT2, 136, 35));
	}

}

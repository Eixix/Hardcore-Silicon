package tv.Tunfisch.HardcoreSilicon.Container;

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
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotFuel;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotGrinderOutput;
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
		addSlotToContainer(new SlotFuel(tileMachine, TileEntityGrinder.FUEL, 26, 35));
	}
}
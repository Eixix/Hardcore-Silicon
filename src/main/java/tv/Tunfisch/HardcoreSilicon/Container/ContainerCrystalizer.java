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
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotWater;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityCrystalizer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public class ContainerCrystalizer extends ContainerBasicMachine {

	public ContainerCrystalizer(InventoryPlayer playerInventory, IInventory inventory) {
		super(playerInventory, inventory);
	}

	@Override
	protected void addSlots(InventoryPlayer playerInventory) {
		// Water Slot
		addSlotToContainer(new SlotWater(tileMachine, TileEntityCrystalizer.FUEL, 36, 35));
		// Input-Slot 
		addSlotToContainer(new Slot(tileMachine, TileEntityCrystalizer.INPUT, 56, 35));
		// Output-Slot
		addSlotToContainer(new SlotOutput(tileMachine, TileEntityCrystalizer.OUTPUT, 116, 35));
	}
}
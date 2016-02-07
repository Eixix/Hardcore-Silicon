package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerMillingMachine;

@SideOnly(Side.CLIENT)
public class GuiMillingMachine extends GuiBasicMachine {

	public GuiMillingMachine(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "millingmachine", new ContainerMillingMachine(parInventoryPlayer, parInventoryMachine));
	}
}

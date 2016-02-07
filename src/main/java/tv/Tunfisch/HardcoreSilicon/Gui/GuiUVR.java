package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerUVR;

@SideOnly(Side.CLIENT)
public class GuiUVR extends GuiBasicMachine {

	public GuiUVR(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "uvr", new ContainerUVR(parInventoryPlayer, parInventoryMachine));
	}
}

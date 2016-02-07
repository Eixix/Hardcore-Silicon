package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerElectrolyzer;

@SideOnly(Side.CLIENT)
public class GuiElectrolyzer extends GuiBasicMachine {
	
	public GuiElectrolyzer(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "electrolyzer", new ContainerElectrolyzer(parInventoryPlayer, parInventoryMachine));
	}
}

package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerBlastFurnace;

@SideOnly(Side.CLIENT)
public class GuiBlastFurnace extends GuiBasicMachine {
	
	public GuiBlastFurnace(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "blastfurnace", new ContainerBlastFurnace(parInventoryPlayer, parInventoryMachine));
	}
}

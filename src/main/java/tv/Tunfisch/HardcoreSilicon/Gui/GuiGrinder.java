package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerGrinder;

@SideOnly(Side.CLIENT)
public class GuiGrinder extends GuiBasicMachine {

	public GuiGrinder(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "grinder", new ContainerGrinder(parInventoryPlayer, parInventoryMachine));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		int marginHorizontal = (width - xSize) / 2;
		int marginVertical = (height - ySize) / 2;
	    this.drawString(fontRendererObj, tileMachine.getField(4) + " Fuel", marginHorizontal, marginVertical, 6143);
	}
}

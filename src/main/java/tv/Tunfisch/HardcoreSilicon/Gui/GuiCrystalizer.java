package tv.Tunfisch.HardcoreSilicon.Gui;


import java.awt.Color;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerCrystalizer;

@SideOnly(Side.CLIENT)
public class GuiCrystalizer extends GuiBasicMachine {

	public GuiCrystalizer(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "crystalizer", new ContainerCrystalizer(parInventoryPlayer, parInventoryMachine));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		int marginHorizontal = (width - xSize) / 2;
		int marginVertical = (height - ySize) / 2;
		// Draw Water level
		drawGradientRect(marginHorizontal + 10, marginVertical + 80 - 15 * tileMachine.getField(4), marginHorizontal + 30, marginVertical + 60, Color.CYAN.getRGB(), Color.BLUE.getRGB());
	}

}

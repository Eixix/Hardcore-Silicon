package tv.Tunfisch.HardcoreSilicon.Gui;

import java.awt.Color;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerGrinder;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

@SideOnly(Side.CLIENT)
public class GuiGrinder extends GuiContainer {
	private static final ResourceLocation grinderGuiTextures = new ResourceLocation(
			Reference.MOD_ID + ":textures/gui/container/grinder.png");
	private final InventoryPlayer inventoryPlayer;
	private final IInventory tileGrinder;

	public GuiGrinder(InventoryPlayer parInventoryPlayer, IInventory parInventoryGrinder) {
		super(new ContainerGrinder(parInventoryPlayer, parInventoryGrinder));
		inventoryPlayer = parInventoryPlayer;
		tileGrinder = parInventoryGrinder;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = tileGrinder.getDisplayName().getUnformattedText();
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(grinderGuiTextures);
		int marginHorizontal = (width - xSize) / 2;
		int marginVertical = (height - ySize) / 2;
		drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);
		// Draw progress indicator
		int progressLevel = getProgressLevel(24);
		drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 176, 14, progressLevel + 1, 16);
		//Fuelstate
	    this.drawString(fontRendererObj, ((TileEntityGrinder)tileGrinder).getField(4) + " Fuel", marginHorizontal, marginVertical, 6143);
	}

	private int getProgressLevel(int progressIndicatorPixelWidth) {
		int ticksGrindingItemSoFar = tileGrinder.getField(2);
		int ticksPerItem = tileGrinder.getField(3);
		return ticksPerItem != 0 && ticksGrindingItemSoFar != 0
				? ticksGrindingItemSoFar * progressIndicatorPixelWidth / ticksPerItem : 0;
	}
}

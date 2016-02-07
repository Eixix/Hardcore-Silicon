package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import tv.Tunfisch.HardcoreSilicon.Reference;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerBasicMachine;

public abstract class GuiBasicMachine extends GuiContainer {
	protected static ResourceLocation machineGuiTextures;
	protected final InventoryPlayer inventoryPlayer;
	protected final IInventory tileMachine;

	public GuiBasicMachine(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine, String name,
			Container c) {
		super(c);
		machineGuiTextures = new ResourceLocation(Reference.MOD_ID + ":textures/gui/container/" + name + ".png");
		inventoryPlayer = parInventoryPlayer;
		tileMachine = parInventoryMachine;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = tileMachine.getDisplayName().getUnformattedText();
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		fontRendererObj.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(machineGuiTextures);
		int marginHorizontal = (width - xSize) / 2;
		int marginVertical = (height - ySize) / 2;
		drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);
		// Draw progress indicator
		int progressLevel = getProgressLevel(24);
		drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 176, 14, progressLevel + 1, 16);
	}

	private int getProgressLevel(int progressIndicatorPixelWidth) {
		int ticksGrindingItemSoFar = tileMachine.getField(2);
		int ticksPerItem = tileMachine.getField(3);
		return ticksPerItem != 0 && ticksGrindingItemSoFar != 0
				? ticksGrindingItemSoFar * progressIndicatorPixelWidth / ticksPerItem : 0;
	}
}

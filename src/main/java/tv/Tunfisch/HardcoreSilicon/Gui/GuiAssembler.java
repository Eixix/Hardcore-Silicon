package tv.Tunfisch.HardcoreSilicon.Gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerAssembler;

@SideOnly(Side.CLIENT)
public class GuiAssembler extends GuiBasicMachine {

	public GuiAssembler(InventoryPlayer parInventoryPlayer, IInventory parInventoryMachine) {
		super(parInventoryPlayer, parInventoryMachine, "assembler", new ContainerAssembler(parInventoryPlayer, parInventoryMachine));
	}
}

package tv.Tunfisch.HardcoreSilicon.Handler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerBasicMachine;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerBlastFurnace;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerCrystalizer;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Container.ContainerGrinder;
import tv.Tunfisch.HardcoreSilicon.Gui.GuiBlastFurnace;
import tv.Tunfisch.HardcoreSilicon.Gui.GuiCrystalizer;
import tv.Tunfisch.HardcoreSilicon.Gui.GuiElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Gui.GuiGrinder;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Slots.SlotOutput;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityBasicMachine;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityCrystalizer;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler {

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){ 
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null && tileEntity instanceof TileEntityBasicMachine){
        	//name is e.g. "tile.blockCrystalizer.name"
        	String name = ((TileEntityBasicMachine) tileEntity).getName();
        	//cut name to e.g. "Crystalizer"
        	name = name.substring(name.indexOf("k") + 1, name.lastIndexOf('.'));
        	//Dynamical class access, booyah!
        	try {
				Class container = Class.forName("tv.Tunfisch.HardcoreSilicon.Container.Container" + name);
				Constructor c = container.getConstructor(InventoryPlayer.class, IInventory.class);
				return c.newInstance(player.inventory, (IInventory) tileEntity);
			} catch (Exception e) {
				//Error-handling 101:Just print that stuff, maybe it helps
				e.printStackTrace();
			}
        }
        return null;
    }

	@Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null && tileEntity instanceof TileEntityBasicMachine){
        	//name is e.g. "tile.blockCrystalizer.name"
        	String name = ((TileEntityBasicMachine) tileEntity).getName();
        	//cut name to e.g. "Crystalizer"
        	name = name.substring(name.indexOf("k") + 1, name.lastIndexOf('.'));
        	//Dynamical class creation, booyah!
        	try {
				Class gui = Class.forName("tv.Tunfisch.HardcoreSilicon.Gui.Gui" + name);
				Constructor g = gui.getConstructor(InventoryPlayer.class, IInventory.class);
				return g.newInstance(player.inventory, (IInventory) tileEntity);
			} catch (Exception e) {
				//Error-handling 101:Just print that stuff, maybe it helps
				e.printStackTrace();
			}
        }    
        return null;
    }
}

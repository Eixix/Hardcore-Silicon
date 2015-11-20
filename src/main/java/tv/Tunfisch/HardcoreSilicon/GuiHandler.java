package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.Electrolyzer.ContainerElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Electrolyzer.GuiElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Grinder.ContainerGrinder;
import tv.Tunfisch.HardcoreSilicon.Grinder.GuiGrinder;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler {

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){ 
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null){
            if (tileEntity.getBlockType() == BlockRegister.blockGrinder){
                return new ContainerGrinder(player.inventory, (IInventory)tileEntity);
            }else if (tileEntity.getBlockType() == BlockRegister.blockElectrolyzer){
            	System.out.println("ELECTROLYZE!!!");
                return new ContainerElectrolyzer(player.inventory,(IInventory)tileEntity);
            }
        }
        return null;
    }

	@Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null){
            if (tileEntity.getBlockType() == BlockRegister.blockGrinder){
                return new GuiGrinder(player.inventory,(IInventory)tileEntity);
            }else if (tileEntity.getBlockType() == BlockRegister.blockElectrolyzer){
                return new GuiElectrolyzer(player.inventory,(IInventory)tileEntity);
            }
        }    
        return null;
    }
}
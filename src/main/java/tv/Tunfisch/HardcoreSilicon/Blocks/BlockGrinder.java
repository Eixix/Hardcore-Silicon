package tv.Tunfisch.HardcoreSilicon.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;

public class BlockGrinder extends BlockBasicMachine {
	public BlockGrinder() {
		super();
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGrinder();
	}

	@Override
	public void breakThisBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!hasTileEntity) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityGrinder) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityGrinder) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, BlockPos pos) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public String getName() {
		return NameHelper.getName(this);
	}

	@Override
	public int getID() {
		return this.getIdFromBlock(this);
	}

}
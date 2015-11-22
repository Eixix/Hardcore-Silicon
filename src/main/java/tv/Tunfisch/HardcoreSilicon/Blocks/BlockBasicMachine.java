package tv.Tunfisch.HardcoreSilicon.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
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
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;

public abstract class BlockBasicMachine extends BlockContainer{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected static boolean hasTileEntity;
	protected int id;

	public BlockBasicMachine() {
		super(Material.rock);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		blockParticleGravity = 1.0F;
		slipperiness = 0.6F;
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		lightOpacity = 20; // cast a light shadow
		setTickRandomly(false);
		useNeighborBrightness = false;
		this.setUnlocalizedName(this.getName());
		id = this.getID();
	}
	
	public abstract String getName();
	
	public abstract int getID();

	@Override
	public abstract Item getItemDropped(IBlockState state, Random rand, int fortune);
	
	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);
	public abstract void breakThisBlock(World worldIn, BlockPos pos, IBlockState state);
	
	@Override
	@SideOnly(Side.CLIENT)
	public abstract Item getItem(World worldIn, BlockPos pos);
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		this.breakThisBlock(worldIn, pos, state);
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockAdded(World parWorld, BlockPos parBlockPos, IBlockState parIBlockState) {
		if (!parWorld.isRemote) {
			// Rotate block if the front side is blocked
			Block blockToNorth = parWorld.getBlockState(parBlockPos.north()).getBlock();
			Block blockToSouth = parWorld.getBlockState(parBlockPos.south()).getBlock();
			Block blockToWest = parWorld.getBlockState(parBlockPos.west()).getBlock();
			Block blockToEast = parWorld.getBlockState(parBlockPos.east()).getBlock();
			EnumFacing enumfacing = (EnumFacing) parIBlockState.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && blockToNorth.isFullBlock() && !blockToSouth.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			} else if (enumfacing == EnumFacing.SOUTH && blockToSouth.isFullBlock() && !blockToNorth.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			} else if (enumfacing == EnumFacing.WEST && blockToWest.isFullBlock() && !blockToEast.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			} else if (enumfacing == EnumFacing.EAST && blockToEast.isFullBlock() && !blockToWest.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}

			parWorld.setBlockState(parBlockPos, parIBlockState.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public boolean onBlockActivated(World parWorld, BlockPos parBlockPos, IBlockState parIBlockState,
			EntityPlayer parPlayer, EnumFacing parSide, float hitX, float hitY, float hitZ) {
		if (!parWorld.isRemote) {
			parPlayer.openGui(HardcoreSilicon.instance, id, parWorld, parBlockPos.getX(),
					parBlockPos.getY(), parBlockPos.getZ());
		}

		return true;
	}



	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { FACING });
	}

	@SideOnly(Side.CLIENT)
	static final class SwitchEnumFacing {
		static final int[] enumFacingArray = new int[EnumFacing.values().length];

		static {
			try {
				enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				// You should improve the error handling here
			}
		}
	}
}



package tv.Tunfisch.HardcoreSilicon.Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;

public class BlockElectrolyzer extends BlockBasicMachine {
	public BlockElectrolyzer() {
		super();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityElectrolyzer();
	}

	@Override
	public void breakThisBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!hasTileEntity) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityElectrolyzer) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityElectrolyzer) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);	
			}
		}
	}
}

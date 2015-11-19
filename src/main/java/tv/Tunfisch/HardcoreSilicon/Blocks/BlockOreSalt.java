package tv.Tunfisch.HardcoreSilicon.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.ItemRegister;
import tv.Tunfisch.HardcoreSilicon.NameHelper;

public class BlockOreSalt extends Block {
	public BlockOreSalt(Material materialIn, float hardness, float resistance, float lightLevel, String tool, int harvestLevel) {
		super(materialIn);
		setUnlocalizedName(NameHelper.getName(this));
		setHardness(hardness);
		setResistance(resistance);
		setLightLevel(lightLevel);
		setHarvestLevel(tool, harvestLevel);
		setStepSound(soundTypeStone);
	}	
	
	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune){
		return ItemRegister.itemSalt;
	}
	
	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
	    return 1 + random.nextInt(fortune + 3);
	}
}

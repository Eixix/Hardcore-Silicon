package tv.Tunfisch.HardcoreSilicon.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tv.Tunfisch.HardcoreSilicon.BlockRenderRegister;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.Utility;

public class BlockOreQuartz extends Block {

	public BlockOreQuartz(Material materialIn, String unlocalizedName, float hardness, float resistance, float lightLevel, String tool, int harvestLevel) {
		super(materialIn);
		setUnlocalizedName(unlocalizedName);
		setHardness(hardness);
		setResistance(resistance);
		setLightLevel(lightLevel);
		setHarvestLevel(tool, harvestLevel);
		setStepSound(soundTypeStone);
		setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
		GameRegistry.registerBlock(this, Utility.getName(this));
	}	
}


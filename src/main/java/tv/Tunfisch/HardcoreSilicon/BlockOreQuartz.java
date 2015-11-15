package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreQuartz extends Block {

	protected BlockOreQuartz(Material material) {
		super(material);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeStone);
		setBlockTextureName("HardcoreSilicon:BlockOreQuartz");
		setBlockName("BlockOreQuartz");
		
		
		
	}

}

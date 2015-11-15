package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;

public class BlockRegister {
	public static Block blockOreQuartz;
	
	public static void registerBlocks(){
		//BLOCKS
		blockOreQuartz = new BlockOreQuartz(Material.rock, 1.0F, 1.0F, 0.0F, "pickaxe", 2);
	}
}

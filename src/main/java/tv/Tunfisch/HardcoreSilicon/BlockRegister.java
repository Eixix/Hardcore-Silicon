package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;

/**
 * This class contains all mod blocks and registers them.
 */
public class BlockRegister {
	public static Block blockOreQuartz;
	
	/**
	 * Initializes and registers all given blocks.
	 */
	public static void registerBlocks(){
		//BLOCKS
		blockOreQuartz = new BlockOreQuartz(Material.rock, 1.0F, 1.0F, 0.0F, "pickaxe", 2);
		registerBlock(blockOreQuartz);
		//Create an OreDictionary entry
		OreDictionary.registerOre("oreQuartz", blockOreQuartz);
	}
	
	/**
	 * Registers the given Block in the GameReguistry and sets the creativeTab.
	 * @param block Block to be registered
	 */
	private static void registerBlock(Block block){
		block.setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
		GameRegistry.registerBlock(block, Utility.getName(block));
	}
}

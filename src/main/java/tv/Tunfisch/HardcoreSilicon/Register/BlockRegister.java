package tv.Tunfisch.HardcoreSilicon.Register;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockGrinder;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreChromite;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreSalt;

/**
 * This class contains all mod blocks and registers them.
 */
public class BlockRegister {
	public static Block blockOreQuartz;
	public static Block blockGrinder;
	public static Block blockOreChromite;
	public static Block blockOreSalt;
	public static Block blockElectrolyzer;
	
	/**
	 * Initializes and registers all given blocks.
	 */
	public static void registerBlocks(){
		//BLOCKS
		blockOreQuartz = new BlockOreQuartz(Material.rock, 25.0F, 2.0F, 0.0F, "pickaxe", 2);
		registerBlock(blockOreQuartz);
		//Create an OreDictionary entry
		OreDictionary.registerOre("oreQuartz", blockOreQuartz);
		
		blockOreChromite = new BlockOreChromite(Material.rock, 20.0F, 2.0F, 0.0F, "pickaxe", 2);
		registerBlock(blockOreChromite);
		//Create an OreDictionary entry
		OreDictionary.registerOre("oreChrome", blockOreChromite);
		
		blockOreSalt = new BlockOreSalt(Material.rock, 5.0F, 1.0F, 0.0F, "pickaxe", 1);
		registerBlock(blockOreSalt);
		//Create an OreDicitonary entry
		OreDictionary.registerOre("oreSalt", blockOreSalt);
		
		blockGrinder = new BlockGrinder();
		registerBlock(blockGrinder);
		
		blockElectrolyzer = new BlockElectrolyzer();
		registerBlock(blockElectrolyzer);
	}
	
	/**
	 * Registers the given Block in the GameRegistry and sets the creativeTab.
	 * @param block Block to be registered
	 */
	private static void registerBlock(Block block){
		block.setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
		GameRegistry.registerBlock(block, NameHelper.getName(block));
	}
}

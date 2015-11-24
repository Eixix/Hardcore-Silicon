package tv.Tunfisch.HardcoreSilicon.Register;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockGrinder;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockLimestone;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreBauxite;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreChromite;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreSalt;
import tv.Tunfisch.HardcoreSilicon.Fluids.SulfuricAcid;

/**
 * This class contains all mod blocks and registers them.
 */
public class BlockRegister {
	public static Block blockOreQuartz;
	public static Block blockGrinder;
	public static Block blockOreChromite;
	public static Block blockOreSalt;
	public static Block blockElectrolyzer;
	public static Block blockOreBauxite;
	public static Block blockLimestone;
	//Fluids
	public static Block blockSulfuricAcid;
	
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
		
		blockOreBauxite = new BlockOreBauxite(Material.rock, 10.0F, 5.0F, 0.0F, "pickaxe", 1);
		registerBlock(blockOreBauxite);
		
		blockLimestone = new BlockLimestone(Material.rock, 5.0F, 3.0F, 0.0F, "pickaxe", 1);
		registerBlock(blockLimestone);
		//Create an OreDicitonary entry
		OreDictionary.registerOre("limestone", blockLimestone);
		
		blockSulfuricAcid = new SulfuricAcid();
		registerBlock(blockSulfuricAcid);
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

package tv.Tunfisch.HardcoreSilicon.Handler;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;

public class CraftingHandler {
	/**
	 * Method for making Shapeless Crafting Recipes, initialized in init()
	 * @param itemStack Item to give as Item
	 * @param quantity Quantity of Items to give as int
	 * @param craftingItems List of Items needed as Array "new Object[]{Item1, Item2, ...}"
	 */
	public static void shapelessCrafting(Item item, int quantity, Object[] craftingItems){
		GameRegistry.addShapelessRecipe(new ItemStack(item, quantity), craftingItems);
	}
	
	/**
	 * Method for making Shaped Crafting Recipes, initialized in preInit()
	 * @param itemStack Item to give as Item
	 * @param quantity Quantity of Items to give as int
	 * @param recipe Description of recipe as Array "new Object[]{"###", "###", "###", '#', definition of #,...}"
	 */
	public static void shapedCrafting(Item item, int quantity, Object[] recipe){
		GameRegistry.addShapedRecipe(new ItemStack(item, quantity), recipe);
	}
	
	public static void shapedCrafting(Block item , int quantity, Object[] recipe){
		GameRegistry.addShapedRecipe(new ItemStack(item, quantity), recipe);
	}

	/**
	 * Registers all Crafting Recipes
	 */
	public static void registerCraftingRecipes() {
		//Examples to replace
		shapelessCrafting(Items.diamond, 8, new Object[]{Blocks.dirt, Blocks.bedrock});
		shapedCrafting(Items.diamond, 8, new Object[]{" # ", " X ", " # ", '#', Blocks.dirt, 'X', Blocks.bedrock});
		GameRegistry.addSmelting(ItemRegister.itemBauxite, new ItemStack(ItemRegister.itemAluminiumIngot, 1), 1.0F);
		//Real recipes
		//Shaped
		shapedCrafting(ItemRegister.swordStainless, 1, new Object[]{" S ", " S ", " I ", 'S', ItemRegister.itemStainlessSteelIngot, 'I', Items.iron_ingot});
		shapedCrafting(ItemRegister.pickaxeStainless, 1, new Object[]{"SSS", " I ", " I ", 'S', ItemRegister.itemStainlessSteelIngot, 'I', Items.iron_ingot});
		shapedCrafting(ItemRegister.axeStainless, 1, new Object[]{"SS ", "SI ", " I ", 'S', ItemRegister.itemStainlessSteelIngot, 'I', Items.iron_ingot});
		shapedCrafting(ItemRegister.shovelStainless, 1, new Object[]{" S ", " I ", " I ", 'S', ItemRegister.itemStainlessSteelIngot, 'I', Items.iron_ingot});
		shapedCrafting(BlockRegister.blockGrinder, 1, new Object[]{"IHI", "PFP", "IEI", 'P', Items.iron_pickaxe, 'E', ItemRegister.itemEmotor, 'F', Blocks.furnace, 'H', Blocks.hopper, 'I', Items.iron_ingot});
		shapedCrafting(BlockRegister.blockElectrolyzer, 1, new Object[]{"IHI", "GBG", "IEI", 'G', Blocks.glass, 'E', ItemRegister.itemEmotor, 'B', Items.bucket, 'H', Blocks.hopper, 'I', Items.iron_ingot});
		shapedCrafting(ItemRegister.itemChromeIngot, 1, new Object[]{"CCC", "CCC", "CCC", 'C', ItemRegister.itemNuggetChrome});
		
		shapedCrafting(BlockRegister.blockBlastFurnace, 1, new Object[]{"SHS", "NFN", "SFS", 'S', ItemRegister.itemStainlessSteelIngot, 'N', Blocks.nether_brick, 'F', Blocks.furnace, 'H', Blocks.hopper});
		
		
		//Shapeless
		shapelessCrafting(ItemRegister.itemNuggetChrome, 9, new Object[]{ItemRegister.itemChromeIngot});
		
	}
	
}

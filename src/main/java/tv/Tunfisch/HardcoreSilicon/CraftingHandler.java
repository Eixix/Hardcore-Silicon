package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

	/**
	 * Registers all Crafting Recipes
	 */
	public static void registerCraftingRecipes() {
		//Examples to replace
		shapelessCrafting(Items.diamond, 8, new Object[]{Blocks.dirt, Blocks.bedrock});
		shapedCrafting(Items.diamond, 8, new Object[]{" # ", " X ", " # ", '#', Blocks.dirt, 'X', BlockRegister.blockOreQuartz});
		//Real recipes
	}
}

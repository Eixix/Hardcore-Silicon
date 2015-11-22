package tv.Tunfisch.HardcoreSilicon.Handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.HSMachineRecipe;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;

public class MachineRecipeHandler {

	private static final MachineRecipeHandler instance = new MachineRecipeHandler();
	private ArrayList<HSMachineRecipe> recipes;

	/**
	 * Manages the recipes of all machines in a Arraylist. Recipes can be added
	 * in the constructor. Note that the recipes are symmetrical e.g. Apple +
	 * Coal equals Coal + Apple, so you only need to register one recipes for
	 * both cases. Some machines take more, others less inputs and outputs. See
	 * the several machines for further information.
	 */
	public MachineRecipeHandler() {
		recipes = new ArrayList();
		// Because coal and an apple turn into diamond via electrolysis.
		// REALISM!
		ItemStack[] in = { new ItemStack(Items.coal), new ItemStack(Items.apple) };
		ItemStack[] out = { new ItemStack(Items.diamond) };
		this.addRecipe(in, out, NameHelper.getName(BlockRegister.blockElectrolyzer));
		
		ItemStack[] input = { new ItemStack(Items.water_bucket), new ItemStack(Items.apple) };
		ItemStack[] output = { new ItemStack(Items.golden_apple) };
		this.addRecipe(input, output, NameHelper.getName(BlockRegister.blockElectrolyzer));

		ItemStack[] in2 = { new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.cobblestone) };
		ItemStack[] out2 = { new ItemStack(Items.apple) };
		this.addRecipe(in2, out2, NameHelper.getName(BlockRegister.blockElectrolyzer));
		
		ItemStack[] in3 = { new ItemStack(ItemRegister.itemSalt), new ItemStack(Items.water_bucket) };
		ItemStack[] out3 = { new ItemStack(ItemRegister.itemSodium) };
		this.addRecipe(in3, out3, NameHelper.getName(BlockRegister.blockElectrolyzer));
		
		ItemStack[] in4 = { new ItemStack(ItemRegister.itemChromeIngot), new ItemStack(Items.iron_ingot) };
		ItemStack[] out4 = { new ItemStack(ItemRegister.itemStainlessSteelIngot) };
		this.addRecipe(in4, out4, NameHelper.getName(BlockRegister.blockElectrolyzer));
	}

	/**
	 * Adds a new machine to the ArrayList by taking the following parameters
	 * @param input As many ItemStacks as the machine can handle for the input [Array]
	 * @param output As many ItemStacks as the machine can handle for the output [Array]
	 * @param machine The name of the machine. To avoid conflicts, just use the NameHelper
	 */
	public void addRecipe(ItemStack[] input, ItemStack[] output, String machine) {
		recipes.add(new HSMachineRecipe(input, output, machine));
	}

	/**
	 * Checks if the given recipe is valid by comparing it to all saved recipes
	 * @param input ItemStack-Array input
	 * @param output ItemStack-Array output
	 * @param machine String machine name (NameHelper)
	 * @return true if the recipe is known by the MachineRecipeHandler
	 */
	public boolean isRecipeValid(ItemStack[] input, ItemStack[] output, String machine) {
		HSMachineRecipe recipe;
		for (int i = 0; i < recipes.size(); i++) {
			recipe = recipes.get(i);
			if (recipe.isRecipeValid(input, output, machine))
				return true;
		}
		return false;
	}

	/**
	 * Returns the output to a given input if its valid.
	 * @param input ItemStack-Array input
	 * @param machine String machine name (Name Helper)
	 * @return
	 */
	public ItemStack[] getOutput(ItemStack[] input, String machine) {
		HSMachineRecipe recipe;
		for (int i = 0; i < recipes.size(); i++) {
			recipe = recipes.get(i);
			// Checks if there is an output
			if (recipe.isRecipeValid(input, recipe.getOutput(), machine))
				return recipe.getOutput();
		}
		// DEBUG-DIAMOND-BLOCKS!
		// ItemStack[] out = {new ItemStack(Blocks.diamond_block), new
		// ItemStack(Blocks.diamond_block)};
		return null;
	}

}
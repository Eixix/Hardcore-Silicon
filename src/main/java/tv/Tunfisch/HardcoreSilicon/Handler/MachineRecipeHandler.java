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
		//Electrolyzer
		this.addElectrolyzerRecipe(new ItemStack(Items.coal), new ItemStack(Items.apple), new ItemStack(Items.diamond));

		//Grinder
		this.addGrinderRecipe(new ItemStack(Items.coal), new ItemStack(Items.apple));
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
	 * Adds an recipe for the Electrolyzer. Easier to use but not as universal
	 * @param input1 ItemStack one input (order does not matter)
	 * @param input2 ItemStack two input (order does not matter)
	 * @param output ItemStack three output
	 */
	public void addElectrolyzerRecipe(ItemStack input1, ItemStack input2, ItemStack output){
		ItemStack[] in = {input1, input2};
		ItemStack[] out = {output};
	    recipes.add(new HSMachineRecipe(in, out, NameHelper.getName(BlockRegister.blockElectrolyzer)));	
	}
	
	/**
	 * Adds an recipe for the Grinder. Easier to use but not as universal
	 * @param input ItemStack one input
	 * @param output ItemStack two output
	 */
	public void addGrinderRecipe(ItemStack input, ItemStack output){
		ItemStack[] in = {input};
		ItemStack[] out = {output};
	    recipes.add(new HSMachineRecipe(in, out, NameHelper.getName(BlockRegister.blockGrinder)));	
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
	
	public boolean containsInput(ItemStack inputItem, String machine){
		for(int i = 0; i < recipes.size(); i++){
			HSMachineRecipe recipe = recipes.get(i);
			if(recipe.containsInput(inputItem, machine)) return true;
		}
		return false;
	}

}
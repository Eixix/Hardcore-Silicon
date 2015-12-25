package tv.Tunfisch.HardcoreSilicon.Handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.HSMachineRecipe;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Items.ItemQuartzCrystal;
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
		this.addElectrolyzerRecipe(new ItemStack(Items.coal), new ItemStack(Items.apple), new ItemStack(Items.diamond), 0.5);
		this.addElectrolyzerRecipe(new ItemStack(Items.water_bucket), new ItemStack(ItemRegister.itemSalt), new ItemStack(ItemRegister.itemSodium),1);

		//Grinder
		this.addGrinderRecipe(new ItemStack(Items.coal), new ItemStack(Items.apple, 5),0.5);
		this.addGrinderRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.ANDESITE.getMetadata()), new ItemStack(ItemRegister.itemAndesiteDust),1);
		this.addGrinderRecipe(new ItemStack(BlockRegister.blockOreChromite), new ItemStack(ItemRegister.itemChromite),1);
		this.addGrinderRecipe(new ItemStack(ItemRegister.itemStainlessSteelIngot), new ItemStack(ItemRegister.itemStainlessSteelDust),1);
		this.addGrinderRecipe(new ItemStack(ItemRegister.itemQuartzCrystal), new ItemStack(ItemRegister.itemQuartzDust),1);
		//this.addGrinderRecipe(new ItemStack(), new ItemStack());
		//Blast Furnace
		this.addBlastFurnaceRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.ANDESITE.getMetadata()),
				                   new ItemStack(Blocks.stone, 2, BlockStone.EnumType.DIORITE.getMetadata()),
				                   new ItemStack(Blocks.stone, 2, BlockStone.EnumType.GRANITE.getMetadata()),
								   new ItemStack(Blocks.stone, 10), new ItemStack(Blocks.sand, 10), 0.5, 0.25);
	}

	/**
	 * Adds a new machine to the ArrayList by taking the following parameters
	 * @param input As many ItemStacks as the machine can handle for the input [Array]
	 * @param output As many ItemStacks as the machine can handle for the output [Array]
	 * @param machine The name of the machine. To avoid conflicts, just use the NameHelper
	 */
	public void addRecipe(ItemStack[] input, ItemStack[] output, double[] outputChanches, String machine) {
		recipes.add(new HSMachineRecipe(input, output, outputChanches, machine));
	}
	
	/**
	 * Adds an recipe for the Electrolyzer. Easier to use but not as universal
	 * @param input1 ItemStack one input (order does not matter)
	 * @param input2 ItemStack two input (order does not matter)
	 * @param output ItemStack three output
	 */
	public void addElectrolyzerRecipe(ItemStack input1, ItemStack input2, ItemStack output, double outputChanche){
		ItemStack[] in = {input1, input2};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, NameHelper.getName(BlockRegister.blockElectrolyzer)));	
	}
	
	/**
	 * Adds an recipe for the Grinder. Easier to use but not as universal
	 * @param input ItemStack one input
	 * @param output ItemStack two output
	 */
	public void addGrinderRecipe(ItemStack input, ItemStack output, double outputChanche){
		ItemStack[] in = {input};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, NameHelper.getName(BlockRegister.blockGrinder)));	
	}
	
	
	/**
	 * Adds an recipe for the Blast Furnace. Easier to use but not as universal
	 * @param input1  ItemStack one input (order does not matter)
	 * @param input2  ItemStack two input (order does not matter)
	 * @param input3  ItemStack three input (order does not matter)
	 * @param output1 ItemStack four output
	 * @param output2 ItemStack five output
	 */
	
	public void addBlastFurnaceRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output1, ItemStack output2, double outputChanche1, double outputChanche2){
		ItemStack[] in = {input1, input2, input3};
		ItemStack[] out = {output1, output2};
		double[] chanches = {outputChanche1, outputChanche2};
	    recipes.add(new HSMachineRecipe(in, out, chanches, NameHelper.getName(BlockRegister.blockBlastFurnace)));	
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
	
	public double getOutputChanche(ItemStack[] input, ItemStack output, String machine){
		HSMachineRecipe recipe;
		for (int i = 0; i < recipes.size(); i++) {
			recipe = recipes.get(i);
			// Checks if there is an output
			if (recipe.isRecipeValid(input, recipe.getOutput(), machine))
				return recipe.getOutputChanche(output);
		}
		return 0.0;
	}

}
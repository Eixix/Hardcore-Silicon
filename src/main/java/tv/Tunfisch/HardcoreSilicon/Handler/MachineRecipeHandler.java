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
		this.addGrinderRecipe(new ItemStack(Items.coal,5), new ItemStack(Items.apple, 5),0.5);
		this.addGrinderRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.ANDESITE.getMetadata()), new ItemStack(ItemRegister.itemAndesiteDust),1);
		this.addGrinderRecipe(new ItemStack(BlockRegister.blockOreChromite), new ItemStack(ItemRegister.itemChromite),1);
		this.addGrinderRecipe(new ItemStack(ItemRegister.itemStainlessSteelIngot), new ItemStack(ItemRegister.itemStainlessSteelDust),1);
		this.addGrinderRecipe(new ItemStack(ItemRegister.itemQuartzCrystal), new ItemStack(ItemRegister.itemQuartzDust),1);
		//this.addGrinderRecipe(new ItemStack(), new ItemStack());
		//UVR
		//Put as stack size 0 in the first input slot, as it will be the template and should not be consumed
		this.addUVRRecipe(new ItemStack(Items.coal, 0),  new ItemStack(Items.apple), new ItemStack(Items.glowstone_dust, 10), 0.8);
		//Crystalizer
		this.addCrystalizerRecipe(new ItemStack(Items.coal), new ItemStack(Items.diamond), 1);
		//Blast Furnace
		this.addBlastFurnaceRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.ANDESITE.getMetadata()),
				                   new ItemStack(Blocks.stone, 2, BlockStone.EnumType.DIORITE.getMetadata()),
				                   new ItemStack(Blocks.stone, 2, BlockStone.EnumType.GRANITE.getMetadata()),
								   new ItemStack(Blocks.stone, 10), new ItemStack(Blocks.sand, 10), 0.5, 0.25);

		
		//Iron
		this.addBlastFurnaceRecipe(new ItemStack(BlockRegister.blockLimestone, 2),
                					new ItemStack(Blocks.iron_ore),
                					new ItemStack(Items.coal),
                					new ItemStack(Items.iron_ingot, 3), new ItemStack(ItemRegister.itemSlag, 3), 1.0, 0.75);
		//Gold
		this.addBlastFurnaceRecipe(new ItemStack(BlockRegister.blockLimestone, 2),
				new ItemStack(Blocks.gold_ore),
				new ItemStack(Items.coal),
				new ItemStack(Items.gold_ingot, 3), new ItemStack(ItemRegister.itemSlag, 3), 1.0, 0.75);
		//MillingMachine
		this.addMillingMachineRecipe(new ItemStack(Items.apple), new ItemStack(Items.apple),
									 new ItemStack(Items.clock), new ItemStack(Items.apple), new ItemStack(Items.apple), 0.5, 0.7, 0.1);
		//Assembler
		this.addAssemblerRecipe(new ItemStack(Items.coal), new ItemStack(Blocks.coal_block), new ItemStack(ItemRegister.itemCoalDust), new ItemStack(Items.diamond), 1);
	}

	/**
	 * Adds a new machine to the ArrayList by taking the following parameters
	 * @param input As many ItemStacks as the machine can handle for the input [Array]
	 * @param output As many ItemStacks as the machine can handle for the output [Array]
	 * @param machine The name of the machine. To avoid conflicts, just use the NameHelper
	 */
	private void addRecipe(ItemStack[] input, ItemStack[] output, double[] outputChanches, String machine) {
		recipes.add(new HSMachineRecipe(input, output, outputChanches, machine));
	}
	
	/**
	 * Adds an recipe for the Electrolyzer. Easier to use but not as universal
	 * @param input1 ItemStack one input (order does not matter)
	 * @param input2 ItemStack two input (order does not matter)
	 * @param output ItemStack three output
	 */
	private void addElectrolyzerRecipe(ItemStack input1, ItemStack input2, ItemStack output, double outputChanche){
		ItemStack[] in = {input1, input2};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockElectrolyzer.name"));	
	}
	
	/**
	 * Adds an recipe for the UVR. Easier to use but not as universal
	 * @param input1 ItemStack one input (order does not matter)
	 * @param input2 ItemStack two input (order does not matter)
	 * @param output ItemStack three output
	 */
	private void addUVRRecipe(ItemStack input1, ItemStack input2, ItemStack output, double outputChanche){
		ItemStack[] in = {input1, input2};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockUVR.name"));	
	}
	
	/**
	 * Adds an recipe for the Crystalizer. Easier to use but not as universal
	 * @param input ItemStack one input (order does not matter)
	 * @param output ItemStack three output
	 */
	private void addCrystalizerRecipe(ItemStack input, ItemStack output, double outputChanche){
		ItemStack[] in = {input};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockCrystalizer.name"));	
	}
	
	/**
	 * Adds an recipe for the Grinder. Easier to use but not as universal
	 * @param input ItemStack one input
	 * @param output ItemStack two output
	 */
	private void addGrinderRecipe(ItemStack input, ItemStack output, double outputChanche){
		ItemStack[] in = {input};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockGrinder.name"));	
	}
	
	
	/**
	 * Adds an recipe for the Blast Furnace. Easier to use but not as universal
	 * @param input1  ItemStack one input (order does not matter)
	 * @param input2  ItemStack two input (order does not matter)
	 * @param input3  ItemStack three input (order does not matter)
	 * @param output1 ItemStack four output
	 * @param output2 ItemStack five output
	 */
	
	private void addBlastFurnaceRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output1, ItemStack output2, double outputChanche1, double outputChanche2){
		ItemStack[] in = {input1, input2, input3};
		ItemStack[] out = {output1, output2};
		double[] chanches = {outputChanche1, outputChanche2};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockBlastFurnace.name"));	
	}
	
	/**
	 * Adds an recipe for the Blast Furnace. Easier to use but not as universal
	 * @param input1  ItemStack one input (order does not matter)
	 * @param input2  ItemStack two input (order does not matter)
	 * @param output1 ItemStack three output
	 * @param output2 ItemStack four output
	 * @param output3 ItemStack five output
	 */
	
	private void addMillingMachineRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, ItemStack output3, double outputChanche1, double outputChanche2, double outputChanche3){
		ItemStack[] in = {input1, input2};
		ItemStack[] out = {output1, output2, output3};
		double[] chanches = {outputChanche1, outputChanche2, outputChanche3};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockMillingMachine.name"));	
	}
	
	/**
	 * Adds an recipe for the Blast Furnace. Easier to use but not as universal
	 * @param input1  ItemStack one input (order does not matter)
	 * @param input2  ItemStack two input (order does not matter)
	 * @param input3  ItemStack three input (order does not matter)
	 * @param output1 ItemStack four output
	 * @param output2 ItemStack five output
	 */
	
	private void addAssemblerRecipe(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output, double outputChanche){
		ItemStack[] in = {input1, input2, input3};
		ItemStack[] out = {output};
		double[] chanches = {outputChanche};
	    recipes.add(new HSMachineRecipe(in, out, chanches, "tile.BlockAssembler.name"));	
	}

	/**
	 * Searches for the Recipe with the given input and machine.
	 * @param input Inputstack array
	 * @param machine Machine name
	 * @return HSMachineRecipe if found, null else
	 */
	public HSMachineRecipe getRecipe(ItemStack[] input, String machine){
		HSMachineRecipe recipe;
		for (int i = 0; i < recipes.size(); i++) {
			recipe = recipes.get(i);
			if (recipe.isRecipeValid(input, machine))
				return recipe;
		}
		return null;
	}


}
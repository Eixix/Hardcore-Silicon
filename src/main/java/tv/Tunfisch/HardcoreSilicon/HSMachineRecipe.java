package tv.Tunfisch.HardcoreSilicon;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class HSMachineRecipe {

	private ItemStack[] input;
	private ItemStack[] output;
	private HashMap<ItemStack, Double> outputToChanche = new HashMap<ItemStack, Double>();
	private String machine;

	public HSMachineRecipe(ItemStack[] inputStacks, ItemStack[] outputStacks, double[] outputChanche, String machineName) {
		//Copy parameters
		input = inputStacks.clone();
		output = outputStacks.clone();
		machine = machineName;
		//Get chances
		for(int i = 0; i < output.length; i++){
			outputToChanche.put(output[i], outputChanche[i]);
		}
	}

	/**
	 * Compares the given input to the saved input by comparing the length and
	 * the content of the Arrays
	 * 
	 * @param inputStacks
	 *            The inputStack to compare to
	 * @return true if the Arrays contain the same Stacks
	 */
	private boolean isRecipeInputEqualTo(ItemStack[] inputStacks) {
		// Check if the length is the same
		if (input.length != inputStacks.length) {
			return false;
		} else {
			// Check if ItemStacks are equal
			int counter = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i].isItemEqual(inputStacks[i]))
					counter++;
			}
			return counter >= input.length;
		}
	}

	/**
	 * Changes the order of the elements inside the array by one. i = i+1
	 * 
	 * @param inputStack
	 *            The stack to be shifted
	 * @return The same array with elements placed 1index further
	 */
	private ItemStack[] shiftPosition(ItemStack[] inputStack) {
		ItemStack[] shiftedStack = new ItemStack[inputStack.length];
		for (int i = 0; i < inputStack.length; i++) {
			if (i + 1 < inputStack.length)
				shiftedStack[i + 1] = inputStack[i];
			else
				shiftedStack[0] = inputStack[i];
		}
		return shiftedStack;
	}

	/**
	 * Compares the given output to the saved output by comparing the length and
	 * the content of the Arrays
	 * 
	 * @param outputStacks
	 *            The outputStack to compare to
	 * @return true if the Arrays contain the same Stacks
	 */
	private boolean isRecipeOutputEqualTo(ItemStack[] outputStacks) {
		// Check if the length is the same
		if (output.length != outputStacks.length) {
			return false;
		} else {
			// Check if ItemStacks are equal
			int counter = 0;
			for (int i = 0; i < output.length; i++) {
				if (output[i].isItemEqual(outputStacks[i]))
					counter++;
			}
			return counter >= output.length;
		}
	}
	
	/**
	 * Checks if the given itemStacks match a recipe. Makes use of the private
	 * methods to look easy and clean.
	 * 
	 * @param inputStacks
	 *            The itemStack resembling the input
	 * @param outputStacks
	 *            The itemStack resembling the output
	 * @param machineName
	 *            The name of the machine
	 * @return true if the input, the output and the machineName are met
	 */
	public boolean isRecipeValid(ItemStack[] inputStacks, ItemStack[] outputStacks, String machineName) {
		boolean inputValid = this.isRecipeInputEqualTo(inputStacks);
		// This makes the recipe symmetrical
	    boolean inputShiftedValid = this.isRecipeInputEqualTo(this.shiftPosition(inputStacks));
		boolean outputValid = this.isRecipeOutputEqualTo(outputStacks);
		boolean outputShiftedValid = this.isRecipeOutputEqualTo(this.shiftPosition(outputStacks));
		boolean machineValid = machine.equals(machineName);
		boolean valid = inputValid && outputValid && machineValid;
		boolean shiftedValid = inputShiftedValid && outputShiftedValid && machineValid;
		return valid || shiftedValid;
	}

	public ItemStack[] getInput() {
		return input;
	}

	public ItemStack[] getOutput() {
		return output;
	}

	public String getMachineName() {
		return machine;
	}
	
	public double getOutputChanche(ItemStack outputStack){
		for(int i = 0; i< output.length;i++){
			if(output[i].getIsItemStackEqual(outputStack)) return outputToChanche.get(output[i]);
		}
		return 0.0;
	}

}

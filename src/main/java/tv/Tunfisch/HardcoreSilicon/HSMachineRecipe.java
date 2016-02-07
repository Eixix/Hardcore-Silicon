package tv.Tunfisch.HardcoreSilicon;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class HSMachineRecipe {

	private ItemStack[] input;
	private ItemStack[] output;
	private double[] chanches;
	private String machine;

	public HSMachineRecipe(ItemStack[] inputStacks, ItemStack[] outputStacks, double[] outputChanche,
			String machineName) {
		// Copy parameters
		input = inputStacks.clone();
		output = outputStacks.clone();
		chanches = outputChanche.clone();
		machine = machineName;
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
		if (input.length != inputStacks.length)
			return false;
		// Check if ItemStacks are equal
		for (int i = 0; i < input.length; i++) {
			if (!input[i].isItemEqual(inputStacks[i]) || input[i].stackSize > inputStacks[i].stackSize)
				return false;
		}
		return true;
	}

	/**
	 * Checks iterative and recursively if the Recipe is correct.
	 * 
	 * @param in
	 *            InputStack
	 * @param shifted
	 *            true if it has been shifted
	 * @return true on a correct recipe
	 */
	private boolean isRecipeEqual(ItemStack[] in, boolean shifted) {
		ItemStack[] stack = in.clone();
		// Check all ItemStacks
		for (int i = 0; i < in.length; i++) {
			if (isRecipeInputEqualTo(stack))
				return true;

			// Shift positions
			stack = this.shiftPosition(stack);
		}
		// Switch out last two itemstacks and do it again
		if (stack.length > 2 && !shifted) {
			ItemStack temp = stack[stack.length - 1];
			stack[stack.length - 1] = stack[stack.length - 2];
			stack[stack.length - 2] = temp;
			return this.isRecipeEqual(stack, true);
		}
		return false;
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
	public boolean isRecipeValid(ItemStack[] inputStacks, String machineName) {
		boolean inputValid = this.isRecipeEqual(inputStacks, false);
		boolean machineValid = machine.equals(machineName);
		return inputValid && machineValid;
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

	public double getOutputChanche(ItemStack outputStack) {
		for (int i = 0; i < output.length; i++) {
			if (output[i].getIsItemStackEqual(outputStack))
				return chanches[i];
		}
		return 0.0;
	}

}

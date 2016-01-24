package tv.Tunfisch.HardcoreSilicon;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class HSMachineRecipe {

	private ItemStack[] input;
	private ItemStack[] output;
	private HashMap<ItemStack, Double> outputToChanche = new HashMap<ItemStack, Double>();
	private String machine;

	public HSMachineRecipe(ItemStack[] inputStacks, ItemStack[] outputStacks, double[] outputChanche,
			String machineName) {
		// Copy parameters
		input = inputStacks.clone();
		output = outputStacks.clone();
		machine = machineName;
		// Get chances
		for (int i = 0; i < output.length; i++) {
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
		if (input.length != inputStacks.length)
			return false;
		// Check if ItemStacks are equal
		for (int i = 0; i < input.length; i++) {
			if (!input[i].isItemEqual(inputStacks[i]))
				return false;
		}
		return true;
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
		if (output.length != outputStacks.length)
			return false;
		// Check if ItemStacks are equal
		for (int i = 0; i < output.length; i++) {
			if (!output[i].isItemEqual(outputStacks[i]))
				return false;
		}
		return true;
	}

	/**
	 * Checks iterative and recursively if the Recipe is correct.
	 * @param in InputStack
	 * @param input true if input, false if output
	 * @param shifted true if it has been shifted
	 * @return true on a correct recipe
	 */
	private boolean isRecipeEqual(ItemStack[] in, boolean input, boolean shifted) {
		ItemStack[] stack = in.clone();
		//Check all ItemStacks
		for (int i = 0; i < in.length; i++) {
			if (input) {
				if (isRecipeInputEqualTo(stack))
					return true;
			} else {
				if (isRecipeOutputEqualTo(stack))
					return true;
			}
			//Shift positions
			stack = this.shiftPosition(stack);
		}
		// Switch out last two itemstacks and do it again
		if (stack.length > 2 && !shifted) {
			ItemStack temp = stack[stack.length - 1];
			stack[stack.length - 1] = stack[stack.length - 2];
			stack[stack.length - 2] = temp;
			return this.isRecipeEqual(stack, input, true);
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
	public boolean isRecipeValid(ItemStack[] inputStacks, ItemStack[] outputStacks, String machineName) {
		boolean inputValid = this.isRecipeEqual(inputStacks, true, false);
		boolean outputValid = this.isRecipeEqual(outputStacks, false, false);
		boolean machineValid = machine.equals(machineName);
		return inputValid && outputValid && machineValid;
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
				return outputToChanche.get(output[i]);
		}
		return 0.0;
	}

}

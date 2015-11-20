package tv.Tunfisch.HardcoreSilicon.Grinder;

import net.minecraft.item.ItemStack;

public class HSRecipe {

	private ItemStack[] input;
	private ItemStack[] output;
	private String machine;

	public HSRecipe(ItemStack[] inputStacks, ItemStack[] outputStacks, String machineName) {
		input = inputStacks.clone();
		output = outputStacks.clone();
		machine = machineName;
	}

	/**
	 * Compares the given input to the saved input by comparing the length and the content of the Arrays
	 * @param inputStacks The inputStack to compare to
	 * @return true if the Arrays contain the same Stacks
	 */
	private boolean isRecipeInputEqualTo(ItemStack[] inputStacks) {
		// Check if the length is the same
		if (input.length != inputStacks.length){
			System.out.println("Ungleiche länge: " + input.length + "!=" + inputStacks.length);
			return false;
		}else {
			// Check if ItemStacks are equal
			int counter = 0;
			for (int i = 0; i < input.length; i++) {
				for (int j = i; j < inputStacks.length; j++) {
					if (input[i].isItemEqual(inputStacks[j])) {
						counter++;
					}
				}
			}
			return counter >= input.length;
		}
	}
	
	/**
	 * Compares the given output to the saved output by comparing the length and the content of the Arrays
	 * @param outputStacks The outputStack to compare to
	 * @return true if the Arrays contain the same Stacks
	 */
	private boolean isRecipeOutputEqualTo(ItemStack[] outputStacks) {
		// Check if the length is the same
		if (output.length != outputStacks.length){
			System.out.println("ungleiche länge!");
			return false;
		}else {
			// Check if ItemStacks are equal
			int counter = 0;
			for (int i = 0; i < output.length; i++) {
				for (int j = i; j < outputStacks.length; j++) {
					if (output[i].isItemEqual(outputStacks[j])) {
						counter++;
					}
				}
			}
			return counter >= output.length;
		}
	}
	
	/**
	 * Checks if the given itemStacks match a recipe.
	 * Makes use of the private methods to look easy and clean.
	 * @param inputStacks The itemStack resembling the input
	 * @param outputStacks The itemStack resembling the output
	 * @param machineName The name of the machine
	 * @return
	 */
	public boolean isRecipeValid(ItemStack[] inputStacks, ItemStack[] outputStacks, String machineName){
		
		boolean inputValid = this.isRecipeInputEqualTo(inputStacks);
		boolean outputValid = this.isRecipeOutputEqualTo(outputStacks);
		boolean machineValid = machine.equals(machineName);
		boolean valid = inputValid && outputValid && machineValid;
		/* DEBUG
		if(inputValid) System.out.println("Input valid");
		if(outputValid) System.out.println("Output valid");
		if(machineValid) System.out.println("Machine valid");
		if(valid) System.out.println("Recipe valid");
		else System.out.println("Recipe invalid"); */
		return valid;
	}

	public ItemStack[] getInput() {
		return input;
	}

	public ItemStack[] getOutput() {
		return output;
	}
	
	public String getMachineName(){
		return machine;
	}

}

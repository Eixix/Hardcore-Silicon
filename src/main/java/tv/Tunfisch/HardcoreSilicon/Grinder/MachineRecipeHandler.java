package tv.Tunfisch.HardcoreSilicon.Grinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.NameHelper;

public class MachineRecipeHandler {
	
	  private static final MachineRecipeHandler instance = new MachineRecipeHandler();
      private ArrayList<HSRecipe> recipes;
      
      public MachineRecipeHandler(){
    	  recipes = new ArrayList();
    	  //ItemStack[] in = { new ItemStack(Items.coal)};
    	  //ItemStack[] out = { new ItemStack(Items.apple)};
    	  //this.addRecipe(in, out, NameHelper.getName(BlockRegister.blockElectrolyzer));
    	  //
    	  ItemStack[] in2 = { new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.cobblestone)};
    	  ItemStack[] out2 = { new ItemStack(Items.apple, 2)};
    	  this.addRecipe(in2, out2, NameHelper.getName(BlockRegister.blockElectrolyzer));
      }
      
      public void addRecipe(ItemStack[] input, ItemStack[] output, String machine){
    	  recipes.add(new HSRecipe(input, output, machine));
      }
      
      public boolean isRecipeValid(ItemStack[] input, ItemStack[] output, String machine){
    	HSRecipe recipe;
  		for(int i = 0; i < recipes.size(); i++){
  			recipe = recipes.get(i);
  			if(recipe.isRecipeValid(input, output, machine)) return true;
  		}
  		return false;
      }
      
      public ItemStack[] getOutput(ItemStack[] input, String machine){
    	  HSRecipe recipe;
    		for(int i = 0; i < recipes.size(); i++){
    			recipe = recipes.get(i);
    			//Checks if there is an output
    			if(recipe.isRecipeValid(input, recipe.getOutput(), machine)) return recipe.getOutput();
    		}
    		//DEBUG-DIAMOND-BLOCKS!
    		//ItemStack[] out = {new  ItemStack(Blocks.diamond_block), new  ItemStack(Blocks.diamond_block)};
    		return null;
      }
      
}

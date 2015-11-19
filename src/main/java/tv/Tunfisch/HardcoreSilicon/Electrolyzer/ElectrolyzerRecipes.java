package tv.Tunfisch.HardcoreSilicon.Electrolyzer;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.ItemRegister;

public class ElectrolyzerRecipes {
	private static final ElectrolyzerRecipes electrolyzingBase = new ElectrolyzerRecipes();
	/** The list of grinding results. */
	private final Map grindingList = Maps.newHashMap();
	private ItemStack[][][] recipes = new ItemStack[1][1][1];
	private final Map experienceList = Maps.newHashMap();

	public static ElectrolyzerRecipes instance() {
		return electrolyzingBase;
	}

	private ElectrolyzerRecipes() {
		
	}
	
	private void addRecipe(ItemStack in1, ItemStack in2, ItemStack out){
		// TODO addRecipe
	}

	
	private boolean areItemStacksEqual(ItemStack parItemStack1,ItemStack parItemStack2) {
		return parItemStack2.getItem() == parItemStack1.getItem() && (parItemStack2.getMetadata() == 32767 || parItemStack2.getMetadata() == parItemStack1.getMetadata());
	}


	public float getGrindingExperience(ItemStack parItemStack) {
		Iterator iterator = experienceList.entrySet().iterator();
		Entry entry;
		do {
			if (!iterator.hasNext()) return 0.0F; 
			entry = (Entry) iterator.next();
		} while (!areItemStacksEqual(parItemStack,(ItemStack) entry.getKey()));
		return ((Float) entry.getValue()).floatValue();
	}

	public ItemStack getGrindingResult(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return null;
	}
}

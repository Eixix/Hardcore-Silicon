package tv.Tunfisch.HardcoreSilicon.Slots;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;

public class SlotWhitelist extends Slot{
	
private Item[] whitelist;
	
	public SlotWhitelist(IInventory parIInventory, int parSlotIndex,
			int parXDisplayPosition, int parYDisplayPosition, Item[] whitelist) {
		super(parIInventory, parSlotIndex, parXDisplayPosition, parYDisplayPosition);
		//Clone
		this.whitelist = whitelist.clone();
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return isAllowed(stack);
	}
	
	public boolean isAllowed(ItemStack stack){
		for(Item i : whitelist){
			if(stack.getItem() == i) return true;
		}
		return false;
	}
}

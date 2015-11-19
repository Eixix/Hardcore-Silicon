package tv.Tunfisch.HardcoreSilicon.Grinder;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.ItemRegister;
public class SlotGrinderFuel extends Slot{
	
	private ArrayList fuelList;
	
	public SlotGrinderFuel(IInventory parIInventory, int parSlotIndex,
			int parXDisplayPosition, int parYDisplayPosition) {
		super(parIInventory, parSlotIndex, parXDisplayPosition, parYDisplayPosition);
		fuelList = new ArrayList();
		//Fill fuelList
		fuelList.add(Items.coal);
		fuelList.add(ItemRegister.itemEmotor);
	}
	

	@Override
	public boolean isItemValid(ItemStack stack) {
		for(int i = 0; i < fuelList.size(); i++){
			if(stack.getItem() == (net.minecraft.item.Item)fuelList.get(i)) return true;
		}
		return false;
	}

}

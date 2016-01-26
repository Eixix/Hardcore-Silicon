package tv.Tunfisch.HardcoreSilicon.Slots;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;
public class SlotWater extends Slot{

	
	public SlotWater(IInventory parIInventory, int parSlotIndex,
			int parXDisplayPosition, int parYDisplayPosition) {
		super(parIInventory, parSlotIndex, parXDisplayPosition, parYDisplayPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
			return stack.getItem() == Items.water_bucket;
	}
}

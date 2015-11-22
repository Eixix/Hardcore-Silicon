package tv.Tunfisch.HardcoreSilicon.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * A simple Slot that does not allow any inputs/ item placed in it
 *
 */
public class SlotOutput extends Slot {

	public SlotOutput(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false; // can't place anything into it
	}

}

package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		//200 ticks = 10 seconds = 1 item
		
		return 0;
	}

}

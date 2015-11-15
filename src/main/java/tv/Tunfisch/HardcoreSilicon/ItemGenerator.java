package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGenerator extends Item {
	
	public ItemGenerator(){
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName("ItemGenerator");
		setTextureName("HardcoreSilicon:ItemGenerator");
		
	}

}

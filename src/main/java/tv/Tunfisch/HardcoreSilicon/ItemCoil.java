package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCoil extends Item {
	
	public ItemCoil(){
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName("ItemCoil");
		setTextureName("HardcoreSilicon:ItemCoil");
		
	}

}

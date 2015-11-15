package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBasicBoard extends Item {
	
	public ItemBasicBoard(){
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName("ItemBasicBoard");
		setTextureName("HardcoreSilicon:ItemBasicBoard");
		
	}

}

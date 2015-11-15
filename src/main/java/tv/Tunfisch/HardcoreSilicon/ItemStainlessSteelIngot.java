package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemStainlessSteelIngot extends Item {
	
	public ItemStainlessSteelIngot(){
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName("ItemStainlessSteelIngot");
		setTextureName("HardcoreSilicon:ItemStainlessSteel");
		
	}

}

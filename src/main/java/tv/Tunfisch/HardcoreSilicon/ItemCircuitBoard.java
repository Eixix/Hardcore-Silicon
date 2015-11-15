package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCircuitBoard extends Item {
	
	public ItemCircuitBoard(){
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName("ItemCircuitBoard");
		//setTextureName("HardcoreSilicon:ItemCircuitBoard");
		
	}

}

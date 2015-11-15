package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemShovelStainlessSteel extends ItemSpade {

	public ItemShovelStainlessSteel(ToolMaterial material) {
		super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3, 8421, 15.0F, 8.0F, 20));
		setCreativeTab(CreativeTabs.tabTools);
		//setTextureName("HardcoreSilicon:ItemShovelStainlessSteel");
		
	}
	

		
	

}
//super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3,		 8421,		 13.0F, 		10.0F, 			20));
//                                  MATERIAL        Stufe	MAX USES	Effizienz	Angriffschaden	Enchanten
//   												3=DIA				gegen
//																		Blöcke




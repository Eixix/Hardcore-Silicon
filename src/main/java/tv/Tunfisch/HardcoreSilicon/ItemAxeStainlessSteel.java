package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemAxeStainlessSteel extends ItemAxe {

	public ItemAxeStainlessSteel(ToolMaterial material) {
		super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3, 8421, 13.0F, 11.0F, 20));
		setCreativeTab(CreativeTabs.tabTools);
		//setTextureName("HardcoreSilicon:ItemAxeStainlessSteel");
		
	}
	

		
	

}
//super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3,		 8421,		 10.0F, 		14.0F, 			20));
//                                  MATERIAL        Stufe	MAX USES	Effizienz	Angriffschaden
//   												3=DIA				gegen
//																		Bl�cke

package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSwordStainlessSteel extends ItemSword {

	public ItemSwordStainlessSteel(ToolMaterial material) {
		super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3, 8421, 5.0F, 12.0F, 20));
		setCreativeTab(CreativeTabs.tabCombat);
		setTextureName("HardcoreSilicon:ItemSwordStainlessSteel");
		
	}
	

		
	

}
//super(EnumHelper.addToolMaterial("STAINLESSSTEEL", 3,		 8421,		 10.0F, 		14.0F, 			20));
//                                  MATERIAL        Stufe	MAX USES	Effizienz	Angriffschaden
//   												3=DIA				gegen
//																		Blöcke

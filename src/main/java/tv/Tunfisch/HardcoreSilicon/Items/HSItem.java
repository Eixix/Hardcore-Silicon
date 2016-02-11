package tv.Tunfisch.HardcoreSilicon.Items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;

public class HSItem extends Item {
	
	private String name;

	public HSItem(String name){
		this.name = name;
		ItemRegister.itemList.add(this);
		if(this.getCreativeTab() == null || this.getCreativeTab().getTabIndex() < 10)this.setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
	
	public HSItem(String name, int maxStackSize){
		this(name);
		this.setMaxStackSize(maxStackSize);
	}
	
	public String getName(){
		return name;
	}
	
}

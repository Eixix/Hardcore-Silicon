package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {
	
	public static void registerItemRenderer() {
	     //Place Items here	
    }
	
	public static void itemRenderRegister(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(Utility.getTextureName(item), "inventory"));
	}
}

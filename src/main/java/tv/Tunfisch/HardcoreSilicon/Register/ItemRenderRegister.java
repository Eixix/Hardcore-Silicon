package tv.Tunfisch.HardcoreSilicon.Register;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Items.HSItem;

/**
 * This class registers all item-textures with the absurdly long method.
 */
public final class ItemRenderRegister {
	
	/**
	 * Registers all given items to the right texture.
	 */
	public static void registerItemRenderer() {
	    //TOOLS
		itemRenderRegister(ItemRegister.swordStainless);
		itemRenderRegister(ItemRegister.pickaxeStainless);
		itemRenderRegister(ItemRegister.axeStainless);
		itemRenderRegister(ItemRegister.shovelStainless);
		//ITEMS
		for(HSItem item : ItemRegister.itemList){
			itemRenderRegister(item);
		}
		//Special Items
		itemRenderRegister(ItemRegister.itemSodium);
    }
	
	/**
	 * Makes use of the absurdly long method in order to link the texture to the given item.
	 * @param item Item that needs a texture
	 */
	private static void itemRenderRegister(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(NameHelper.getTextureName(item), "inventory"));
	}
	
	/**
	 * Makes use of the absurdly long method in order to link the texture to the given item.
	 * @param item Item that needs a texture
	 */
	private static void itemRenderRegister(HSItem item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(NameHelper.getTextureName(item.getName()), "inventory"));
	}
}

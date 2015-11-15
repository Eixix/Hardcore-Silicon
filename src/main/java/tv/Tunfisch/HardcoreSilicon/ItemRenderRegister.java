package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {
	
	public static void registerItemRenderer() {
	    //TOOLS
		itemRenderRegister(ItemRegister.swordStainless);
		itemRenderRegister(ItemRegister.pickaxeStainless);
		itemRenderRegister(ItemRegister.axeStainless);
		itemRenderRegister(ItemRegister.shovelStainless);
		//ITEMS		
		itemRenderRegister(ItemRegister.itemSiliconCrystal);
		itemRenderRegister(ItemRegister.itemWaferRaw);
		itemRenderRegister(ItemRegister.itemWaferEtched);
		itemRenderRegister(ItemRegister.itemSiliconRaw);
		itemRenderRegister(ItemRegister.itemQuartzCrystal);
		itemRenderRegister(ItemRegister.itemQuartzDust);
		itemRenderRegister(ItemRegister.itemStainlessSteelIngot);
		itemRenderRegister(ItemRegister.itemStainlessSteelDust);
		itemRenderRegister(ItemRegister.itemCircuitBoard);
		itemRenderRegister(ItemRegister.itemBasicBoard);
		itemRenderRegister(ItemRegister.itemStorageModule128);
		itemRenderRegister(ItemRegister.itemSenseless);
		itemRenderRegister(ItemRegister.itemNandSwitch);
		itemRenderRegister(ItemRegister.itemCoil);
		itemRenderRegister(ItemRegister.itemCoalBrush);
		itemRenderRegister(ItemRegister.itemGenerator);
		itemRenderRegister(ItemRegister.itemEmotor);
		itemRenderRegister(ItemRegister.itemIronOxide);
		itemRenderRegister(ItemRegister.itemOsmiumIron);
    }
	
	private static void itemRenderRegister(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(Utility.getTextureName(item), "inventory"));
	}
}

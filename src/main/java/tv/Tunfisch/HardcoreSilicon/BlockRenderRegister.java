package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * This class registers all block-textures with the absurdly long method.
 */
public class BlockRenderRegister {
	
	/**
	 * Registers all given blocks to the right texture.
	 */
	public static void registerBlocks(){
		blockRenderRegister(BlockRegister.blockOreQuartz);
	}
	
	/**
	 * Makes use of the absurdly long method in order to link the texture to the given block.
	 * @param b Block that needs a texture
	 */
	public static void blockRenderRegister(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Utility.getTextureName(block), "inventory"));
	}
}

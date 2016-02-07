package tv.Tunfisch.HardcoreSilicon.Register;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import tv.Tunfisch.HardcoreSilicon.NameHelper;

/**
 * This class registers all block-textures with the absurdly long method.
 */
public class BlockRenderRegister {
	
	/**
	 * Registers all given blocks to the right texture.
	 */
	public static void registerBlocks(){
		blockRenderRegister(BlockRegister.blockOreQuartz);
		blockRenderRegister(BlockRegister.blockGrinder);
		blockRenderRegister(BlockRegister.blockOreChromite);
		blockRenderRegister(BlockRegister.blockOreSalt);
		blockRenderRegister(BlockRegister.blockElectrolyzer);
		blockRenderRegister(BlockRegister.blockOreBauxite);
		blockRenderRegister(BlockRegister.blockLimestone);
		blockRenderRegister(BlockRegister.blockBlastFurnace);
		blockRenderRegister(BlockRegister.blockCrystalizer);
		blockRenderRegister(BlockRegister.blockUVR);
		blockRenderRegister(BlockRegister.blockMillingMachine);
		blockRenderRegister(BlockRegister.blockAssembler);
		//Fluids
		blockRenderRegister(BlockRegister.blockSulfuricAcid);
	}
	
	/**
	 * Makes use of the absurdly long method in order to link the texture to the given block.
	 * @param b Block that needs a texture
	 */
	public static void blockRenderRegister(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(NameHelper.getTextureName(block), "inventory"));
	}
}

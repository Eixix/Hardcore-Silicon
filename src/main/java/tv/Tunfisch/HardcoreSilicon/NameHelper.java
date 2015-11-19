package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * This class contain various useful methods.
 */
public class NameHelper {

	/**
	 * This method builds the items texture name.
	 * @param i The item which need a texture name
	 * @return The texture name in the order "MOD_ID:ItemName"
	 */
	public static String getTextureName(Item i) {
		return Reference.MOD_ID + ":" + i.getClass().getSimpleName();
	}
	
	/**
	 * This method fetches the name of the item from its class.
	 * @param i Item to get a name from
	 * @return CamelCase item name
	 */
	public static String getName(Item i) {
		return i.getClass().getSimpleName();
	}
	
    /**
	 * This method builds the blocks texture name.
	 * @param b The block which need a texture name
	 * @return The texture name in the order "MOD_ID:BlockName"
	 */
	public static String getTextureName(Block b) {
		return Reference.MOD_ID + ":" + b.getClass().getSimpleName();
	}

	/**
	 * This method fetches the name of the blocks from its class.
	 * @param b Block to get a name from
	 * @return CamelCase block name
	 */
	public static String getName(Block b) {
		return b.getClass().getSimpleName();
	}



}

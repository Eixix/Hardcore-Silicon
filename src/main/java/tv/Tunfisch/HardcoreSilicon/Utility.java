package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * This class contain various useful methods.
 */
public class Utility {

	public static String getTextureName(Item i) {
		return Reference.MOD_ID + ":" + i.getClass().getSimpleName();
	}

	public static String getTextureName(Block b) {
		return Reference.MOD_ID + ":" + b.getClass().getSimpleName();
	}

	public static String getName(Block b) {
		return b.getClass().getSimpleName();
	}

	public static String getName(Item i) {
		return i.getClass().getSimpleName();
	}

}

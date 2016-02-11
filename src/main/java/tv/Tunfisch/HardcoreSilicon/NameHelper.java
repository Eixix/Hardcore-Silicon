package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityBasicMachine;

/**
 * This class contain various useful methods.
 */
public class NameHelper {


	public static String getName(Object o){
		return o.getClass().getSimpleName();
	}
	
	public static String getTextureName(Object o){
		return Reference.MOD_ID + ":" + o.getClass().getSimpleName();
	}
	
	public static String getTextureName(String s){
		return Reference.MOD_ID + ":" + s;
	}

	public static String getTileEntityName(TileEntityBasicMachine t){
		String name = "tile.Block";
		String className = t.getClass().getSimpleName();
		name += className.substring(className.indexOf('y') + 1) + ".name";
		return name;
	}
	
	public static String getNameOnly(TileEntityBasicMachine t){
		//name is e.g. "tile.BlockCrystalizer.name"
    	String name = t.getName();
    	//cut name to e.g. "Crystalizer"
    	return name.substring(name.indexOf("k") + 1, name.lastIndexOf('.'));
	}


}

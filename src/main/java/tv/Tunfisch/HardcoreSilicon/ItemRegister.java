package tv.Tunfisch.HardcoreSilicon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Items.ItemAxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemBasicBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCircuitBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoalBrush;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoil;
import tv.Tunfisch.HardcoreSilicon.Items.ItemEmotor;
import tv.Tunfisch.HardcoreSilicon.Items.ItemGenerator;
import tv.Tunfisch.HardcoreSilicon.Items.ItemIronOxide;
import tv.Tunfisch.HardcoreSilicon.Items.ItemNandSwitch;
import tv.Tunfisch.HardcoreSilicon.Items.ItemOsmiumIron;
import tv.Tunfisch.HardcoreSilicon.Items.ItemPickaxeStainless;
import tv.Tunfisch.HardcoreSilicon.Items.ItemQuartzCrystal;
import tv.Tunfisch.HardcoreSilicon.Items.ItemQuartzDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSenseless;
import tv.Tunfisch.HardcoreSilicon.Items.ItemShovelStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSiliconCrystal;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSiliconRaw;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStainlessSteelDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStainlessSteelIngot;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStorageModule128;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSwordStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferEtched;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferRaw;

public class ItemRegister {
	
	    //TOOLS
		public static Item swordStainless;
		public static Item pickaxeStainless;
		public static Item axeStainless;
		public static Item shovelStainless;
		
		//ITEMS
		
		public static Item itemSiliconCrystal;
		public static Item itemWaferRaw;
		public static Item itemWaferEtched;
		public static Item itemSiliconRaw;
		public static Item itemQuartzCrystal;
		public static Item itemQuartzDust;
		public static Item itemStainlessSteel;
		public static Item itemStainlessSteelIngot;
		public static Item itemCircuitBoard;
		public static Item itemBasicBoard;
		public static Item itemStorageModule128;
		public static Item itemSenseless;
		public static Item itemNandSwitch;
		public static Item itemCoil;
		public static Item itemCoalBrush;
		public static Item itemGenerator;
		public static Item itemEmotor;
		public static Item itemIronOxide;
		public static Item itemOsmiumIron;

		//BLOCKS
		public static Block blockOreQuartz;
        
		public static void registerItems(){
			//WERKZEUG
			swordStainless =  new ItemSwordStainlessSteel();
			registerItem(swordStainless);
			
			pickaxeStainless =  new ItemPickaxeStainless();
			registerItem(pickaxeStainless);
			
			axeStainless =  new ItemAxeStainlessSteel();
			registerItem(axeStainless);
			
			shovelStainless =  new ItemShovelStainlessSteel();
			registerItem(shovelStainless);
			
			//ITEMS
			
			itemSiliconCrystal = new ItemSiliconCrystal();
			registerItem(itemSiliconCrystal);
			
			itemWaferRaw = new ItemWaferRaw();
			registerItem(itemWaferRaw);
			
			itemWaferEtched = new ItemWaferEtched();
			registerItem(itemWaferEtched);
			
			itemSiliconRaw = new ItemSiliconRaw();
			registerItem(itemSiliconRaw);

			itemQuartzCrystal = new ItemQuartzCrystal();
			registerItem(itemQuartzCrystal);
			
			itemQuartzDust = new ItemQuartzDust();
			registerItem(itemQuartzDust);	
			
			itemStainlessSteel = new ItemStainlessSteelDust();
			registerItem(itemStainlessSteel);
			
			itemStainlessSteelIngot = new ItemStainlessSteelIngot();
			registerItem(itemStainlessSteelIngot);
			
			itemCircuitBoard = new ItemCircuitBoard();
			registerItem(itemCircuitBoard);
			
			itemBasicBoard = new ItemBasicBoard();
			registerItem(itemBasicBoard);
			
			itemStorageModule128 = new ItemStorageModule128();
			registerItem(itemStorageModule128);
			
			itemSenseless = new ItemSenseless();
			registerItem(itemSenseless);
			
			itemNandSwitch = new ItemNandSwitch();
			registerItem(itemNandSwitch);
			
			itemIronOxide = new ItemIronOxide();
			registerItem(itemIronOxide);
			
			itemOsmiumIron = new ItemOsmiumIron();
			registerItem(itemOsmiumIron);
			
			itemCoil = new ItemCoil();
			registerItem(itemCoil);
			
			itemCoalBrush = new ItemCoalBrush();
			registerItem(itemCoalBrush);
			
			itemGenerator = new ItemGenerator().setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);
			registerItem(itemGenerator);
			
			itemEmotor = new ItemEmotor().setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);
			registerItem(itemEmotor);
			
			//BLOCKS
			blockOreQuartz = new BlockOreQuartz(Material.rock, 1.0F, 1.0F, 0.0F, "pickaxe", 2);
			//blockOreChrom = new BlockOreQuartz(Material.rock).setBlockTextureName("HardcoreSilicon:BlockOreChrom").setBlockName("BlockOreChrom");
		}
		
		
		public static void registerItem(Item item){
			if(item.getCreativeTab() == null) item.setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
			item.setUnlocalizedName(Utility.getName(item));
			GameRegistry.registerItem(item, Utility.getName(item));
		}
		
}
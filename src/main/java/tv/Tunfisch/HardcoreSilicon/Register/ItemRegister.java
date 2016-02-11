package tv.Tunfisch.HardcoreSilicon.Register;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;
import tv.Tunfisch.HardcoreSilicon.NameHelper;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Items.HSItem;
import tv.Tunfisch.HardcoreSilicon.Items.ItemAxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemPickaxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemShovelStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSodium;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSwordStainlessSteel;


/**
 * This class contains all mod Items and registers them.
 */
public class ItemRegister {
	
		public static ArrayList<HSItem> itemList = new ArrayList<HSItem>();
	
	    //TOOLS
		public static Item swordStainless;
		public static Item pickaxeStainless;
		public static Item axeStainless;
		public static Item shovelStainless;
		
		//ITEMS
		
		public static Item itemSiliconCrystal = new HSItem("ItemSiliconCrystal");
		public static Item itemWaferRaw = new HSItem("ItemWaferRaw");
		public static Item itemWaferEtched = new HSItem("ItemWaferEtched");
		public static Item itemSiliconRaw = new HSItem("ItemSiliconRaw");
		public static Item itemQuartzCrystal = new HSItem("ItemQuartzCrystal");
		public static Item itemQuartzDust = new HSItem("ItemQuartzDust");
		public static Item itemStainlessSteelIngot = new HSItem("ItemStainlessSteelIngot");
		public static Item itemStainlessSteelDust = new HSItem("ItemStainlessSteelDust");
		public static Item itemCircuitBoard = new HSItem("ItemCircuitBoard");
		public static Item itemBasicBoard = new HSItem("ItemBasicBoard");
		public static Item itemStorageModule128 = new HSItem("ItemStorageModule128");
		public static Item itemSenseless = new HSItem("ItemSenseless");
		public static Item itemNandSwitch = new HSItem("ItemNandSwitch");
		public static Item itemCoil = new HSItem("ItemCoil");
		public static Item itemCoalBrush = new HSItem("ItemCoalBrush");
		public static Item itemGenerator = new HSItem("ItemGenerator");
		public static Item itemEmotor = new HSItem("ItemEmotor");
		public static Item itemIronOxide = new HSItem("ItemIronOxide");
		public static Item itemOsmiumIron = new HSItem("ItemOsmiumIron");
		public static Item itemAndesiteDust = new HSItem("ItemAndesiteDust");
		public static Item itemCoalDust = new HSItem("ItemCoalDust");
		public static Item itemChromite = new HSItem("ItemChromite");
		public static Item itemChromate = new HSItem("ItemChromate");
		public static Item itemSalt = new HSItem("ItemSalt");
		public static Item itemSodiumchromate = new HSItem("ItemSodiumchromate");
		public static Item itemSodiumdichromate = new HSItem("ItemSodiumdichromate");
		public static Item itemChromeIngot = new HSItem("ItemChromeIngot");
		public static Item itemBatteryBasic = new HSItem("ItemBatteryBasic");
		public static Item itemBauxite = new HSItem("ItemBauxite");
		public static Item itemChromeIIIOxide = new HSItem("ItemChromeIIIOxide");
		public static Item itemAluminiumIngot = new HSItem("ItemAluminiumIngot");
		public static Item itemBauxiteDustTiny = new HSItem("ItemBauxiteDustTiny");
		public static Item itemNuggetChrome = new HSItem("ItemNuggetChrome");
		public static Item itemSlag = new HSItem("ItemSlag");
		
		//Special Items
		
		public static Item itemSodium;

		
		/**
		 * Initializes all given items and registers them in the Registry.
		 */
		public static void registerItems(){
			
			//TOOLS
			swordStainless =  new ItemSwordStainlessSteel();
			registerItem(swordStainless);
			
			pickaxeStainless =  new ItemPickaxeStainlessSteel();
			registerItem(pickaxeStainless);
			
			axeStainless =  new ItemAxeStainlessSteel();
			registerItem(axeStainless);
			
			shovelStainless =  new ItemShovelStainlessSteel();
			registerItem(shovelStainless);
			
			//NON-HSItem-ITEMS
			
			itemSodium = new ItemSodium();
			registerItem(itemSodium);
			
			//OreDictionary Entries
			OreDictionary.registerOre("gemQuartz", itemQuartzCrystal);
			OreDictionary.registerOre("dustQuartz", itemQuartzDust);
			OreDictionary.registerOre("dustStainlessSteel", itemStainlessSteelDust);
			OreDictionary.registerOre("ingotStainlessSteel", itemStainlessSteelIngot);
			OreDictionary.registerOre("itemChromite", itemChromite);
			OreDictionary.registerOre("itemChromeIngot", itemChromeIngot);
			OreDictionary.registerOre("itemSalt", itemSalt);
			OreDictionary.registerOre("itemBauxite", itemBauxite);
			OreDictionary.registerOre("itemChromeNugget", itemNuggetChrome);
			OreDictionary.registerOre("itemSlag", itemSlag);
			
			//Special Creative Tabs
			itemCoil.setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);		
			itemCoalBrush.setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);			
			itemGenerator.setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);	
			itemEmotor.setCreativeTab(HardcoreSilicon.tabHardcoreGenerators);			
		}
		
		/**
		 * Registers the given item in the GameRegistry, sets the unlocalizedName and sets and registers a creativeTab if it has none yet. 
		 * @param item Item to be registered.
		 */
		public static void registerItem(Item item){
			//Default Tab: tabHardcoreSilicon
			if(item.getCreativeTab() == null || item.getCreativeTab().getTabIndex() < 10)item.setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
			item.setUnlocalizedName(NameHelper.getName(item));
			GameRegistry.registerItem(item, NameHelper.getName(item));
		}
		
}
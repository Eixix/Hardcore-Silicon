package tv.Tunfisch.HardcoreSilicon.Register;

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
import tv.Tunfisch.HardcoreSilicon.Items.ItemAndesiteDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemAxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemBasicBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemChromate;
import tv.Tunfisch.HardcoreSilicon.Items.ItemChromeIngot;
import tv.Tunfisch.HardcoreSilicon.Items.ItemChromite;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCircuitBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoalBrush;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoalDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoil;
import tv.Tunfisch.HardcoreSilicon.Items.ItemEmotor;
import tv.Tunfisch.HardcoreSilicon.Items.ItemGenerator;
import tv.Tunfisch.HardcoreSilicon.Items.ItemIronOxide;
import tv.Tunfisch.HardcoreSilicon.Items.ItemNandSwitch;
import tv.Tunfisch.HardcoreSilicon.Items.ItemOsmiumIron;
import tv.Tunfisch.HardcoreSilicon.Items.ItemPickaxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemQuartzCrystal;
import tv.Tunfisch.HardcoreSilicon.Items.ItemQuartzDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSalt;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSenseless;
import tv.Tunfisch.HardcoreSilicon.Items.ItemShovelStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSiliconCrystal;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSiliconRaw;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSodium;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSodiumchromate;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSodiumdichromate;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStainlessSteelDust;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStainlessSteelIngot;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStorageModule128;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSwordStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferEtched;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferRaw;

/**
 * This class contains all mod Items and registers them.
 */
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
		public static Item itemStainlessSteelIngot;
		public static Item itemStainlessSteelDust;
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
		public static Item itemAndesiteDust;
		public static Item itemCoalDust;
		public static Item itemChromite;
		public static Item itemChromate;
		public static Item itemSodium;
		public static Item itemSalt;
		public static Item itemSodiumchromate;
		public static Item itemSodiumdichromate;
		public static Item itemChromeIngot;
		

		
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
			//Create an OreDictionary entry
			OreDictionary.registerOre("gemQuartz", itemQuartzCrystal);
			
			itemQuartzDust = new ItemQuartzDust();
			registerItem(itemQuartzDust);
			//Create an OreDictionary entry
			OreDictionary.registerOre("dustQuartz", itemQuartzDust);
			
			itemStainlessSteelDust = new ItemStainlessSteelDust();
			registerItem(itemStainlessSteelDust);
			//Create an OreDictionary entry
			OreDictionary.registerOre("dustStainlessSteel", itemStainlessSteelDust);
			
			itemStainlessSteelIngot = new ItemStainlessSteelIngot();
			registerItem(itemStainlessSteelIngot);
			//Create an OreDictionary entry
			OreDictionary.registerOre("ingotStainlessSteel", itemStainlessSteelIngot);
			
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
			
			itemAndesiteDust = new ItemAndesiteDust();
			registerItem(itemAndesiteDust);
			
			itemCoalDust = new ItemCoalDust();
			registerItem(itemCoalDust);
			
			itemChromite = new ItemChromite();
			registerItem(itemChromite);
			//Create Ore Dictionary Entry
			OreDictionary.registerOre("itemChromite", itemChromite);
			
			itemChromate = new ItemChromate();
			registerItem(itemChromate);
			
			itemSodium = new ItemSodium();
			registerItem(itemSodium);
			
			itemSalt = new ItemSalt();
			registerItem(itemSalt);
			//Create Ore Dictionary Entry
			OreDictionary.registerOre("itemSalt", itemSalt);
			
			itemSodiumchromate = new ItemSodiumchromate();
			registerItem(itemSodiumchromate);
			
			itemSodiumdichromate = new ItemSodiumdichromate();
			registerItem(itemSodiumdichromate);
			
			itemChromeIngot = new ItemChromeIngot();
			registerItem(itemChromeIngot);
			
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
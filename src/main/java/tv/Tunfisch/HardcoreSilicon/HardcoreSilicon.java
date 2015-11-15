package tv.Tunfisch.HardcoreSilicon;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Items.ItemAxeStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemBasicBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCircuitBoard;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoalBrush;
import tv.Tunfisch.HardcoreSilicon.Items.ItemCoil;
import tv.Tunfisch.HardcoreSilicon.Items.ItemDust;
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
import tv.Tunfisch.HardcoreSilicon.Items.ItemStainlessSteelIngot;
import tv.Tunfisch.HardcoreSilicon.Items.ItemStorageModule128;
import tv.Tunfisch.HardcoreSilicon.Items.ItemSwordStainlessSteel;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferEtched;
import tv.Tunfisch.HardcoreSilicon.Items.ItemWaferRaw;
import tv.Tunfisch.HardcoreSilicon.Proxies.ServerProxy;



@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
public class HardcoreSilicon {

	
	@Instance(value=Reference.MOD_ID)
	public static HardcoreSilicon instance;

	//WERKZEUGE
	public static Item swordStainless;
	public static Item pickaxeStainless;
	public static Item axeStainless;
	public static Item shovelStainless;
	
	//ITEMS
	
	Item itemSiliconCrystal;
	Item itemWaferRaw;
	static Item itemWaferEtched;
	Item itemSiliconRaw;
	Item itemQuartzCrystal;
	Item itemQuartzDust;
	Item itemDust;
	Item itemStainlessSteelIngot;
	Item itemCircuitBoard;
	Item itemBasicBoard;
	Item itemStorageModule128;
	Item itemSenseless;
	Item itemNandSwitch;
	static Item itemCoil;
	Item itemCoalBrush;
	Item itemGenerator;
	Item itemEmotor;
	Item itemIronOxide;
	Item itemOsmiumIron;
	
	
	
	//BLOCKS
	Block blockOreQuartz;
	//Block blockOreChrom;
	
	
//Creative Tabs
	public static CreativeTabs tabHardcoreSilicon = new CreativeTabs("tabHardcoreSilicon"){
		public Item getTabIconItem() {
			return itemWaferEtched;
		}
	};
	
	public static CreativeTabs tabHardcoreGenerators = new CreativeTabs("tabHardcoreGenerators"){
		public Item getTabIconItem() {
			return itemCoil;
		}
	};
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		
		//WERKZEUG
		swordStainless =  new ItemSwordStainlessSteel();
		this.registerItem(swordStainless);
		
		pickaxeStainless =  new ItemPickaxeStainless();
		this.registerItem(pickaxeStainless);
		
		axeStainless =  new ItemAxeStainlessSteel();
		this.registerItem(axeStainless);
		
		shovelStainless =  new ItemShovelStainlessSteel();
		this.registerItem(shovelStainless);
		
		//ITEMS
		
		/*
		 * 	item = new Item().setCreativeTab(tabHardcoreSilicon);
			GameRegistry.registerItem(item, "Item");
		 */
		
		itemSiliconCrystal = new ItemSiliconCrystal();
		this.registerItem(itemSiliconCrystal);
		
		itemWaferRaw = new ItemWaferRaw();
		this.registerItem(itemWaferRaw);
		
		itemWaferEtched = new ItemWaferEtched();
		this.registerItem(itemWaferEtched);
		
		itemSiliconRaw = new ItemSiliconRaw();
		this.registerItem(itemSiliconRaw);

		itemQuartzCrystal = new ItemQuartzCrystal();
		this.registerItem(itemQuartzCrystal);
		
		itemQuartzDust = new ItemQuartzDust();
		this.registerItem(itemQuartzDust);	
		
		itemDust = new ItemDust();
		this.registerItem(itemDust);
		
		itemStainlessSteelIngot = new ItemStainlessSteelIngot();
		this.registerItem(itemStainlessSteelIngot);
		
		itemCircuitBoard = new ItemCircuitBoard();
		this.registerItem(itemCircuitBoard);
		
		itemBasicBoard = new ItemBasicBoard();
		this.registerItem(itemBasicBoard);
		
		itemStorageModule128 = new ItemStorageModule128();
		this.registerItem(itemStorageModule128);
		
		itemSenseless = new ItemSenseless();
		this.registerItem(itemSenseless);
		
		itemNandSwitch = new ItemNandSwitch();
		this.registerItem(itemNandSwitch);
		
		itemIronOxide = new ItemIronOxide();
		this.registerItem(itemIronOxide);
		
		itemOsmiumIron = new ItemOsmiumIron();
		this.registerItem(itemOsmiumIron);
		
		itemCoil = new ItemCoil();
		this.registerItem(itemCoil);
		
		itemCoalBrush = new ItemCoalBrush();
		this.registerItem(itemCoalBrush);
		
		itemGenerator = new ItemGenerator().setCreativeTab(tabHardcoreGenerators);
		this.registerItem(itemGenerator);
		
		itemEmotor = new ItemEmotor().setCreativeTab(tabHardcoreGenerators);
		this.registerItem(itemEmotor);
		
		//BLOCKS
		blockOreQuartz = new BlockOreQuartz(Material.rock, 1.0F, 1.0F, 0.0F, "pickaxe", 2);
		//blockOreChrom = new BlockOreQuartz(Material.rock).setBlockTextureName("HardcoreSilicon:BlockOreChrom").setBlockName("BlockOreChrom");
	}
	
	public void registerItem(Item item){
		if(item.getCreativeTab() == null) item.setCreativeTab(this.tabHardcoreSilicon);
		item.setUnlocalizedName(Utility.getName(item));
		GameRegistry.registerItem(item, Utility.getName(item));
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		if(event.getSide() == Side.CLIENT) BlockRenderRegister.blockRenderRegister(blockOreQuartz);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}

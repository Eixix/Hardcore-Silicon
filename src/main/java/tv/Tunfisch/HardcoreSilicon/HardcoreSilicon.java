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
	
	static Item itemSiliconCrystal;
	static Item itemWaferRaw;
	static Item itemWaferEtched;
	static Item itemSiliconRaw;
	static Item itemQuartzCrystal;
	static Item itemQuartzDust;
	static Item itemDust;
	static Item itemStainlessSteelIngot;
	static Item itemCircuitBoard;
	static Item itemBasicBoard;
	static Item itemStorageModule128;
	static Item itemSenseless;
	static Item itemNandSwitch;
	static Item itemCoil;
	static Item itemCoalBrush;
	static Item itemGenerator;
	static Item itemEmotor;
	static Item itemIronOxide;
	static Item itemOsmiumIron;
	
	
	
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
		blockOreQuartz = new BlockOreQuartz(Material.rock, Utility.getName(blockOreQuartz), 1.0F, 1.0F, 0.0F, "pickaxe", 2);
		//blockOreChrom = new BlockOreQuartz(Material.rock).setBlockTextureName("HardcoreSilicon:BlockOreChrom").setBlockName("BlockOreChrom");
	}
	
	public void registerItem(Item item){
		if(item.getCreativeTab() != null) item.setCreativeTab(this.tabHardcoreSilicon);
		item.setUnlocalizedName(Utility.getName(item));
		GameRegistry.registerItem(item, Utility.getName(item));
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		if(event.getSide() == Side.CLIENT) BlockRenderRegister.blockRenderRegister(blockOreQuartz);
		/*
		
		//Quarzstaub OK
		NBTTagCompound crushQuartz = new NBTTagCompound();
		crushQuartz.setTag("input", new ItemStack(itemQuartzCrystal).writeToNBT(new NBTTagCompound()));
		crushQuartz.setTag("output", new ItemStack(itemQuartzDust).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "CrusherRecipe", crushQuartz);
		
		//Rohes Silizium
		NBTTagCompound rawSilicon = new NBTTagCompound();
		
		rawSilicon.setTag("gasInput", new GasStack(GasRegistry.getGas("hydrogenChloride"), 100).write(new NBTTagCompound()));
		rawSilicon.setTag("input", new ItemStack(itemQuartzDust).writeToNBT(new NBTTagCompound()));
		rawSilicon.setTag("output", new ItemStack(itemSiliconRaw).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "ChemicalInjectionChamberRecipe", rawSilicon);
		
		//Kristalle OK
		NBTTagCompound enrichSilicon = new NBTTagCompound();
		enrichSilicon.setTag("input", new ItemStack(itemSiliconRaw).writeToNBT(new NBTTagCompound()));
		enrichSilicon.setTag("output", new ItemStack(itemSiliconCrystal).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "EnrichmentChamberRecipe", enrichSilicon);
		
		//Kristalle zersägen OK
		NBTTagCompound sawCrystals = new NBTTagCompound();
		sawCrystals.setTag("input", new ItemStack(itemSiliconCrystal).writeToNBT(new NBTTagCompound()));
		sawCrystals.setTag("primaryOutput", new ItemStack(itemWaferRaw, 2).writeToNBT(new NBTTagCompound()));
		sawCrystals.setTag("secondaryOutput", new ItemStack(itemSiliconRaw).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "PrecisionSawmillRecipe", sawCrystals);
		
		//Wafer Ätzen
		NBTTagCompound etchedWafer = new NBTTagCompound();
		etchedWafer.setTag("itemInput", new ItemStack(itemWaferRaw).writeToNBT(new NBTTagCompound()));
		etchedWafer.setTag("fluidInput", new FluidStack(FluidRegistry.WATER, 1000).writeToNBT(new NBTTagCompound()));
		etchedWafer.setTag("gasInput", new GasStack(GasRegistry.getGas("sulfuricAcid"), 1000).write(new NBTTagCompound()));
		
		etchedWafer.setTag("itemOutput", new ItemStack(itemWaferEtched).writeToNBT(new NBTTagCompound()));
		etchedWafer.setTag("gasOutput", new GasStack(GasRegistry.getGas("sulfuricAcid"), 500).write(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "PressurizedReactionChamberRecipe", etchedWafer);
		
		*/
		
		//Edelstahlstaub
		/*
		NBTTagCompound SLSteel = new NBTTagCompound();
		SLSteel.setTag("input", new ItemStack(itemSiliconRaw).writeToNBT(new NBTTagCompound()));
		SLSteel.setTag("infuseType", new 
		SLSteel.setTag("output", new ItemStack(itemSiliconCrystal).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "EnrichmentChamberRecipe", SLSteel);
		
		

		//GameRegistry.addShapelessRecipe(new ItemStack(itemDust), 4, Items.iron_ingot, Items.iron_ingot, Items.coal, Items.diamond);
		*/		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}

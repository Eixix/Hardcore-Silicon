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
import tv.Tunfisch.HardcoreSilicon.Proxies.HardcoreSiliconProxy;



@Mod(modid="HardcoreSiliconID", name="Hardcore Silicon", version="0.9.0",
dependencies = "after:Mekanism")
public class HardcoreSilicon {

	
	@Instance(value="HardcoreSiliconID")
	public static HardcoreSilicon instance;
	
	@SidedProxy(clientSide="tv.Tunfisch.HardcoreSilicon.Proxies.HardcoreSiliconClientProxy", serverSide="tv.Tunfisch.HardcoreSilicon.Proxies.HardcoreSiliconProxy")
	public static HardcoreSiliconProxy proxy;
	
	//WERKZEUGE
	public static Item swordStainless;
	public static Item pickaxeStainless;
	public static Item axeStainless;
	public static Item shovelStainless;
	
	//Blubb....

	
	//ITEMS
	
	Item itemSiliconCrystal;
	Item itemWaferRaw;
	Item itemWaferEtched;
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
	Item itemCoil;
	Item itemCoalBrush;
	Item itemGenerator;
	Item itemEmotor;
	Item itemIronOxide;
	Item itemOsmiumIron;
	
	
	
	//BLOCKS
	//Do not use yet
	//Block blockOreQuartz;
	//Block blockOreChrom;
	
	
//Creative Tabs
	public CreativeTabs tabHardcoreSilicon = new CreativeTabs("tabHardcoreSilicon"){

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			
			return itemWaferEtched;
		}
		
	};
	
	public CreativeTabs tabHardcoreGenerators = new CreativeTabs("tabHardcoreGenerators"){

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			
			return itemCoil;
		}
		
	};
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		
		//WERKZEUG
		swordStainless =  new ItemSwordStainlessSteel(null).setUnlocalizedName("swordStainless");
		GameRegistry.registerItem(swordStainless, "swordStainless");
		
		pickaxeStainless =  new ItemPickaxeStainless(null).setUnlocalizedName("pickaxeStainless");
		GameRegistry.registerItem(pickaxeStainless, "pickaxeStainless");
		
		axeStainless =  new ItemAxeStainlessSteel(null).setUnlocalizedName("axeStainless");
		GameRegistry.registerItem(axeStainless, "axeStainless");
		
		shovelStainless =  new ItemShovelStainlessSteel(null).setUnlocalizedName("shovelStainless");
		GameRegistry.registerItem(shovelStainless, "shovelStainless");
		
		//ITEMS
		
		/*
		 * 	item = new Item().setCreativeTab(tabHardcoreSilicon);
			GameRegistry.registerItem(item, "Item");
		 */
		
		itemSiliconCrystal = new ItemSiliconCrystal().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemSiliconCrystal, "ItemSiliconCrystal");
		
		itemWaferRaw = new ItemWaferRaw().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemWaferRaw, "ItemWaferRaw");
		
		itemWaferEtched = new ItemWaferEtched().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemWaferEtched, "ItemWaferEtched");
		
		itemSiliconRaw = new ItemSiliconRaw().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemSiliconRaw, "ItemSiliconRaw");

		itemQuartzCrystal = new ItemQuartzCrystal().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemQuartzCrystal, "ItemQuartzCrystal");
		
		itemQuartzDust = new ItemQuartzDust().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemQuartzDust, "ItemQuartzDust");	
		
		itemDust = new ItemDust().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemDust, "ItemDustStainlessSteel");
		
		itemStainlessSteelIngot = new ItemStainlessSteelIngot().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemStainlessSteelIngot, "ItemStainlessSteelIngot");
		
		itemCircuitBoard = new ItemCircuitBoard().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemCircuitBoard, "ItemCiruitBoard");
		
		itemBasicBoard = new ItemBasicBoard().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemBasicBoard, "ItemBasicBoard");
		
		itemStorageModule128 = new ItemStorageModule128().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemStorageModule128, "ItemStorageModule128");
		
		itemSenseless = new ItemSenseless().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemSenseless, "ItemSenseless");
		
		itemNandSwitch = new ItemNandSwitch().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemNandSwitch, "ItemNandSwitch");
		
		itemIronOxide = new ItemIronOxide().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemIronOxide, "ItemIronOxide");
		
		itemOsmiumIron = new ItemOsmiumIron().setCreativeTab(tabHardcoreSilicon);
		GameRegistry.registerItem(itemOsmiumIron, "ItemOsmiumIron");
		
		itemCoil = new ItemCoil().setCreativeTab(tabHardcoreGenerators);
		GameRegistry.registerItem(itemCoil, "ItemCoil");
		
		itemCoalBrush = new ItemCoalBrush().setCreativeTab(tabHardcoreGenerators);
		GameRegistry.registerItem(itemCoalBrush, "ItemCoalBrush");
		
		itemGenerator = new ItemGenerator().setCreativeTab(tabHardcoreGenerators);
		GameRegistry.registerItem(itemGenerator, "ItemGenerator");
		
		itemEmotor = new ItemEmotor().setCreativeTab(tabHardcoreGenerators);
		GameRegistry.registerItem(itemEmotor, "ItemEmotor");
		
		
		
		
		
		//BLOCKS
		// Do not use yet
		//GameRegistry.registerBlock(blockOreQuartz, blockOreQuartz);
		//blockOreQuartz = new BlockOreQuartz(Material.rock);
		
		//GameRegistry.registerBlock(blockOreChrom, blockOreChrom);
		//blockOreChrom = new BlockOreQuartz(Material.rock).setBlockTextureName("HardcoreSilicon:BlockOreChrom").setBlockName("BlockOreChrom");
	
		
		
		
	}
	
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		proxy.registerRenderers();
		
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
		
		//Kristalle zers�gen OK
		NBTTagCompound sawCrystals = new NBTTagCompound();
		sawCrystals.setTag("input", new ItemStack(itemSiliconCrystal).writeToNBT(new NBTTagCompound()));
		sawCrystals.setTag("primaryOutput", new ItemStack(itemWaferRaw, 2).writeToNBT(new NBTTagCompound()));
		sawCrystals.setTag("secondaryOutput", new ItemStack(itemSiliconRaw).writeToNBT(new NBTTagCompound()));
		FMLInterModComms.sendMessage("Mekanism", "PrecisionSawmillRecipe", sawCrystals);
		
		//Wafer �tzen
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
		
		//Blubb
		
		
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}

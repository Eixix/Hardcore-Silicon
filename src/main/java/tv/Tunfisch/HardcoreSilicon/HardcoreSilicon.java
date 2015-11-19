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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import tv.Tunfisch.HardcoreSilicon.Blocks.BlockOreQuartz;
import tv.Tunfisch.HardcoreSilicon.Electrolyzer.TileEntityElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.Grinder.TileEntityGrinder;
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
import tv.Tunfisch.HardcoreSilicon.Items.ItemPickaxeStainlessSteel;
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



@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
public class HardcoreSilicon {
	
	@Instance(value=Reference.MOD_ID)
	public static HardcoreSilicon instance;
	
    //Creative Tabs
	public static CreativeTabs tabHardcoreSilicon = new CreativeTabs("tabHardcoreSilicon"){
		public Item getTabIconItem() {
			return ItemRegister.itemWaferEtched;
		}
	};
	
	public static CreativeTabs tabHardcoreGenerators = new CreativeTabs("tabHardcoreGenerators"){
		public Item getTabIconItem() {
			return ItemRegister.itemCoil;
		}
	};
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){   
		//Register the FuelHandler
		GameRegistry.registerFuelHandler(new FuelHandler());
		//Register Items
		ItemRegister.registerItems();
		//Register Blocks
		BlockRegister.registerBlocks();
		//Register TileEntities
		GameRegistry.registerTileEntity(new TileEntityGrinder().getClass(), "tileEntityGrinder");
		GameRegistry.registerTileEntity(new TileEntityElectrolyzer().getClass(), "tileEntityElectrolyzer");
		//Register Crafting
		CraftingHandler.registerCraftingRecipes();
	}	
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//Assign Block Texture
		if(event.getSide() == Side.CLIENT) BlockRenderRegister.registerBlocks();
		//Assign Item Texture
		ItemRenderRegister.registerItemRenderer();
		//Register WorldGeneration
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 0); //0 is the priority
		//Register Network
        NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());  


	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}

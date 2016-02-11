package tv.Tunfisch.HardcoreSilicon;

import java.lang.reflect.Method;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
import tv.Tunfisch.HardcoreSilicon.Handler.CraftingHandler;
import tv.Tunfisch.HardcoreSilicon.Handler.FuelHandler;
import tv.Tunfisch.HardcoreSilicon.Handler.GuiHandler;
import tv.Tunfisch.HardcoreSilicon.Handler.MachineRecipeHandler;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRenderRegister;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRegister;
import tv.Tunfisch.HardcoreSilicon.Register.ItemRenderRegister;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityAssembler;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityBlastFurnace;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityCrystalizer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityElectrolyzer;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityGrinder;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityMillingMachine;
import tv.Tunfisch.HardcoreSilicon.TileEntities.TileEntityUVR;



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
	
	public static MachineRecipeHandler mrh;
	
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
		GameRegistry.registerTileEntity(new TileEntityBlastFurnace().getClass(), "tileEntityBlastFurnace");
		GameRegistry.registerTileEntity(new TileEntityCrystalizer().getClass(), "tileEntityCrystalizer");
		GameRegistry.registerTileEntity(new TileEntityUVR().getClass(), "tileEntityUVR");
		GameRegistry.registerTileEntity(new TileEntityMillingMachine().getClass(), "tileEntityMillingMachine");
		GameRegistry.registerTileEntity(new TileEntityAssembler().getClass(), "tileEntityAssembler");
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
        //Initialize MachineRecipeHandler
        mrh = new MachineRecipeHandler();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	
	
}

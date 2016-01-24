package tv.Tunfisch.HardcoreSilicon.Fluids;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tv.Tunfisch.HardcoreSilicon.HardcoreSilicon;

public class SulfuricAcid extends BlockFluidClassic{

	public SulfuricAcid(){
		super(FluidRegistry.WATER , Material.water);
		setCreativeTab(HardcoreSilicon.tabHardcoreSilicon);
	}

	
}

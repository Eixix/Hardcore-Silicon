package tv.Tunfisch.HardcoreSilicon;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import tv.Tunfisch.HardcoreSilicon.Fluids.SulfuricAcid;

public class FluidRegister {
	public static Fluid sulfuricAcid;
	
	public static void registerFluids(){
		sulfuricAcid = new Fluid("sulfuricAcid");
		FluidRegistry.registerFluid(sulfuricAcid);
	}
}

package tv.Tunfisch.HardcoreSilicon;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import tv.Tunfisch.HardcoreSilicon.Register.BlockRegister;

public class WorldGeneration implements IWorldGenerator {

	//Quartz ore generation
	private WorldGenerator quartzGenerator;
	private WorldGenerator chromiteGenerator;
	private WorldGenerator saltGenerator;
	private WorldGenerator bauxiteGenerator;
	
	public WorldGeneration(){
		quartzGenerator = new WorldGenMinable(BlockRegister.blockOreQuartz.getDefaultState(), 4); //4 is the ore vein size
		chromiteGenerator = new WorldGenMinable(BlockRegister.blockOreChromite.getDefaultState(), 6);
		saltGenerator = new WorldGenMinable(BlockRegister.blockOreSalt.getDefaultState(), 10);
		bauxiteGenerator = new WorldGenMinable(BlockRegister.blockOreBauxite.getDefaultState(), 4);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		//Select in which dimension the ore should spawn
		switch(world.provider.getDimensionId()){
		     //Overworld
		     case 0: 
		     //Quartz spawns from y0 - 32 with up to 20 veins per Chunk
		     this.runGenerator(quartzGenerator, world, random, chunkX, chunkZ, 20, 0, 32);
		     this.runGenerator(chromiteGenerator, world, random, chunkX, chunkZ, 10, 0, 32);
		     this.runGenerator(saltGenerator, world, random, chunkX, chunkZ, 30, 40, 60);
		     this.runGenerator(bauxiteGenerator, world, random, chunkX, chunkZ, 20, 0, 50);
		     break;
		     //Nether	 
		     case 1: break;
		     //The End	 
		     case -1: break;
		}
	}
	
	/**
	 * Standard generation method.
	 * @param generator Generator to be used
	 * @param world The world object
	 * @param rand A random number generator
	 * @param chunk_X x coordinate of the chunk
	 * @param chunk_Z z coordinate of the chunk
	 * @param chancesToSpawn How common should your ore be?
	 * @param minHeight Minimum Height of spawning
	 * @param maxHeight Maximum Height of spawning
	 */
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
}

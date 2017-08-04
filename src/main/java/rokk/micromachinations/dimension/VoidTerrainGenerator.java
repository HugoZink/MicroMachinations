package rokk.micromachinations.dimension;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import java.util.Random;

public class VoidTerrainGenerator
{
    private Biome[] biomesForGeneration;

    public void setup(World world, Random rand)
    {

    }

    public void generate(int chunkX, int chunkZ, ChunkPrimer primer)
    {
        //Lol terrain gen

        /*
        for(int i = chunkX; i < chunkX + 16; i++)
        {
            for(int j = chunkZ; j < chunkZ + 16; j++)
            {
                for(int k = 0; k < 256; k++)
                {
                    primer.setBlockState(i, k, j, Blocks.AIR.getDefaultState());
                }
            }
        }
        */
    }

    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, IChunkGenerator generator, Biome[] biomes)
    {

    }
}
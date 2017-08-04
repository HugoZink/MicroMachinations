package rokk.micromachinations.dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;

public class MicroWorldProvider extends WorldProvider
{
    @Override
    protected void generateLightBrightnessTable()
    {
        for (int i = 0; i < this.lightBrightnessTable.length; i++)
        {
            this.lightBrightnessTable[i] = 1;
        }
    }

    @Override
    public DimensionType getDimensionType()
    {
        return ModDimensions.microDimensionType;
    }

    @Override
    public String getSaveFolder()
    {
        return "DIM_MICRO";
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new MicroChunkGenerator(worldObj);
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public boolean getHasNoSky()
    {
        return true;
    }
}

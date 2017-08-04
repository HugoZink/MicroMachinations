package rokk.micromachinations.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import rokk.micromachinations.Config;
import rokk.micromachinations.MicroMachinations;

public class ModDimensions
{
    public static DimensionType microDimensionType;
    public static int microDimId;

    public static void init()
    {
        microDimId = Config.microDimId;

        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes()
    {
        //What is the suffix parameter?
        microDimensionType = DimensionType.register(MicroMachinations.MODID, "_microdim", microDimId, MicroWorldProvider.class, false);
    }

    private static void registerDimensions()
    {
        DimensionManager.registerDimension(microDimId, microDimensionType);
    }
}

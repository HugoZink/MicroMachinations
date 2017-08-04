package rokk.micromachinations.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.*;
import rokk.micromachinations.Config;
import rokk.micromachinations.block.ModBlocks;
import rokk.micromachinations.dimension.ModDimensions;
import rokk.micromachinations.item.ModItems;

import java.io.File;

public class CommonProxy
{
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e)
    {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "micromachinations.cfg"));
        Config.readConfig();

        ModBlocks.init();
        ModItems.init();
        ModDimensions.init();
    }

    public void init(FMLInitializationEvent e)
    {

    }

    public void postInit(FMLPostInitializationEvent e)
    {
        if(config.hasChanged())
        {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int meta, String id)
    {
        //Should do nothing on the server.
    }
}

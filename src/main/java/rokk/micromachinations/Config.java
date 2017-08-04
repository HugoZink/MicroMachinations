package rokk.micromachinations;

import net.minecraftforge.common.config.Configuration;
import rokk.micromachinations.proxy.CommonProxy;

public class Config
{
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static int microDimId = -838;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig()
    {
        Configuration cfg = CommonProxy.config;
        try
        {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        }
        catch(Exception e1)
        {
            //TODO: Log config error
        }
        finally
        {
            if(cfg.hasChanged())
            {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg)
    {
        /*
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        isThisAGoodTutorial = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, isThisAGoodTutorial, "Set to false if you don't like this tutorial");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
        */
    }

    private static void initDimensionConfig(Configuration cfg)
    {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
        microDimId = cfg.getInt("dimensionId", CATEGORY_DIMENSIONS, -838, Integer.MIN_VALUE, Integer.MAX_VALUE, "Which dimension ID the mod should use.");
    }
}
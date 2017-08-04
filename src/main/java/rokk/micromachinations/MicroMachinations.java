package rokk.micromachinations;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rokk.micromachinations.proxy.CommonProxy;

@Mod(modid = MicroMachinations.MODID, version = MicroMachinations.VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class MicroMachinations
{
    public static final String MODID = "micromachinations";
    public static final String VERSION = "0.1";

    @SidedProxy(serverSide = "rokk.micromachinations.proxy.CommonProxy", clientSide = "rokk.micromachinations.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}

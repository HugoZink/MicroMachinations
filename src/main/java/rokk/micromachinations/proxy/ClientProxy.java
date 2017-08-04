package rokk.micromachinations.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import rokk.micromachinations.MicroMachinations;
import rokk.micromachinations.proxy.CommonProxy;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MicroMachinations.MODID + ":" + id, "inventory"));
    }
}

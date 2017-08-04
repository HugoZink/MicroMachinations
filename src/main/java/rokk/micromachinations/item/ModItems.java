package rokk.micromachinations.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemBase formationWand;

    public static void init()
    {
        formationWand = register(new ItemBase("formation_wand").setCreativeTab(CreativeTabs.MISC));
    }

    private static <T extends Item> T register(T item)
    {
        GameRegistry.register(item);

        if(item instanceof ItemBase)
        {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

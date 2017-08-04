package rokk.micromachinations.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rokk.micromachinations.block.BlockBase;
import rokk.micromachinations.block.micromachine.MicroMachine;
import rokk.micromachinations.block.micromachine.MicroMachineInternal;
import rokk.micromachinations.block.micromachine.MicroMachineStructure;

public class ModBlocks
{
    public static BlockBase microMachineStructureIron;
    public static BlockBase microMachineInternal;

    public static MicroMachine microMachine;

    public static void init()
    {
        microMachineStructureIron = register(new MicroMachineStructure());
        //microMachineInternal = register((BlockBase)new BlockBase(Material.IRON, "micromachine_internal").setBlockUnbreakable().setLightLevel(10.0f));
        microMachineInternal = register(new MicroMachineInternal());

        microMachine = register(new MicroMachine());
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock)
    {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if(block instanceof BlockBase)
        {
            ((BlockBase)block).registerItemModel(itemBlock);
        }

        if (block instanceof BlockTileEntity)
        {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }

        return block;
    }

    private static <T extends Block> T register(T block)
    {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }

}
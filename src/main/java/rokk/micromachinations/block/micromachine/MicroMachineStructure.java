package rokk.micromachinations.block.micromachine;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import rokk.micromachinations.block.BlockBase;
import rokk.micromachinations.block.BlockTileEntity;
import rokk.micromachinations.block.ModBlocks;
import rokk.micromachinations.item.ModItems;

import javax.annotation.Nullable;

public class MicroMachineStructure extends BlockBase
{
    public MicroMachineStructure()
    {
        super(Material.ROCK, "micromachine_structure_iron");
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            if(heldItem != null && heldItem.getItem() == ModItems.formationWand)
            {
                //Replace structure block with a micro machine.
                world.setBlockState(pos, ModBlocks.microMachine.getDefaultState());
            }
        }

        return true;
    }
}
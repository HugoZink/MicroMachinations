package rokk.micromachinations.block.micromachine;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rokk.micromachinations.block.BlockBase;

public class MicroMachineInternal extends BlockBase
{
    public MicroMachineInternal()
    {
        super(Material.IRON, "micromachine_internal");
        setBlockUnbreakable();
        setLightLevel(10.0f);
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        //This block should absolutely never be destroyed.
        return false;
    }
}

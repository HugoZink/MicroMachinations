package rokk.micromachinations.block.micromachine;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import rokk.micromachinations.Config;
import rokk.micromachinations.block.BlockTileEntity;
import rokk.micromachinations.block.ModBlocks;
import rokk.micromachinations.dimension.MicroTeleporter;
import rokk.micromachinations.dimension.ModDimensions;
import rokk.micromachinations.item.ModItems;

import javax.annotation.Nullable;

public class MicroMachine extends BlockTileEntity<MicroMachineTileEntity>
{
    public MicroMachine()
    {
        super(Material.ROCK, "micromachine");
        setCreativeTab(CreativeTabs.MISC);
        setHardness(4.0f);
        setResistance(25.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            //TODO: Generate safe spawn place.
            //Generate a machine and get its spawn coordinates.
            BlockPos machineSpawn = generateMicroMachine(MachineTier.IRON, 1);

            MicroTeleporter.teleportToDimension(player, ModDimensions.microDimId, machineSpawn.getX(), machineSpawn.getY(), machineSpawn.getZ());
        }

        return true;
    }

    @Override
    public Class<MicroMachineTileEntity> getTileEntityClass() {
        return MicroMachineTileEntity.class;
    }

    @Nullable
    @Override
    public MicroMachineTileEntity createTileEntity(World world, IBlockState state)
    {
        return new MicroMachineTileEntity();
    }

    private BlockPos generateMicroMachine(MachineTier tier, int size)
    {
        //Internal dimensions of the machine. A machineSize of 3 would make a room of 3x3x3 (5x5x5 with outside blocks).
        int machineSize;

        switch(tier)
        {
            case COPPER:
                machineSize = 3;
                break;
            case IRON:
                machineSize = 5;
                break;
            case SILVER:
                machineSize = 7;
                break;
            case GOLD:
                machineSize = 9;
                break;
            case DIAMOND:
                machineSize = 11;
                break;
            default:
                machineSize = 3;
                System.out.println("Micro Machine size could not be determined!");
        }

        //Multiply machine size by size of multiblock.
        //A 2x2x2 cube should be twice as wide, long and high as one block would be.
        machineSize *= size;

        //Create starting cube.
        int startX = 0;
        int startY = 64;
        int startZ = 0;

        World microWorld = DimensionManager.getWorld(Config.microDimId);

        for(int x = startX; x < (machineSize + startX); x++)
        {
            for(int y = startY; y < (machineSize + startY); y++)
            {
                for(int z = startZ; z < (machineSize + startZ); z++)
                {
                    //System.out.println("Generating internal block at " + Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z));
                    microWorld.setBlockState(new BlockPos(x, y, z), ModBlocks.microMachineInternal.getDefaultState());
                }
            }
        }

        //Hollow out cube with air blocks.
        for(int x = startX + 1; x < ((machineSize - 1) + startX); x++)
        {
            for(int y = startY + 1; y < ((machineSize - 1) + startY); y++)
            {
                for(int z = startZ + 1; z < ((machineSize - 1) + startZ); z++)
                {
                    microWorld.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState());
                }
            }
        }

        return new BlockPos(startX + (machineSize / 2), startY + 1, startZ + (machineSize / 2));
    }
}
package terrails.ingotter.worldgen.generator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WorldGenIngotterMinable extends WorldGenerator {

    private int veinSize;
    private IBlockState oreToGenerate;
    private BlockMatcher blockToReplace;
    private IBlockState block;

    public WorldGenIngotterMinable(Block oreToGenerate, int minVeinSize, int maxVeinSize, Block blockToReplace) {
        this.oreToGenerate = oreToGenerate.getDefaultState();
        this.veinSize = ThreadLocalRandom.current().nextInt(minVeinSize, maxVeinSize + 1);
        this.blockToReplace = BlockMatcher.forBlock(blockToReplace);
        this.block = blockToReplace.getDefaultState();
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int x = pos.getX() + 8;
        int y = pos.getY() + 8;
        int z = pos.getZ() + 8;

        if (veinSize >= 4) {
            WorldGenMinable genMinable = new WorldGenMinable(oreToGenerate, veinSize, blockToReplace);
            genMinable.generate(world, rand, pos);
        }
        if(veinSize < 4) {
           // BlockPos blockPos = new BlockPos(x, y, z);
            IBlockState blockState = world.getBlockState(new BlockPos(x, y, z));
            if (blockState.getBlock().isReplaceableOreGen(blockState, world, new BlockPos(x, y, z), blockToReplace)) {
                generateSmallVein(world, rand, x, y, z);}
        }
        return false;
    }

    private boolean generateSmallVein(World world, Random random, int x, int y, int z) {
        boolean r = world.setBlockState(new BlockPos(x, y, z), oreToGenerate, 2);

        for (int i = 1; i < veinSize; i++) {
            int posX = x + random.nextInt(2);
            int posY = y + random.nextInt(2);
            int posZ = z + random.nextInt(2);
            r |= world.setBlockState(new BlockPos(posX, posY, posZ), oreToGenerate, 2);
        }
        return r;
    }
}

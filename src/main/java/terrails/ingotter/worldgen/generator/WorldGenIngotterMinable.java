package terrails.ingotter.worldgen.generator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ConfigWatch;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WorldGenIngotterMinable extends WorldGenerator {

    private int veinSize;
    private IBlockState oreToGenerate;
    private BlockMatcher blockToReplace;
   // private IBlockState block;
/*
    public WorldGenIngotterMinable(Block oreToGenerate, int minVeinSize, int maxVeinSize, Block blockToReplace) {
        this.oreToGenerate = oreToGenerate.getDefaultState();
        this.veinSize = ThreadLocalRandom.current().nextInt(minVeinSize, maxVeinSize + 1);
        this.blockToReplace = BlockMatcher.forBlock(blockToReplace);
        this.block = blockToReplace.getDefaultState();
    }
*/

    public WorldGenIngotterMinable(IBlockState oreToGenerate, int minVeinSize, int maxVeinSize, Block blockToReplace){
        this.oreToGenerate = oreToGenerate;
        this.veinSize = ThreadLocalRandom.current().nextInt(minVeinSize, maxVeinSize + 1);
        this.blockToReplace = BlockMatcher.forBlock(blockToReplace);
     //   this.block = blockToReplace.getDefaultState();
    }


    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int x = pos.getX() + 8;
        int y = pos.getY() + 8;
        int z = pos.getZ() + 8;

        if (veinSize >= 4) {
            generateNormal(world, rand, pos);
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

    private boolean generateNormal(World worldIn, Random rand, BlockPos position) {
        if(veinSize >= 4) {
            float f = rand.nextFloat() * (float) Math.PI;
            double d0 = (double) ((float) (position.getX() + 8) + MathHelper.sin(f) * (float) this.veinSize / 8.0F);
            double d1 = (double) ((float) (position.getX() + 8) - MathHelper.sin(f) * (float) this.veinSize / 8.0F);
            double d2 = (double) ((float) (position.getZ() + 8) + MathHelper.cos(f) * (float) this.veinSize / 8.0F);
            double d3 = (double) ((float) (position.getZ() + 8) - MathHelper.cos(f) * (float) this.veinSize / 8.0F);
            double d4 = (double) (position.getY() + rand.nextInt(3) - 2);
            double d5 = (double) (position.getY() + rand.nextInt(3) - 2);

            for (int i = 0; i < this.veinSize; ++i) {
                float f1 = (float) i / (float) this.veinSize;
                double d6 = d0 + (d1 - d0) * (double) f1;
                double d7 = d4 + (d5 - d4) * (double) f1;
                double d8 = d2 + (d3 - d2) * (double) f1;
                double d9 = rand.nextDouble() * (double) this.veinSize / 16.0D;
                double d10 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
                double d11 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
                int j = MathHelper.floor(d6 - d10 / 2.0D);
                int k = MathHelper.floor(d7 - d11 / 2.0D);
                int l = MathHelper.floor(d8 - d10 / 2.0D);
                int i1 = MathHelper.floor(d6 + d10 / 2.0D);
                int j1 = MathHelper.floor(d7 + d11 / 2.0D);
                int k1 = MathHelper.floor(d8 + d10 / 2.0D);

                for (int l1 = j; l1 <= i1; ++l1) {
                    double d12 = ((double) l1 + 0.5D - d6) / (d10 / 2.0D);

                    if (d12 * d12 < 1.0D) {
                        for (int i2 = k; i2 <= j1; ++i2) {
                            double d13 = ((double) i2 + 0.5D - d7) / (d11 / 2.0D);

                            if (d12 * d12 + d13 * d13 < 1.0D) {
                                for (int j2 = l; j2 <= k1; ++j2) {
                                    double d14 = ((double) j2 + 0.5D - d8) / (d10 / 2.0D);

                                    if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D) {
                                        BlockPos blockpos = new BlockPos(l1, i2, j2);

                                        IBlockState state = worldIn.getBlockState(blockpos);
                                        if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, this.blockToReplace)) {
                                            worldIn.setBlockState(blockpos, this.oreToGenerate, 2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

package terrails.ingotter.worldgen.ore;

import com.sun.org.apache.xerces.internal.impl.dv.xs.TypeValidator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.IntegerCache;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ore.ConfigCustomOreGen;
import terrails.ingotter.config.ore.ConfigEndHandler;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Arrays;
import java.util.Random;

public class CustomOreGen implements IWorldGenerator {

    
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String oreName : ConfigCustomOreGen.oreToReplace){Block ore = Block.getBlockFromName(oreName);
            for(String yMin : ConfigCustomOreGen.minY){int minY = Integer.parseInt(yMin.replace(oreName+"=", ""));
                for(String yMax : ConfigCustomOreGen.maxY){int maxY = Integer.parseInt(yMax.replace(oreName+"=", ""));
                    for(String veinMin : ConfigCustomOreGen.minVein){int minVein = Integer.parseInt(veinMin.replace(oreName+"=", ""));
                        for(String veinMax : ConfigCustomOreGen.maxVein){int maxVein = Integer.parseInt(veinMax.replace(oreName+"=", ""));
                            for(String chanceVein : ConfigCustomOreGen.veinChance){int veinChance = Integer.parseInt(chanceVein.replace(oreName+"=", ""));
            generateOre(ore, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, veinChance);
        }}}}}}
    }

    private void generateOre(Block ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if (world.provider.getDimension() == 0) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.AIR);
                generator.generate(world, random, blockpos);
            }
        }
    }
}

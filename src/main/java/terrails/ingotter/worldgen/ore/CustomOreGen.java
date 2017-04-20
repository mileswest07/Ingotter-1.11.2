package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ore.ConfigCustomOreGen;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Random;

public class CustomOreGen implements IWorldGenerator {

    private Block blockName;
    private int yMinLevel;
    private int yMaxLevel;
    private int minVeinSize;
    private int maxVeinSize;
    private int veinChancePerChunk;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String oreName : ConfigCustomOreGen.oreToReplace) {
            Block ore = Block.getBlockFromName(oreName);
            this.blockName = Block.getBlockFromName(oreName);
            Constants.LOGGER.info(oreName);

            for (String yMin : ConfigCustomOreGen.minY) {
                if(yMin.contains(oreName)){
                String yMinMain = yMin.substring(yMin.indexOf("=") + 1);//yMin.replace(blockName + "=", "");
                int minY = Integer.parseInt(yMinMain);
                this.yMinLevel = Integer.parseInt(yMinMain);
                Constants.LOGGER.info(blockName + " " + minY);}
            }

            for (String yMax : ConfigCustomOreGen.maxY) {
                if(yMax.contains(oreName)){
                String yMaxMain = yMax.substring(yMax.indexOf("=") + 1);//yMax.replace(blockName + "=", "");
                int maxY = Integer.parseInt(yMaxMain);
                this.yMaxLevel = Integer.parseInt(yMaxMain);
                Constants.LOGGER.info(blockName + " " + maxY);}
            }

            for (String veinMin : ConfigCustomOreGen.minVein) {
                if(veinMin.contains(oreName)){
                String veinMinMain = veinMin.substring(veinMin.indexOf("=") + 1);//veinMin.replace(blockName + "=", "");
                int minVein = Integer.parseInt(veinMinMain);
                this.minVeinSize = Integer.parseInt(veinMinMain);
                Constants.LOGGER.info(blockName + " " + minVein);}
            }

            for (String veinMax : ConfigCustomOreGen.maxVein) {
                if(veinMax.contains(oreName)){
                String veinMaxMain = veinMax.substring(veinMax.indexOf("=") + 1);//veinMax.replace(blockName + "=", "");
                int maxVein = Integer.parseInt(veinMaxMain);
                this.maxVeinSize = Integer.parseInt(veinMaxMain);
                Constants.LOGGER.info(blockName + " " + maxVein);}
            }

            for (String chanceVein : ConfigCustomOreGen.veinChance) {
                if(chanceVein.contains(oreName)){
                String chanceVeinMain = chanceVein.substring(chanceVein.indexOf("=") + 1);//chanceVein.replace(blockName + "=", "");
                int veinChance = Integer.parseInt(chanceVeinMain);
                this.veinChancePerChunk = Integer.parseInt(chanceVeinMain);
                Constants.LOGGER.info(blockName + " " + veinChance);}
            }

            generateOre(blockName, world, random, chunkX, chunkZ, yMinLevel, yMaxLevel, minVeinSize, maxVeinSize, veinChancePerChunk);
        }// }}}}}}
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

package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.commons.lang3.StringUtils;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Arrays;
import java.util.Random;

public class DefinedBlockOreGen implements IWorldGenerator {

    private Block blockToReplaceCustom;
    private Block blockToReplaceIngotter;
    private int oreMetadataCustom;
    private int oreMetadataIngotter;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateCustom(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        generateIngotter(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    @SuppressWarnings("deprecation")
    private void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreArray) {
            String oreName = ore.toLowerCase();

            // Block Name && Block Without Metadata
            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);

            if (!oreName.isEmpty() && ConfigOreHandler.oreBoolean && blockOre != null && oreName.contains("-replace:") && !oreName.contains("-dimension:") && !oreName.contains("-biome:")) {

                // Metadata
                if(oreName.contains("-meta:")){
                String oreMetadata1 = oreName.substring(oreName.indexOf("-meta:"));
                String oreMetadata2 = oreMetadata1.contains(";") ? oreMetadata1.replace(";", "") : oreMetadata1.substring(0, oreMetadata1.indexOf(" "));
                String oreMetadata3 = oreMetadata2.replace("-meta:", "");
                oreMetadataCustom = Integer.parseInt(oreMetadata3);
                }
               //  Constants.LOGGER.info(oreMetadataCustom);

                // IBlockState
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadataCustom);

                // Min Vein Size
                String minVein1 = oreName.substring(oreName.indexOf("-minvein:"));
                String minVein2 = minVein1.contains(";") ? minVein1.replace(";", "") : minVein1.substring(0, minVein1.indexOf(" "));
                String minVein3 = minVein2.replace("-minvein:", "");
                int minVein = Integer.parseInt(minVein3);
            //     Constants.LOGGER.info(minVein);

                // Max Vein Size
                String maxVein1 = oreName.substring(oreName.indexOf("-maxvein:"));
                String maxVein2 = maxVein1.contains(";") ? maxVein1.replace(";", "") : maxVein1.substring(0, maxVein1.indexOf(" "));
                String maxVein3 = maxVein2.replace("-maxvein:", "");
                int maxVein = Integer.parseInt(maxVein3);
                //    Constants.LOGGER.info(maxVein);

                // Min Y Level
                String yMin1 = oreName.substring(oreName.indexOf("-miny:"));
                String yMin2 = yMin1.contains(";") ? yMin1.replace(";", "") : yMin1.substring(0, yMin1.indexOf(" "));
                String yMin3 = yMin2.replace("-miny:", "");
                int minY = Integer.parseInt(yMin3);
                //    Constants.LOGGER.info(minY);

                // Max Y Level
                String yMax1 = oreName.substring(oreName.indexOf("-maxy:"));
                String yMax2 = yMax1.contains(";") ? yMax1.replace(";", "") : yMax1.substring(0, yMax1.indexOf(" "));
                String yMax3 = yMax2.replace("-maxy:", "");
                int maxY = Integer.parseInt(yMax3);
                //    Constants.LOGGER.info(maxY);

                // Per Chunk
                String perChunk1 = oreName.substring(oreName.indexOf("-perchunk:"));
                String perChunk2 = perChunk1.contains(";") ? perChunk1.replace(";", "") : perChunk1.substring(0, perChunk1.indexOf(" "));
                String perChunk3 = perChunk2.replace("-perchunk:", "");
                int perChunk = Integer.parseInt(perChunk3);
                //    Constants.LOGGER.info(perChunk);

                // Block To Replace
                String block1 = oreName.substring(oreName.indexOf("-replace:"));
                String block2 = block1.replace("-replace:", "");
                String block3 = block2.contains(" -") ? block2.substring(0, block2.indexOf(" ")) : block2.replace(";", "");

                if (block3.contains(".")) {String[] block4 = block3.split("\\.");
                    for (String blockReplace : block4) {blockToReplaceCustom = Block.getBlockFromName(blockReplace);}}
                else if(!block3.contains(".")){blockToReplaceCustom = Block.getBlockFromName(block3);}

                if(blockToReplaceCustom != null){
                generateOre(blockStateOre, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, blockToReplaceCustom);
            }}
        }
    }

    @SuppressWarnings("deprecation")
    private void generateIngotter(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreIngotterArray) {
            String oreName = ore.toLowerCase();

            // Block Name && Block Without Metadata
            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);

            if (!oreName.isEmpty() && ConfigOreHandler.oreIngotterBoolean && blockOre != null && ore.contains("-replace:") && !ore.contains("-dimension:") && !ore.contains("-biome:")) {

                // Metadata
                if(oreName.contains("-meta:")){
                String oreMetadata1 = oreName.substring(oreName.indexOf("-meta:"));
                String oreMetadata2 = oreMetadata1.contains(";") ? oreMetadata1.replace(";", "") : oreMetadata1.substring(0, oreMetadata1.indexOf(" "));
                String oreMetadata3 = oreMetadata2.replace("-meta:", "");
                oreMetadataIngotter = Integer.parseInt(oreMetadata3);
                }
                // Constants.LOGGER.info(oreMeta);

                // IBlockState
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadataIngotter);

                // Min Vein Size
                String minVein1 = oreName.substring(oreName.indexOf("-minvein:"));
                String minVein2 = minVein1.contains(";") ? minVein1.replace(";", "") : minVein1.substring(0, minVein1.indexOf(" "));
                String minVein3 = minVein2.replace("-minvein:", "");
                int minVein = Integer.parseInt(minVein3);
                // Constants.LOGGER.info(minVein);

                // Max Vein Size
                String maxVein1 = oreName.substring(oreName.indexOf("-maxvein:"));
                String maxVein2 = maxVein1.contains(";") ? maxVein1.replace(";", "") : maxVein1.substring(0, maxVein1.indexOf(" "));
                String maxVein3 = maxVein2.replace("-maxvein:", "");
                int maxVein = Integer.parseInt(maxVein3);
                // Constants.LOGGER.info(maxVein);

                // Min Y Level
                String yMin1 = oreName.substring(oreName.indexOf("-miny:"));
                String yMin2 = yMin1.contains(";") ? yMin1.replace(";", "") : yMin1.substring(0, yMin1.indexOf(" "));
                String yMin3 = yMin2.replace("-miny:", "");
                int minY = Integer.parseInt(yMin3);
                // Constants.LOGGER.info(minY);

                // Max Y Level
                String yMax1 = oreName.substring(oreName.indexOf("-maxy:"));
                String yMax2 = yMax1.contains(";") ? yMax1.replace(";", "") : yMax1.substring(0, yMax1.indexOf(" "));
                String yMax3 = yMax2.replace("-maxy:", "");
                int maxY = Integer.parseInt(yMax3);
                // Constants.LOGGER.info(maxY);

                // Per Chunk
                String perChunk1 = oreName.substring(oreName.indexOf("-perchunk:"));
                String perChunk2 = perChunk1.contains(";") ? perChunk1.replace(";", "") : perChunk1.substring(0, perChunk1.indexOf(" "));
                String perChunk3 = perChunk2.replace("-perchunk:", "");
                int perChunk = Integer.parseInt(perChunk3);
                // Constants.LOGGER.info(perChunk);

                // Block To Replace
                String block1 = oreName.substring(oreName.indexOf("-replace:"));
                String block2 = block1.replace("-replace:", "");
                String block3 = block2.contains(" -") ? block2.substring(0, block2.indexOf(" ")) : block2.replace(";", "");

                if (block3.contains(".")) {String[] block4 = block3.split("\\.");
                    for (String blockReplace : block4) {blockToReplaceIngotter = Block.getBlockFromName(blockReplace);}}
                else if(!block3.contains(".")){blockToReplaceIngotter = Block.getBlockFromName(block3);}

                if(blockToReplaceIngotter != null){
                generateOre(blockStateOre, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, blockToReplaceIngotter);
            }}
        }
    }

    private void generateOre(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        for (int i = 0; i < chancesToSpawn; i++) {
            WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
            //  Constants.LOGGER.info(blockToReplace);
            generator.generate(world, random, blockpos);
        }
    }
}
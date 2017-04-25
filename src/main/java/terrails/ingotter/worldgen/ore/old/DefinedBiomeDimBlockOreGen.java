package terrails.ingotter.worldgen.ore.old;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.commons.lang3.StringUtils;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Random;

public class DefinedBiomeDimBlockOreGen implements IWorldGenerator {

    private int oreMetadataCustom;
    private int oreMetadataIngotter;
    private String biomeCustom;
    private String biomeIngotter;
    private String dimCustom;
    private String dimIngotter;
    private Block blockToReplaceCustom;
    private Block blockToReplaceIngotter;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateCustom(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        generateIngotter(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    @SuppressWarnings("deprecation")
    private void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreArray) {
            String oreName = ore.toLowerCase();
            int minVein = 0;
            int maxVein = 0;
            int minY = 0;
            int maxY = 0;
            int perChunk = 0;
            int oreMetadata = 0;
            int biomeID = 0;
            int dimID = 0;
            Block blockReplace = Blocks.STONE;

            // Ore Name
            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);
            //System.out.println(nameOfOre);

            //Metadata
            if (oreName.contains("-meta:")) {
                String meta1 = oreName.substring(oreName.indexOf("-meta:")).replace("-meta:", "");
                String meta2 = meta1.contains(" -") ? meta1.substring(0, meta1.indexOf(" ")) : meta1.replace(";", "");
                oreMetadata = Integer.parseInt(meta2);
                //System.out.println(oreMetadata);
            }

            // IBlockState
            if(blockOre != null) {
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadata);
            }
            // Min Vein
            if (oreName.contains("-minvein:")) {
                String minVein1 = oreName.substring(oreName.indexOf("-minvein:")).replace("-minvein:", "");
                String minVein2 = minVein1.contains(" -") ? minVein1.substring(0, minVein1.indexOf(" ")) : minVein1.replace(";", "");
                minVein = Integer.parseInt(minVein2);
                //System.out.println(minVein);
            }

            // Max Vein Size
            if (oreName.contains("-maxvein:")) {
                String maxVein1 = oreName.substring(oreName.indexOf("-maxvein:")).replace("-maxvein:", "");
                String maxVein2 = maxVein1.contains(" -") ? maxVein1.substring(0, maxVein1.indexOf(" ")) : maxVein1.replace(";", "");
                maxVein = Integer.parseInt(maxVein2);
                //System.out.println(maxVein);
            }

            // Min Y Level
            if (oreName.contains("-miny:")) {
                String miny1 = oreName.substring(oreName.indexOf("-miny:")).replace("-miny:", "");
                String miny2 = miny1.contains(" -") ? miny1.substring(0, miny1.indexOf(" ")) : miny1.replace(";", "");
                minY = Integer.parseInt(miny2);
                //System.out.println(minY);
            }

            // Max Y Level
            if (oreName.contains("-maxy:")) {
                String maxy1 = oreName.substring(oreName.indexOf("-maxy:")).replace("-maxy:", "");
                String maxy2 = maxy1.contains(" -") ? maxy1.substring(0, maxy1.indexOf(" ")) : maxy1.replace(";", "");
                maxY = Integer.parseInt(maxy2);
                //System.out.println(maxY);
            }

            // Veins Per Chunk
            if (oreName.contains("-perchunk:")) {
                String perChunk1 = oreName.substring(oreName.indexOf("-perchunk:")).replace("-perchunk:", "");
                String perChunk2 = perChunk1.contains(" -") ? perChunk1.substring(0, perChunk1.indexOf(" ")) : perChunk1.replace(";", "");
                perChunk = Integer.parseInt(perChunk2);
                //System.out.println(perChunk);
            }

            // Dimension
            if (oreName.contains("-dimension:")) {
                String dim1 = oreName.substring(oreName.indexOf("-dimension:")).replace("-dimension:", "");
                String dim2 = dim1.contains(" -") ? dim1.substring(0, dim1.indexOf(" ")) : dim1.replace(";", "");
                if (!dim2.contains(".")) {dimID = Integer.parseInt(dim2);}
                else if (dim2.contains(".")) {String[] dim3 = dim2.split("\\.");
                for (String dim : dim3) {dimID = Integer.parseInt(dim);}}
                //System.out.println(dimID);
            }

            // Block To Replace
            if (oreName.contains("-replace:")) {
                String replace1 = oreName.substring(oreName.indexOf("-replace:")).replace("-replace:", "");
                String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" ")) : replace1.replace(";", "");
                if (!replace2.contains(".")) {blockReplace = Block.getBlockFromName(replace2);}
                else if (replace2.contains(".")) {String[] replace3 = replace2.split("\\.");
                for (String block : replace3) {blockReplace = Block.getBlockFromName(block);}}
            }

            // Biome
            if (oreName.contains("-biome:")) {
                String biome1 = oreName.substring(oreName.indexOf("-biome:")).replace("-biome:", "");
                String biome2 = biome1.contains(" -") ? biome1.substring(0, biome1.indexOf(" ")) : biome1.replace(";", "");
                if (!biome2.contains(".")) {biomeID = Integer.parseInt(biome2);}
                else if (biome2.contains(".")) {String[] biome3 = biome2.split("\\.");
                for (String biome : biome3) {biomeID = Integer.parseInt(biome);}}
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void generateIngotter(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreIngotterArray) {
            String oreName = ore.toLowerCase();

            // Block Name && Block Without Metadata
            String nameOfOre = StringUtils.substringBefore(oreName," -");
            Block blockOre = Block.getBlockFromName(nameOfOre);

            if (!oreName.isEmpty() && ConfigOreHandler.oreIngotterBoolean && blockOre != null && oreName.contains("-dimension:") && oreName.contains("-replace:") && oreName.contains("-biome:")) {

                // Metadata
                if(oreName.contains("-meta:")){
                    String oreMetadata1 = oreName.substring(oreName.indexOf("-meta:"));
                    String oreMetadata2 = oreMetadata1.contains(" -") ? oreMetadata1.substring(0, oreMetadata1.indexOf(" ")) : oreMetadata1.replace(";", "");
                    String oreMetadata3 = oreMetadata2.replace("-meta:", "");
                    oreMetadataIngotter = Integer.parseInt(oreMetadata3);
                    // Constants.LOGGER.info(oreMeta);
                }

                // IBlockState
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadataIngotter);

                // Min Vein Size
                String minVein1 = oreName.substring(oreName.indexOf("-minvein:"));
                String minVein2 = minVein1.contains(" -") ? minVein1.substring(0, minVein1.indexOf(" ")): minVein1.replace(";", "");
                String minVein3 = minVein2.replace("-minvein:", "");
                int minVein = Integer.parseInt(minVein3);
                // Constants.LOGGER.info(minVein);

                // Max Vein Size
                String maxVein1 = oreName.substring(oreName.indexOf("-maxvein:"));
                String maxVein2 = maxVein1.contains(" -") ? maxVein1.substring(0, maxVein1.indexOf(" ")) : maxVein1.replace(";", "");
                String maxVein3 = maxVein2.replace("-maxvein:", "");
                int maxVein = Integer.parseInt(maxVein3);
                // Constants.LOGGER.info(maxVein);

                // Min Y Level
                String yMin1 = oreName.substring(oreName.indexOf("-miny:"));
                String yMin2 = yMin1.contains(" -") ? yMin1.substring(0, yMin1.indexOf(" ")) : yMin1.replace(";", "");
                String yMin3 = yMin2.replace("-miny:", "");
                int minY = Integer.parseInt(yMin3);
                // Constants.LOGGER.info(minY);

                // Max Y Level
                String yMax1 = oreName.substring(oreName.indexOf("-maxy:"));
                String yMax2 = yMax1.contains(" -") ? yMax1.substring(0, yMax1.indexOf(" ")) : yMax1.replace(";", "");
                String yMax3 = yMax2.replace("-maxy:", "");
                int maxY = Integer.parseInt(yMax3);
                // Constants.LOGGER.info(maxY);

                // Per Chunk
                String perChunk1 = oreName.substring(oreName.indexOf("-perchunk:"));
                String perChunk2 = perChunk1.contains(" -") ? perChunk1.substring(0, perChunk1.indexOf(" ")) : perChunk1.replace(";", "");
                String perChunk3 = perChunk2.replace("-perchunk:", "");
                int perChunk = Integer.parseInt(perChunk3);
                // Constants.LOGGER.info(perChunk);

                // Biome
                String biome1 = oreName.substring(oreName.indexOf("-biome:"));
                String biome2 = biome1.replace("-biome:", "");
                String biome3 = biome2.contains(" -") ? biome2.substring(0, biome2.indexOf(" ")) : biome2.replace(";", "");

                if (biome3.contains(".")) {String[] biome4 = biome3.split("\\.");
                    for (String biome : biome4) {biomeIngotter = biome;}}
                else if(!biome3.contains(".")){biomeIngotter = biome3;}

                // Dimension
                String dim1 = oreName.substring(oreName.indexOf("-dimension:"));
                String dim2 = dim1.replace("-dimension:", "");
                String dim3 = dim2.contains(" -") ? dim2.substring(0, dim2.indexOf(" ")) : dim2.replace(";", "");

                if (dim3.contains(".")) {String[] dim4 = dim3.split("\\.");
                    for (String dim : dim4) {dimIngotter = dim;}}
                else if(!dim3.contains(".")){dimIngotter = dim3;}
                // Constants.LOGGER.info("THE DIMENSION FOR: " + blockOre + " IS " + dimIngotter);
                
                // Block To Replace
                String block1 = oreName.substring(oreName.indexOf("-replace:"));
                String block2 = block1.replace("-replace:", "");
                String block3 = block2.contains(" -") ? block2.substring(0, block2.indexOf(" ")) : block2.replace(";", "");

                if (block3.contains(".")) {String[] block4 = block3.split("\\.");
                    for (String blockReplace : block4) {blockToReplaceIngotter = Block.getBlockFromName(blockReplace);}}
                else if(!block3.contains(".")){blockToReplaceIngotter = Block.getBlockFromName(block3);}
                
                if(biomeIngotter != null && dimIngotter != null && blockToReplaceIngotter != null){
                    generateOre(blockStateOre, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, Integer.parseInt(dimIngotter), Integer.parseInt(biomeIngotter), blockToReplaceIngotter);
                }}
        }
    }

    private void generateOre(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, int biomeID, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if(world.provider.getDimension() == dimension && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
                generator.generate(world, random, blockpos);}
        }
    }
}
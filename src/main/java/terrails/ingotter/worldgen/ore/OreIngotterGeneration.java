package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.StringUtils;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Random;

public class OreIngotterGeneration implements IWorldGenerator {

    int minVein;
    int maxVein;
    int minY;
    int maxY;
    int perChunk;
    int oreMetadata;
    int biomeID;
    int dimID;
    Block blockReplace;
    IBlockState oreBlock;

    @SubscribeEvent
    public void generation(OreGenEvent.GenerateMinable event){
        for (String ore : ConfigOreHandler.oreIngotterArray) {
            String oreName = ore.toLowerCase();
            String nameOfOre = StringUtils.substringBefore(oreName, " -");

            if(event.getGenerator() instanceof WorldGenMinable){
            switch(event.getType()) {
                case COAL:
                    if (nameOfOre.contains("minecraft:coal_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case DIAMOND:
                    if (nameOfOre.contains("minecraft:diamond_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case GOLD:
                    if (nameOfOre.contains("minecraft:gold_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case IRON:
                    if (nameOfOre.contains("minecraft:iron_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case LAPIS:
                    if (nameOfOre.contains("minecraft:lapis_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case REDSTONE:
                    if (nameOfOre.contains("minecraft:redstone_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case QUARTZ:
                    if (nameOfOre.contains("minecraft:quartz_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case EMERALD:
                    if (nameOfOre.contains("minecraft:emerald_ore")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case DIRT:
                    if (nameOfOre.contains("minecraft:dirt")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case GRAVEL:
                    if (nameOfOre.contains("minecraft:gravel")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case DIORITE:
                    if (nameOfOre.contains("minecraft:diorite")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case GRANITE:
                    if (nameOfOre.contains("minecraft:granite")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
                case ANDESITE:
                    if (nameOfOre.contains("minecraft:andesite")) {
                        event.setResult(Event.Result.DENY);
                    }
                    break;
            }
        }}
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateIngotter(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
    }

    @SuppressWarnings("deprecation")
    private void generateIngotter(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    //    StringBuilder stringBuilder = new StringBuilder();
    //    for (int i = 0; i < ConfigOreHandler.oreIngotterArray.length; i++) {
    //        stringBuilder.append(ConfigOreHandler.oreIngotterArray[i]);
     //   }
     //   String[] oreArray = stringBuilder.toString().split(";");
        for (String ore : ConfigOreHandler.oreIngotterArray) {
            String oreName = ore.toLowerCase();
          //  System.out.println(oreName);

            // Ore Name
            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);
            //System.out.println(nameOfOre);
            if(blockOre != null) {
            //Metadata
            if (oreName.contains("-meta:")) {
                String meta1 = oreName.substring(oreName.indexOf("-meta:")).replace("-meta:", "");
                String meta2 = meta1.contains(" -") ? meta1.substring(0, meta1.indexOf(" ")) : meta1.replace(";", "");
                oreMetadata = Integer.parseInt(meta2);
                //System.out.println(oreMetadata);
            }

            // IBlockState
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadata);
                oreBlock = blockStateOre;

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
            boolean dimension = oreName.contains("-dimension:");
            boolean biome = oreName.contains("-biome:");
            boolean blockToReplace = oreName.contains("-replace:");

            if(!dimension && !biome && !blockToReplace){
                generateNormal(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk);
            }
            if(!dimension && !biome && blockToReplace){
                generateReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, blockReplace);
            }
            if(!dimension && biome && blockToReplace){
                generateBiomeReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, biomeID, blockReplace);
            }
            if(dimension && biome && blockToReplace) {
                generateDimBiomeReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, biomeID, blockReplace);
            }
            if(dimension && biome && !blockToReplace){
                generateDimBiome(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, biomeID);
            }
            if(dimension && !biome && !blockToReplace){
                generateDim(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID);
            }
            if(!dimension && biome && !blockToReplace){
                generateBiome(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, biomeID);
            }
            if(dimension && !biome && blockToReplace){
                generateDimReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, blockReplace);
            }
        }}
    }

    private void generateNormal(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn){
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        for (int i = 0; i < chancesToSpawn; i++) {
            WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
            generator.generate(world, random, blockpos);}
    }

    private void generateReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, Block blockToReplace){
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        for (int i = 0; i < chancesToSpawn; i++) {
            WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
            generator.generate(world, random, blockpos);}
    }
    private void generateDim(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension){
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        int currentDimension = world.provider.getDimension();
        if(currentDimension == dimension && currentDimension == 0){
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                generator.generate(world, random, blockpos);}}

        else if(currentDimension == dimension && currentDimension == -1){
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.NETHERRACK);
                generator.generate(world, random, blockpos);}}

        else if(currentDimension == dimension && currentDimension == 1){
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.END_STONE);
                generator.generate(world, random, blockpos);}}

        else if(currentDimension == dimension){
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                generator.generate(world, random, blockpos);}}
    }
    private void generateBiome(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int biomeID) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        Biome currentBiome = world.getBiome(blockpos);
        if (currentBiome == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                generator.generate(world, random, blockpos);}}
    }

    private void generateDimReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if(world.provider.getDimension() == dimension) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
                generator.generate(world, random, blockpos);}
        }
    }
    private void generateBiomeReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int biomeID, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if(world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
                generator.generate(world, random, blockpos);}
        }
    }

    private void generateDimBiome(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, int biomeID) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        int currentDimension = world.provider.getDimension();
        if(currentDimension == dimension && currentDimension == 0 && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                generator.generate(world, random, blockpos);}
        }
        else if(currentDimension == dimension && currentDimension == -1 && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.NETHERRACK);
                generator.generate(world, random, blockpos);}
        }
        else if(currentDimension == dimension && currentDimension == 1 && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.END_STONE);
                generator.generate(world, random, blockpos);}
        }
        else if(currentDimension == dimension && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                generator.generate(world, random, blockpos);}
        }
    }

    private void generateDimBiomeReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, int biomeID, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        int currentDimension = world.provider.getDimension();
        if(currentDimension == dimension && world.getBiome(blockpos) == Biome.getBiome(biomeID)) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
                generator.generate(world, random, blockpos);}
        }
    }

}

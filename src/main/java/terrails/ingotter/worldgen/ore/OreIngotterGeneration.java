package terrails.ingotter.worldgen.ore;

import com.google.common.base.CharMatcher;
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

    @SubscribeEvent
    public void generation(OreGenEvent.GenerateMinable event){
        for (String ore : ConfigOreHandler.oreIngotterArray) {
            String oreName = ore.toLowerCase();
            String nameOfOre = StringUtils.substringBefore(oreName, " -");

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
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(ConfigOreHandler.oreIngotterBoolean) {
            generateIngotter(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    @SuppressWarnings("deprecation")
    private void generateIngotter(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String theArray : ConfigOreHandler.oreIngotterArray) {
            String blockArray = theArray.toLowerCase();

            boolean containsMetadata = blockArray.contains(" -meta:");
            boolean containsMinY = blockArray.contains(" -miny:");
            boolean containsMaxY = blockArray.contains(" -maxy:");
            boolean containsMinVein = blockArray.contains(" -minvein:");
            boolean containsMaxVein = blockArray.contains(" -maxvein:");
            boolean containsBiome = blockArray.contains(" -biome:");
            boolean containsDim = blockArray.contains(" -dimension:");
            boolean containsReplace = blockArray.contains(" -replace:");
            boolean containsStuff = containsMinY && containsMaxY && containsMinVein && containsMaxVein;

            int minY = StringChecker.minY(blockArray);
            int maxY = StringChecker.maxY(blockArray);
            int minVein = StringChecker.minVein(blockArray);
            int maxVein = StringChecker.maxVein(blockArray);
            int perChunk = StringChecker.perChunk(blockArray);
            int BiomeID = StringChecker.biomeID(blockArray);
            int DimensionID = StringChecker.dimensionID(blockArray);
            IBlockState GeneratingBlock = StringChecker.generatingBlock(blockArray);
            Block BlockReplace = StringChecker.replaceBlock(blockArray);

            if (containsStuff && GeneratingBlock != null) {
                if (!containsDim && !containsBiome && !containsReplace) {
                    generateNormal(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk);
                }
                if (!containsDim && !containsBiome && containsReplace && BlockReplace != null) {
                    generateReplace(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, BlockReplace);
                }
                if (!containsDim && containsBiome && containsReplace && BlockReplace != null) {
                    generateBiomeReplace(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, BiomeID, BlockReplace);
                }
                if (containsDim && containsBiome && containsReplace && BlockReplace != null) {
                    generateDimBiomeReplace(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, DimensionID, BiomeID, BlockReplace);
                }
                if (containsDim && containsBiome && !containsReplace) {
                    generateDimBiome(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, DimensionID, BiomeID);
                }
                if (containsDim && !containsBiome && !containsReplace) {
                    generateDim(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, DimensionID);
                }
                if (!containsDim && containsBiome && !containsReplace) {
                    generateBiome(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, BiomeID);
                }
                if (containsDim && !containsBiome && containsReplace && BlockReplace != null) {
                    generateDimReplace(GeneratingBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, DimensionID, BlockReplace);
                }
            }
        }
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


    /*
                String stringMeta = containsMetadata ? blockArray.replaceAll("^.*( -meta:\\d+).*$", "$1") : " -meta:0";
                String stringMinY = blockArray.replaceAll("^.*( -miny:\\d+).*$", "$1");
                String stringMaxY = blockArray.replaceAll("^.*( -maxy:\\d+).*$", "$1");
                String stringMinVein = blockArray.replaceAll("^.*( -minvein:\\d+).*$", "$1");
                String stringMaxVein = blockArray.replaceAll("^.*( -maxvein:\\d+).*$", "$1");
                String stringPerChunk = blockArray.replaceAll("^.*( -perchunk:\\d+).*$", "$1");

                String metaDigit = CharMatcher.DIGIT.retainFrom(stringMeta);
                String minYDigit = CharMatcher.DIGIT.retainFrom(stringMinY);
                String maxYDigit = CharMatcher.DIGIT.retainFrom(stringMaxY);
                String minVeinDigit = CharMatcher.DIGIT.retainFrom(stringMinVein);
                String maxVeinDigit = CharMatcher.DIGIT.retainFrom(stringMaxVein);
                String perChunkDigit = CharMatcher.DIGIT.retainFrom(stringPerChunk);

                int meta = Integer.parseInt(metaDigit);
                int minY = Integer.parseInt(minYDigit);
                int maxY = Integer.parseInt(maxYDigit);
                int minVein = Integer.parseInt(minVeinDigit);
                int maxVein = Integer.parseInt(maxVeinDigit);
                int perChunk = Integer.parseInt(perChunkDigit);

                String stringBlock = blockArray.substring(0, blockArray.indexOf(" -"));
                Block theBlockThingy = Block.getBlockFromName(stringBlock);
                if(theBlockThingy != null) {
                    GeneratingBlock = theBlockThingy.getStateFromMeta(meta);
                }
            /*
            // Printing
            System.out.println(stringBlock);
            System.out.println(stringMeta);
            System.out.println(stringMinY);
            System.out.println(stringMaxY);
            System.out.println(stringMinVein);
            System.out.println(stringMaxVein);
            System.out.println(stringPerChunk);


                if (containsBiome) {
                    String biome1 = blockArray.substring(blockArray.indexOf("-biome:")).replace("-biome:", "");
                    String biome2 = biome1.contains(" -") ? biome1.substring(0, biome1.indexOf(" ")) : biome1.replace(";", "");
                    if (!biome2.contains("|")) {
                        BiomeID = Integer.parseInt(biome2);
                        //System.out.println(biome2);
                    } else if (biome2.contains("|")) {
                        String[] biome3 = biome2.split("\\|");
                        for (String biome : biome3) {
                            BiomeID = Integer.parseInt(biome);
                            //System.out.println("biome:" + biome);
                        }
                    }
                }

                if (containsDim) {
                    String dim1 = blockArray.substring(blockArray.indexOf("-dimension:")).replace("-dimension:", "");
                    String dim2 = dim1.contains(" -") ? dim1.substring(0, dim1.indexOf(" ")) : dim1.replace(";", "");
                    if (!dim2.contains("|")) {
                        DimensionID = Integer.parseInt(dim2);
                        //System.out.println(dim2);
                    } else if (dim2.contains("|")) {
                        String[] dim3 = dim2.split("\\|");
                        for (String dim : dim3) {
                            DimensionID = Integer.parseInt(dim);
                            //System.out.println("dimension:" + dim);
                        }
                    }
                }

                if (containsReplace) {
                    String replace1 = blockArray.substring(blockArray.indexOf("-replace:")).replace("-replace:", "");
                    String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" ")) : replace1.replace(";", "");
                    if (!replace2.contains("|")) {
                        String replaceMetaString = !replace2.contains("-meta:") ? "-meta:0" : replace2.substring(replace2.indexOf("-meta:"));
                        String replaceMetaDigit = CharMatcher.DIGIT.retainFrom(replaceMetaString);
                        int replaceMeta = Integer.parseInt(replaceMetaDigit);

                        String replaceString = !replace2.contains("-meta:") ? replace2 : StringUtils.substringBefore(replace2, "-meta:");
                        //System.out.println("Metadata is:" + replaceMeta + ", The Block is:" + replaceString);

                        Block theBlock = Block.getBlockFromName(replaceString);
                        if (theBlock != null) {
                            BlockReplace = theBlock.getStateFromMeta(replaceMeta);
                        }
                    }
                    /* else if (replace2.contains("|")) {
                        String[] replace3 = replace2.split("\\|");
                        for (String replace4 : replace3) {
                            //System.out.println("The Array is: " + replace4);
                            String replaceMetaString = !replace4.contains("-meta:") ? "-meta:0" : replace4.substring(replace4.indexOf("-meta:"));
                            String replaceMetaDigit = CharMatcher.DIGIT.retainFrom(replaceMetaString);
                            //System.out.println("The Meta String: " + replaceMetaString);
                            //System.out.println("The Meta Digit: " + replaceMetaDigit);
                            int replaceMeta = Integer.parseInt(replaceMetaDigit);

                            String replaceString = !replace4.contains("-meta:") ? replace4 : StringUtils.substringBefore(replace4, "-meta:");
                            //System.out.println("Metadata is:" + replaceMeta + ", The Block is:" + replaceString);

                            Block theBlock = Block.getBlockFromName(replaceString);
                            if (theBlock != null) {
                                BlockReplace = theBlock.getStateFromMeta(replaceMeta);
                            }
                        }
                    }*/
}

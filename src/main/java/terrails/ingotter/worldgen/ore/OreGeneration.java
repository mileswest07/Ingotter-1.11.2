package terrails.ingotter.worldgen.ore;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
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

public class OreGeneration implements IWorldGenerator {


    @SubscribeEvent
    public void generation(OreGenEvent.GenerateMinable event){
        for (String ore : ConfigOreHandler.oreArray) {
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
        if(ConfigOreHandler.oreBoolean) {
            generateCustom(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    @SuppressWarnings("deprecation")
    private void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String theArray : ConfigOreHandler.oreArray) {
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

    public void generateReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, Block blockToReplace){
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

    public void generateDimReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, Block blockToReplace) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if(world.provider.getDimension() == dimension) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenIngotterMinable generator = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, blockToReplace);
                generator.generate(world, random, blockpos);}
        }
    }
    public void generateBiomeReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int biomeID, Block blockToReplace) {
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

    public void generateDimBiomeReplace(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, int dimension, int biomeID, Block blockToReplace) {
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

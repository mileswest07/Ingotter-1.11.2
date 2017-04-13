package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import terrails.ingotter.config.ore.ConfigNetherHandler;
import terrails.ingotter.config.ore.ConfigOverworldHandler;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.List;
import java.util.Random;

public class OverworldOreGen implements IWorldGenerator{

    @SubscribeEvent
    public void disableVanilla(OreGenEvent.GenerateMinable event) {
        switch (event.getType()) {
            case COAL:
            case DIAMOND:
                //    case DIRT:
            case GOLD:
                //    case GRAVEL:
            case IRON:
            case LAPIS:
            case REDSTONE:
                //        case QUARTZ:
                //    case DIORITE:
                //    case GRANITE:
                //    case ANDESITE:
            case EMERALD:
                //    case SILVERFISH:
                //    case CUSTOM:
                event.setResult(Event.Result.DENY);
                break;
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        //Vanilla
        generateOre(ConfigOverworldHandler.iron, Blocks.IRON_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.ironMinY, ConfigOverworldHandler.ironMaxY, ConfigOverworldHandler.ironMinVeinSize, ConfigOverworldHandler.ironMaxVeinSize, ConfigOverworldHandler.ironVeinChance);
        generateOre(ConfigOverworldHandler.gold, Blocks.GOLD_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.goldMinY, ConfigOverworldHandler.goldMaxY, ConfigOverworldHandler.goldMinVeinSize, ConfigOverworldHandler.goldMaxVeinSize, ConfigOverworldHandler.goldVeinChance);
        generateOre(ConfigOverworldHandler.diamond, Blocks.DIAMOND_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.diamondMinY, ConfigOverworldHandler.diamondMaxY, ConfigOverworldHandler.diamondMinVeinSize, ConfigOverworldHandler.diamondMaxVeinSize, ConfigOverworldHandler.diamondVeinChance);
        generateOre(ConfigOverworldHandler.emerald && !ConfigOverworldHandler.spawnInExtremeHills, Blocks.EMERALD_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.emeraldMinY, ConfigOverworldHandler.emeraldMaxY, ConfigOverworldHandler.emeraldMinVeinSize, ConfigOverworldHandler.emeraldMaxVeinSize, ConfigOverworldHandler.emeraldVeinChance);
        generateOre(ConfigOverworldHandler.coal, Blocks.COAL_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.coalMinY, ConfigOverworldHandler.coalMaxY, ConfigOverworldHandler.coalMinVeinSize, ConfigOverworldHandler.coalMaxVeinSize, ConfigOverworldHandler.coalVeinChance);
        generateOre(ConfigOverworldHandler.lapis, Blocks.LAPIS_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.lapisMinY, ConfigOverworldHandler.lapisMaxY, ConfigOverworldHandler.lapisMinVeinSize, ConfigOverworldHandler.lapisMaxVeinSize, ConfigOverworldHandler.lapisVeinChance);
        generateOre(ConfigOverworldHandler.redstone, Blocks.REDSTONE_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.redstoneMinY, ConfigOverworldHandler.redstoneMaxY, ConfigOverworldHandler.redstoneMinVeinSize, ConfigOverworldHandler.redstoneMaxVeinSize, ConfigOverworldHandler.redstoneVeinChance);

        //Modded
        generateOre(ConfigOverworldHandler.copper, ModOres.oreCopper, world, random, chunkX, chunkZ, ConfigOverworldHandler.copperMinY, ConfigOverworldHandler.copperMaxY, ConfigOverworldHandler.copperMinVeinSize, ConfigOverworldHandler.copperMaxVeinSize, ConfigOverworldHandler.copperVeinChance);
        generateOre(ConfigOverworldHandler.tin, ModOres.oreTin, world, random, chunkX, chunkZ, ConfigOverworldHandler.tinMinY, ConfigOverworldHandler.tinMaxY, ConfigOverworldHandler.tinMinVeinSize, ConfigOverworldHandler.tinMaxVeinSize, ConfigOverworldHandler.tinVeinChance);
        generateOre(ConfigOverworldHandler.silver, ModOres.oreSilver, world, random, chunkX, chunkZ, ConfigOverworldHandler.silverMinY, ConfigOverworldHandler.silverMaxY, ConfigOverworldHandler.silverMinVeinSize, ConfigOverworldHandler.silverMaxVeinSize, ConfigOverworldHandler.silverVeinChance);
        generateOre(ConfigOverworldHandler.lead, ModOres.oreLead, world, random, chunkX, chunkZ, ConfigOverworldHandler.leadMinY, ConfigOverworldHandler.leadMaxY, ConfigOverworldHandler.leadMinVeinSize, ConfigOverworldHandler.leadMaxVeinSize, ConfigOverworldHandler.leadVeinChance);
        generateOre(ConfigOverworldHandler.aluminum, ModOres.oreAluminum, world, random, chunkX, chunkZ, ConfigOverworldHandler.aluminumMinY, ConfigOverworldHandler.aluminumMaxY, ConfigOverworldHandler.aluminumMinVeinSize, ConfigOverworldHandler.aluminumMaxVeinSize, ConfigOverworldHandler.aluminumVeinChance);
        generateOre(ConfigOverworldHandler.nickel, ModOres.oreNickel, world, random, chunkX, chunkZ, ConfigOverworldHandler.nickelMinY, ConfigOverworldHandler.nickelMaxY, ConfigOverworldHandler.nickelMinVeinSize, ConfigOverworldHandler.nickelMaxVeinSize, ConfigOverworldHandler.nickelVeinChance);
        generateOre(ConfigOverworldHandler.platinum, ModOres.orePlatinum, world, random, chunkX, chunkZ, ConfigOverworldHandler.platinumMinY, ConfigOverworldHandler.platinumMaxY, ConfigOverworldHandler.platinumMinVeinSize, ConfigOverworldHandler.platinumMaxVeinSize, ConfigOverworldHandler.platinumVeinChance);
        generateOre(ConfigOverworldHandler.steel, ModOres.oreSteel, world, random, chunkX, chunkZ, ConfigOverworldHandler.steelMinY, ConfigOverworldHandler.steelMaxY, ConfigOverworldHandler.steelMinVeinSize, ConfigOverworldHandler.steelMaxVeinSize, ConfigOverworldHandler.steelVeinChance);
        generateOre(ConfigOverworldHandler.electrum, ModOres.oreElectrum, world, random, chunkX, chunkZ, ConfigOverworldHandler.electrumMinY, ConfigOverworldHandler.electrumMaxY, ConfigOverworldHandler.electrumMinVeinSize, ConfigOverworldHandler.electrumMaxVeinSize, ConfigOverworldHandler.electrumVeinChance);
        generateOre(ConfigOverworldHandler.bronze, ModOres.oreBronze, world, random, chunkX, chunkZ, ConfigOverworldHandler.bronzeMinY, ConfigOverworldHandler.bronzeMaxY, ConfigOverworldHandler.bronzeMinVeinSize, ConfigOverworldHandler.bronzeMaxVeinSize, ConfigOverworldHandler.bronzeVeinChance);

        //Biome Specific
        generateBiomeOre(ConfigOverworldHandler.emerald && ConfigOverworldHandler.spawnInExtremeHills, Blocks.EMERALD_ORE, world, random, chunkX, chunkZ, ConfigOverworldHandler.emeraldMinY, ConfigOverworldHandler.emeraldMaxY, ConfigOverworldHandler.emeraldMinVeinSize, ConfigOverworldHandler.emeraldMaxVeinSize, ConfigOverworldHandler.emeraldVeinChance, Biomes.EXTREME_HILLS);

    }
    private void generateOre(boolean condition, Block ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if (condition && ConfigOverworldHandler.oreGen && world.provider.getDimension() == 0) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenerator overworld = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                overworld.generate(world, random, blockpos);
            }
        }
    }
    private void generateBiomeOre(boolean condition, Block ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn, Biome biome) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        Biome currentBiome = world.getBiome(blockpos);
        if (condition && ConfigOverworldHandler.oreGen && world.provider.getDimension() == 0 && currentBiome == biome) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenerator overworld = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.STONE);
                overworld.generate(world, random, blockpos);
            }
        }
    }
}

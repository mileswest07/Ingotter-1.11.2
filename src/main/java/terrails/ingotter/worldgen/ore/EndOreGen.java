package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import terrails.ingotter.config.ore.ConfigEndHandler;
import terrails.ingotter.config.ore.ConfigNetherHandler;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Random;

public class EndOreGen implements IWorldGenerator {

    @SubscribeEvent
    public void disableVanilla(OreGenEvent.GenerateMinable event) {
        switch (event.getType()) {
            case QUARTZ:
                event.setResult(Event.Result.DENY);
                break;
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        //Vanilla
        generateOre(ConfigEndHandler.iron, ModOres.oreEndIron, world, random, chunkX, chunkZ, ConfigEndHandler.ironMinY, ConfigEndHandler.ironMaxY, ConfigEndHandler.ironMinVeinSize, ConfigEndHandler.ironMaxVeinSize, ConfigEndHandler.ironVeinChance);
        generateOre(ConfigEndHandler.gold, ModOres.oreEndGold, world, random, chunkX, chunkZ, ConfigEndHandler.goldMinY, ConfigEndHandler.goldMaxY, ConfigEndHandler.goldMinVeinSize, ConfigEndHandler.goldMaxVeinSize, ConfigEndHandler.goldVeinChance);
        generateOre(ConfigEndHandler.diamond, ModOres.oreEndDiamond, world, random, chunkX, chunkZ, ConfigEndHandler.diamondMinY, ConfigEndHandler.diamondMaxY, ConfigEndHandler.diamondMinVeinSize, ConfigEndHandler.diamondMaxVeinSize, ConfigEndHandler.diamondVeinChance);
        generateOre(ConfigEndHandler.emerald, ModOres.oreEndEmerald, world, random, chunkX, chunkZ, ConfigEndHandler.emeraldMinY, ConfigEndHandler.emeraldMaxY, ConfigEndHandler.emeraldMinVeinSize, ConfigEndHandler.emeraldMaxVeinSize, ConfigEndHandler.emeraldVeinChance);
        generateOre(ConfigEndHandler.coal, ModOres.oreEndCoal, world, random, chunkX, chunkZ, ConfigEndHandler.coalMinY, ConfigEndHandler.coalMaxY, ConfigEndHandler.coalMinVeinSize, ConfigEndHandler.coalMaxVeinSize, ConfigEndHandler.coalVeinChance);
        generateOre(ConfigEndHandler.lapis, ModOres.oreEndLapis, world, random, chunkX, chunkZ, ConfigEndHandler.lapisMinY, ConfigEndHandler.lapisMaxY, ConfigEndHandler.lapisMinVeinSize, ConfigEndHandler.lapisMaxVeinSize, ConfigEndHandler.lapisVeinChance);
        generateOre(ConfigEndHandler.redstone, ModOres.oreEndRedstone, world, random, chunkX, chunkZ, ConfigEndHandler.redstoneMinY, ConfigEndHandler.redstoneMaxY, ConfigEndHandler.redstoneMinVeinSize, ConfigEndHandler.redstoneMaxVeinSize, ConfigEndHandler.redstoneVeinChance);

        //Modded
        generateOre(ConfigEndHandler.copper, ModOres.oreEndCopper, world, random, chunkX, chunkZ, ConfigEndHandler.copperMinY, ConfigEndHandler.copperMaxY, ConfigEndHandler.copperMinVeinSize, ConfigEndHandler.copperMaxVeinSize, ConfigEndHandler.copperVeinChance);
        generateOre(ConfigEndHandler.tin, ModOres.oreEndTin, world, random, chunkX, chunkZ, ConfigEndHandler.tinMinY, ConfigEndHandler.tinMaxY, ConfigEndHandler.tinMinVeinSize, ConfigEndHandler.tinMaxVeinSize, ConfigEndHandler.tinVeinChance);
        generateOre(ConfigEndHandler.silver, ModOres.oreEndSilver, world, random, chunkX, chunkZ, ConfigEndHandler.silverMinY, ConfigEndHandler.silverMaxY, ConfigEndHandler.silverMinVeinSize, ConfigEndHandler.silverMaxVeinSize, ConfigEndHandler.silverVeinChance);
        generateOre(ConfigEndHandler.lead, ModOres.oreEndLead, world, random, chunkX, chunkZ, ConfigEndHandler.leadMinY, ConfigEndHandler.leadMaxY, ConfigEndHandler.leadMinVeinSize, ConfigEndHandler.leadMaxVeinSize, ConfigEndHandler.leadVeinChance);
        generateOre(ConfigEndHandler.aluminum, ModOres.oreEndAluminum, world, random, chunkX, chunkZ, ConfigEndHandler.aluminumMinY, ConfigEndHandler.aluminumMaxY, ConfigEndHandler.aluminumMinVeinSize, ConfigEndHandler.aluminumMaxVeinSize, ConfigEndHandler.aluminumVeinChance);
        generateOre(ConfigEndHandler.nickel, ModOres.oreEndNickel, world, random, chunkX, chunkZ, ConfigEndHandler.nickelMinY, ConfigEndHandler.nickelMaxY, ConfigEndHandler.nickelMinVeinSize, ConfigEndHandler.nickelMaxVeinSize, ConfigEndHandler.nickelVeinChance);
        generateOre(ConfigEndHandler.platinum, ModOres.oreEndPlatinum, world, random, chunkX, chunkZ, ConfigEndHandler.platinumMinY, ConfigEndHandler.platinumMaxY, ConfigEndHandler.platinumMinVeinSize, ConfigEndHandler.platinumMaxVeinSize, ConfigEndHandler.platinumVeinChance);
        generateOre(ConfigEndHandler.steel, ModOres.oreEndSteel, world, random, chunkX, chunkZ, ConfigEndHandler.steelMinY, ConfigEndHandler.steelMaxY, ConfigEndHandler.steelMinVeinSize, ConfigEndHandler.steelMaxVeinSize, ConfigEndHandler.steelVeinChance);
        generateOre(ConfigEndHandler.electrum, ModOres.oreEndElectrum, world, random, chunkX, chunkZ, ConfigEndHandler.electrumMinY, ConfigEndHandler.electrumMaxY, ConfigEndHandler.electrumMinVeinSize, ConfigEndHandler.electrumMaxVeinSize, ConfigEndHandler.electrumVeinChance);
        generateOre(ConfigEndHandler.bronze, ModOres.oreEndBronze, world, random, chunkX, chunkZ, ConfigEndHandler.bronzeMinY, ConfigEndHandler.bronzeMaxY, ConfigEndHandler.bronzeMinVeinSize, ConfigEndHandler.bronzeMaxVeinSize, ConfigEndHandler.bronzeVeinChance);
    }
    
    private void generateOre(boolean condition, Block ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if (condition && ConfigEndHandler.oreGen && world.provider.getDimension() == 1) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenerator nether = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.END_STONE);
                nether.generate(world, random, blockpos);
            }
        }
    }
}


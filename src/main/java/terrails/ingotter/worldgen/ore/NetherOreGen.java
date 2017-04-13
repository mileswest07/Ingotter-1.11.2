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
import terrails.ingotter.config.ore.ConfigNetherHandler;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.worldgen.generator.WorldGenIngotterMinable;

import java.util.Random;

public class NetherOreGen implements IWorldGenerator {

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
        generateOre(ConfigNetherHandler.quartz, Blocks.QUARTZ_ORE, world, random, chunkX, chunkZ, ConfigNetherHandler.quartzMinY, ConfigNetherHandler.quartzMaxY, ConfigNetherHandler.quartzMinVeinSize, ConfigNetherHandler.quartzMaxVeinSize, ConfigNetherHandler.quartzVeinChance);

        //Modded
        generateOre(ConfigNetherHandler.iron, ModOres.oreNetherIron, world, random, chunkX, chunkZ, ConfigNetherHandler.ironMinY, ConfigNetherHandler.ironMaxY, ConfigNetherHandler.ironMinVeinSize, ConfigNetherHandler.ironMaxVeinSize, ConfigNetherHandler.ironVeinChance);
        generateOre(ConfigNetherHandler.gold, ModOres.oreNetherGold, world, random, chunkX, chunkZ, ConfigNetherHandler.goldMinY, ConfigNetherHandler.goldMaxY, ConfigNetherHandler.goldMinVeinSize, ConfigNetherHandler.goldMaxVeinSize, ConfigNetherHandler.goldVeinChance);
        generateOre(ConfigNetherHandler.diamond, ModOres.oreNetherDiamond, world, random, chunkX, chunkZ, ConfigNetherHandler.diamondMinY, ConfigNetherHandler.diamondMaxY, ConfigNetherHandler.diamondMinVeinSize, ConfigNetherHandler.diamondMaxVeinSize, ConfigNetherHandler.diamondVeinChance);
        generateOre(ConfigNetherHandler.emerald, ModOres.oreNetherEmerald, world, random, chunkX, chunkZ, ConfigNetherHandler.emeraldMinY, ConfigNetherHandler.emeraldMaxY, ConfigNetherHandler.emeraldMinVeinSize, ConfigNetherHandler.emeraldMaxVeinSize, ConfigNetherHandler.emeraldVeinChance);
        generateOre(ConfigNetherHandler.coal, ModOres.oreNetherCoal, world, random, chunkX, chunkZ, ConfigNetherHandler.coalMinY, ConfigNetherHandler.coalMaxY, ConfigNetherHandler.coalMinVeinSize, ConfigNetherHandler.coalMaxVeinSize, ConfigNetherHandler.coalVeinChance);
        generateOre(ConfigNetherHandler.lapis, ModOres.oreNetherLapis, world, random, chunkX, chunkZ, ConfigNetherHandler.lapisMinY, ConfigNetherHandler.lapisMaxY, ConfigNetherHandler.lapisMinVeinSize, ConfigNetherHandler.lapisMaxVeinSize, ConfigNetherHandler.lapisVeinChance);
        generateOre(ConfigNetherHandler.redstone, ModOres.oreNetherRedstone, world, random, chunkX, chunkZ, ConfigNetherHandler.redstoneMinY, ConfigNetherHandler.redstoneMaxY, ConfigNetherHandler.redstoneMinVeinSize, ConfigNetherHandler.redstoneMaxVeinSize, ConfigNetherHandler.redstoneVeinChance);

        generateOre(ConfigNetherHandler.copper, ModOres.oreNetherCopper, world, random, chunkX, chunkZ, ConfigNetherHandler.copperMinY, ConfigNetherHandler.copperMaxY, ConfigNetherHandler.copperMinVeinSize, ConfigNetherHandler.copperMaxVeinSize, ConfigNetherHandler.copperVeinChance);
        generateOre(ConfigNetherHandler.tin, ModOres.oreNetherTin, world, random, chunkX, chunkZ, ConfigNetherHandler.tinMinY, ConfigNetherHandler.tinMaxY, ConfigNetherHandler.tinMinVeinSize, ConfigNetherHandler.tinMaxVeinSize, ConfigNetherHandler.tinVeinChance);
        generateOre(ConfigNetherHandler.silver, ModOres.oreNetherSilver, world, random, chunkX, chunkZ, ConfigNetherHandler.silverMinY, ConfigNetherHandler.silverMaxY, ConfigNetherHandler.silverMinVeinSize, ConfigNetherHandler.silverMaxVeinSize, ConfigNetherHandler.silverVeinChance);
        generateOre(ConfigNetherHandler.lead, ModOres.oreNetherLead, world, random, chunkX, chunkZ, ConfigNetherHandler.leadMinY, ConfigNetherHandler.leadMaxY, ConfigNetherHandler.leadMinVeinSize, ConfigNetherHandler.leadMaxVeinSize, ConfigNetherHandler.leadVeinChance);
        generateOre(ConfigNetherHandler.aluminum, ModOres.oreNetherAluminum, world, random, chunkX, chunkZ, ConfigNetherHandler.aluminumMinY, ConfigNetherHandler.aluminumMaxY, ConfigNetherHandler.aluminumMinVeinSize, ConfigNetherHandler.aluminumMaxVeinSize, ConfigNetherHandler.aluminumVeinChance);
        generateOre(ConfigNetherHandler.nickel, ModOres.oreNetherNickel, world, random, chunkX, chunkZ, ConfigNetherHandler.nickelMinY, ConfigNetherHandler.nickelMaxY, ConfigNetherHandler.nickelMinVeinSize, ConfigNetherHandler.nickelMaxVeinSize, ConfigNetherHandler.nickelVeinChance);
        generateOre(ConfigNetherHandler.platinum, ModOres.oreNetherPlatinum, world, random, chunkX, chunkZ, ConfigNetherHandler.platinumMinY, ConfigNetherHandler.platinumMaxY, ConfigNetherHandler.platinumMinVeinSize, ConfigNetherHandler.platinumMaxVeinSize, ConfigNetherHandler.platinumVeinChance);
        generateOre(ConfigNetherHandler.steel, ModOres.oreNetherSteel, world, random, chunkX, chunkZ, ConfigNetherHandler.steelMinY, ConfigNetherHandler.steelMaxY, ConfigNetherHandler.steelMinVeinSize, ConfigNetherHandler.steelMaxVeinSize, ConfigNetherHandler.steelVeinChance);
        generateOre(ConfigNetherHandler.electrum, ModOres.oreNetherElectrum, world, random, chunkX, chunkZ, ConfigNetherHandler.electrumMinY, ConfigNetherHandler.electrumMaxY, ConfigNetherHandler.electrumMinVeinSize, ConfigNetherHandler.electrumMaxVeinSize, ConfigNetherHandler.electrumVeinChance);
        generateOre(ConfigNetherHandler.bronze, ModOres.oreNetherBronze, world, random, chunkX, chunkZ, ConfigNetherHandler.bronzeMinY, ConfigNetherHandler.bronzeMaxY, ConfigNetherHandler.bronzeMinVeinSize, ConfigNetherHandler.bronzeMaxVeinSize, ConfigNetherHandler.bronzeVeinChance);
    }

    private void generateOre(boolean condition, Block ore, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int minVeinSize, int maxVeinSize, int chancesToSpawn) {
        int heightRange = maxY - minY;
        BlockPos blockpos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(heightRange), (chunkZ * 16) + random.nextInt(16));

        if (condition && ConfigNetherHandler.oreGen && world.provider.getDimension() == -1) {
            for (int i = 0; i < chancesToSpawn; i++) {
                WorldGenerator nether = new WorldGenIngotterMinable(ore, minVeinSize, maxVeinSize, Blocks.NETHERRACK);
                nether.generate(world, random, blockpos);
            }
        }
    }
}

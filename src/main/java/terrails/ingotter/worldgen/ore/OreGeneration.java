package terrails.ingotter.worldgen.ore;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.commons.lang3.StringUtils;
import terrails.ingotter.config.ConfigOreHandler;

import java.util.Random;

public class OreGeneration implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

    }

    @SuppressWarnings("deprecation")
    public void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreArray){
            if(ConfigOreHandler.oreBoolean && !ore.isEmpty()){
            String oreName = ore.toLowerCase();
       //     private boolean = (!oreName.contains(""));

            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);

       //     if(blockOre != null)
        }
    }}
}

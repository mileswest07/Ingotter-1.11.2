package terrails.ingotter.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.BlockBase;

public class ModBlocks {

    public static BlockBase blockCopper;
    public static BlockBase blockTin;
    public static BlockBase blockSilver;
    public static BlockBase blockLead;
    public static BlockBase blockAluminum;
    public static BlockBase blockNickel;
    public static BlockBase blockPlatinum;
    public static BlockBase blockSteel;
    public static BlockBase blockElectrum;
    public static BlockBase blockBronze;

    public static void init() {
        Constants.LOGGER.info("Loading Blocks...");
        blockCopper = register(new BlockBase("copper_block")).setHarvestLevel(1);
        blockTin = register(new BlockBase("tin_block")).setHarvestLevel(1);
        blockSilver = register(new BlockBase("silver_block"));
        blockLead = register(new BlockBase("lead_block"));
        blockAluminum = register(new BlockBase("aluminum_block")).setHarvestLevel(1);
        blockNickel = register(new BlockBase("nickel_block"));
        blockPlatinum = register(new BlockBase("platinum_block")).setHarvestLevel(3);
        blockSteel = register(new BlockBase("steel_block"));
        blockElectrum = register(new BlockBase("electrum_block"));
        blockBronze = register(new BlockBase("bronze_block"));
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof BlockBase) {
            ((BlockBase)block).registerItemModel(itemBlock);
        }
        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}

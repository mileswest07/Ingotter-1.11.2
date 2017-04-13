package terrails.ingotter.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.BlockOreBase;
import terrails.ingotter.base.BlockOreCustomDrop;

public class ModOres {

    public static BlockOreBase oreCopper;
    public static BlockOreBase oreTin;
    public static BlockOreBase oreSilver;
    public static BlockOreBase oreLead;
    public static BlockOreBase oreAluminum;
    public static BlockOreBase oreNickel;
    public static BlockOreBase orePlatinum;
    public static BlockOreBase oreSteel;
    public static BlockOreBase oreElectrum;
    public static BlockOreBase oreBronze;

    public static BlockOreBase oreNetherCopper;
    public static BlockOreBase oreNetherTin;
    public static BlockOreBase oreNetherSilver;
    public static BlockOreBase oreNetherLead;
    public static BlockOreBase oreNetherAluminum;
    public static BlockOreBase oreNetherNickel;
    public static BlockOreBase oreNetherPlatinum;
    public static BlockOreBase oreNetherSteel;
    public static BlockOreBase oreNetherElectrum;
    public static BlockOreBase oreNetherBronze;
    public static BlockOreBase oreNetherIron;
    public static BlockOreBase oreNetherGold;
    public static BlockOreCustomDrop oreNetherDiamond;
    public static BlockOreCustomDrop oreNetherLapis;
    public static BlockOreCustomDrop oreNetherRedstone;
    public static BlockOreCustomDrop oreNetherEmerald;
    public static BlockOreCustomDrop oreNetherCoal;

    public static BlockOreBase oreEndCopper;
    public static BlockOreBase oreEndTin;
    public static BlockOreBase oreEndSilver;
    public static BlockOreBase oreEndLead;
    public static BlockOreBase oreEndAluminum;
    public static BlockOreBase oreEndNickel;
    public static BlockOreBase oreEndPlatinum;
    public static BlockOreBase oreEndSteel;
    public static BlockOreBase oreEndElectrum;
    public static BlockOreBase oreEndBronze;
    public static BlockOreBase oreEndIron;
    public static BlockOreBase oreEndGold;
    public static BlockOreCustomDrop oreEndDiamond;
    public static BlockOreCustomDrop oreEndLapis;
    public static BlockOreCustomDrop oreEndRedstone;
    public static BlockOreCustomDrop oreEndEmerald;
    public static BlockOreCustomDrop oreEndCoal;


    public static void init() {
        Constants.LOGGER.info("Loading Ores...");
        oreCopper = register(new BlockOreBase("copper_ore").setHarvestLevel(1));
        oreTin = register(new BlockOreBase("tin_ore")).setHarvestLevel(1);
        oreSilver = register(new BlockOreBase("silver_ore")).setLightLevel(0.5f);
        oreLead = register(new BlockOreBase("lead_ore"));
        oreAluminum = register(new BlockOreBase("aluminum_ore")).setHarvestLevel(1);
        oreNickel = register(new BlockOreBase("nickel_ore"));
        orePlatinum = register(new BlockOreBase("platinum_ore")).setHarvestLevel(3);
        oreSteel = register(new BlockOreBase("steel_ore")).setHarvestLevel(3);
        oreElectrum = register(new BlockOreBase("electrum_ore")).setHarvestLevel(3);
        oreBronze = register(new BlockOreBase("bronze_ore")).setHarvestLevel(3);

        oreNetherCopper = register(new BlockOreBase("copper_ore_nether").setHarvestLevel(1));
        oreNetherTin = register(new BlockOreBase("tin_ore_nether")).setHarvestLevel(1);
        oreNetherSilver = register(new BlockOreBase("silver_ore_nether")).setLightLevel(0.5f);
        oreNetherLead = register(new BlockOreBase("lead_ore_nether"));
        oreNetherAluminum = register(new BlockOreBase("aluminum_ore_nether")).setHarvestLevel(1);
        oreNetherNickel = register(new BlockOreBase("nickel_ore_nether"));
        oreNetherPlatinum = register(new BlockOreBase("platinum_ore_nether")).setHarvestLevel(3);
        oreNetherSteel = register(new BlockOreBase("steel_ore_nether")).setHarvestLevel(3);
        oreNetherElectrum = register(new BlockOreBase("electrum_ore_nether")).setHarvestLevel(3);
        oreNetherBronze = register(new BlockOreBase("bronze_ore_nether")).setHarvestLevel(2);

        oreEndCopper = register(new BlockOreBase("copper_ore_end").setHarvestLevel(1));
        oreEndTin = register(new BlockOreBase("tin_ore_end")).setHarvestLevel(1);
        oreEndSilver = register(new BlockOreBase("silver_ore_end")).setLightLevel(0.5f);
        oreEndLead = register(new BlockOreBase("lead_ore_end"));
        oreEndAluminum = register(new BlockOreBase("aluminum_ore_end")).setHarvestLevel(1);
        oreEndNickel = register(new BlockOreBase("nickel_ore_end"));
        oreEndPlatinum = register(new BlockOreBase("platinum_ore_end")).setHarvestLevel(3);
        oreEndSteel = register(new BlockOreBase("steel_ore_end")).setHarvestLevel(3);
        oreEndElectrum = register(new BlockOreBase("electrum_ore_end")).setHarvestLevel(3);
        oreEndBronze = register(new BlockOreBase("bronze_ore_end")).setHarvestLevel(2);

        oreEndIron = register(new BlockOreBase("iron_ore_end")).setHarvestLevel(2);
        oreEndGold = register(new BlockOreBase("gold_ore_end")).setHarvestLevel(3);
        oreEndLapis = register(new BlockOreCustomDrop("lapis_ore_end", Items.DYE, 4, 4, 16).setHarvestLevel(3));
        oreEndDiamond = register(new BlockOreCustomDrop("diamond_ore_end", Items.DIAMOND, 0, 2, 4)).setHarvestLevel(3);
        oreEndRedstone = register(new BlockOreCustomDrop("redstone_ore_end", Items.REDSTONE, 0, 5, 9).setHarvestLevel(3));
        oreEndEmerald = register(new BlockOreCustomDrop("emerald_ore_end", Items.EMERALD, 0, 1, 4)).setHarvestLevel(3);
        oreEndCoal = register(new BlockOreCustomDrop("coal_ore_end", Items.COAL, 0, 1, 3)).setHarvestLevel(1);

        oreNetherIron = register(new BlockOreBase("iron_ore_nether")).setHarvestLevel(1);
        oreNetherGold = register(new BlockOreBase("gold_ore_nether"));
        oreNetherLapis = register(new BlockOreCustomDrop("lapis_ore_nether", Items.DYE, 4, 2, 8)).setHarvestLevel(3);
        oreNetherDiamond = register(new BlockOreCustomDrop("diamond_ore_nether", Items.DIAMOND, 0, 1, 3)).setHarvestLevel(3);
        oreNetherRedstone = register(new BlockOreCustomDrop("redstone_ore_nether", Items.REDSTONE, 0, 3, 8)).setHarvestLevel(3);
        oreNetherEmerald = register(new BlockOreCustomDrop("emerald_ore_nether", Items.EMERALD, 0, 1, 3)).setHarvestLevel(3);
        oreNetherCoal = register(new BlockOreCustomDrop("coal_ore_nether", Items.COAL, 0, 1, 2)).setHarvestLevel(1);
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof BlockOreBase) {
            ((BlockOreBase)block).registerItemModel(itemBlock);
        }
        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}

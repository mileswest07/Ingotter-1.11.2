package terrails.ingotter.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.init.items.ModDusts;
import terrails.ingotter.init.items.ModIngots;

public class ModSmeltingRecipes {

    public static void init() {

        if(ConfigHandler.oreToIngotSmelting) {
            if (ConfigOreHandler.oreBoolean) {
                addSmelting(ModOres.oreCopper, new ItemStack(ModIngots.ingotCopper), 0.4f);
                addSmelting(ModOres.oreTin, new ItemStack(ModIngots.ingotTin), 0.4f);
                addSmelting(ModOres.oreSilver, new ItemStack(ModIngots.ingotSilver), 0.4f);
                addSmelting(ModOres.oreLead, new ItemStack(ModIngots.ingotLead), 0.4f);
                addSmelting(ModOres.oreAluminum, new ItemStack(ModIngots.ingotAluminum), 0.4f);
                addSmelting(ModOres.oreNickel, new ItemStack(ModIngots.ingotNickel), 0.4f);
                addSmelting(ModOres.orePlatinum, new ItemStack(ModIngots.ingotPlatinum), 0.4f);
                addSmelting(ModOres.oreSteel, new ItemStack(ModIngots.ingotSteel), 0.4f);
                addSmelting(ModOres.oreElectrum, new ItemStack(ModIngots.ingotElectrum), 0.5f);
                addSmelting(ModOres.oreBronze, new ItemStack(ModIngots.ingotBronze), 0.8f);
            }

            if (ConfigOreHandler.oreBoolean) {
                addSmelting(ModOres.oreNetherCopper, new ItemStack(ModIngots.ingotCopper), 0.5f);
                addSmelting(ModOres.oreNetherTin, new ItemStack(ModIngots.ingotTin), 0.5f);
                addSmelting(ModOres.oreNetherSilver, new ItemStack(ModIngots.ingotSilver), 0.5f);
                addSmelting(ModOres.oreNetherLead, new ItemStack(ModIngots.ingotLead), 0.5f);
                addSmelting(ModOres.oreNetherAluminum, new ItemStack(ModIngots.ingotAluminum), 0.5f);
                addSmelting(ModOres.oreNetherNickel, new ItemStack(ModIngots.ingotNickel), 0.5f);
                addSmelting(ModOres.oreNetherPlatinum, new ItemStack(ModIngots.ingotPlatinum), 0.5f);
                addSmelting(ModOres.oreNetherIron, new ItemStack(Items.IRON_INGOT), 0.5f);
                addSmelting(ModOres.oreNetherGold, new ItemStack(Items.GOLD_INGOT), 0.5f);
                addSmelting(ModOres.oreNetherSteel, new ItemStack(ModIngots.ingotSteel), 0.4f);
                addSmelting(ModOres.oreNetherElectrum, new ItemStack(ModIngots.ingotElectrum), 0.5f);
                addSmelting(ModOres.oreNetherBronze, new ItemStack(ModIngots.ingotBronze), 0.8f);
            }

            if (ConfigOreHandler.oreBoolean) {
                addSmelting(ModOres.oreEndCopper, new ItemStack(ModIngots.ingotCopper), 0.8f);
                addSmelting(ModOres.oreEndTin, new ItemStack(ModIngots.ingotTin), 0.8f);
                addSmelting(ModOres.oreEndSilver, new ItemStack(ModIngots.ingotSilver), 0.8f);
                addSmelting(ModOres.oreEndLead, new ItemStack(ModIngots.ingotLead), 0.8f);
                addSmelting(ModOres.oreEndAluminum, new ItemStack(ModIngots.ingotAluminum), 0.8f);
                addSmelting(ModOres.oreEndNickel, new ItemStack(ModIngots.ingotNickel), 0.8f);
                addSmelting(ModOres.oreEndPlatinum, new ItemStack(ModIngots.ingotPlatinum), 0.8f);
                addSmelting(ModOres.oreEndIron, new ItemStack(Items.IRON_INGOT), 0.5f);
                addSmelting(ModOres.oreEndGold, new ItemStack(Items.GOLD_INGOT), 0.5f);
                addSmelting(ModOres.oreEndSteel, new ItemStack(ModIngots.ingotSteel), 0.4f);
                addSmelting(ModOres.oreEndElectrum, new ItemStack(ModIngots.ingotElectrum), 0.5f);
                addSmelting(ModOres.oreEndBronze, new ItemStack(ModIngots.ingotBronze), 0.8f);
            }
        }


        if(ConfigHandler.dusts && ConfigHandler.dustToIngotSmelting) {
            addSmelting(ModDusts.ironDust, new ItemStack(Items.IRON_INGOT), 0.5f);
            addSmelting(ModDusts.goldDust, new ItemStack(Items.GOLD_INGOT), 0.5f);
            addSmelting(ModDusts.copperDust, new ItemStack(ModIngots.ingotCopper), 0.5f);
            addSmelting(ModDusts.tinDust, new ItemStack(ModIngots.ingotTin), 0.5f);
            addSmelting(ModDusts.silverDust, new ItemStack(ModIngots.ingotSilver), 0.5f);
            addSmelting(ModDusts.leadDust, new ItemStack(ModIngots.ingotLead), 0.5f);
            addSmelting(ModDusts.aluminumDust, new ItemStack(ModIngots.ingotAluminum), 0.5f);
            addSmelting(ModDusts.nickelDust, new ItemStack(ModIngots.ingotNickel), 0.5f);
            addSmelting(ModDusts.platinumDust, new ItemStack(ModIngots.ingotPlatinum), 0.5f);
            addSmelting(ModDusts.steelDust, new ItemStack(ModIngots.ingotSteel), 0.5f);
            addSmelting(ModDusts.electrumDust, new ItemStack(ModIngots.ingotElectrum), 0.5f);
            addSmelting(ModDusts.bronzeDust, new ItemStack(ModIngots.ingotBronze), 0.5f);
            addSmelting(ModDusts.diamondDust, new ItemStack(Items.DIAMOND), 0.5f);
            addSmelting(ModDusts.emeraldDust, new ItemStack(Items.EMERALD), 0.5f);
            addSmelting(ModDusts.lapisDust, new ItemStack(Items.DYE, 1, 4), 0.5f);
        }

    }

    public static void addSmelting(Block input, ItemStack output, float xp) {
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(input, output, xp);
    }
    public static void addSmelting(Item input, ItemStack output, float xp) {
        FurnaceRecipes.instance().addSmelting(input, output, xp);
    }
    public static void addSmelting(ItemStack input, ItemStack output, float xp) {
        FurnaceRecipes.instance().addSmeltingRecipe(input, output, xp);
    }
    public static void addSmelting(boolean condition, Item input, ItemStack output, float xp){
        if(condition) {
            GameRegistry.addSmelting(input, output, xp);
        }
    }
    public static void addSmelting(boolean condition, Block input, ItemStack output, float xp){
        if(condition) {
            GameRegistry.addSmelting(input, output, xp);
        }
    }
    public static void addSmelting(boolean condition, ItemStack input, ItemStack output, float xp){
        if(condition) {
            GameRegistry.addSmelting(input, output, xp);
        }
    }
}

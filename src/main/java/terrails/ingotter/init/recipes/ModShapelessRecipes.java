package terrails.ingotter.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.init.items.*;

import java.util.List;

public class ModShapelessRecipes {

    public static void init() {
        List<IRecipe> crafting = CraftingManager.getInstance().getRecipeList();
        ItemStack hammerTool = new ItemStack(ModItems.hammerTool, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack wireCutterTool = new ItemStack(ModItems.wireCutter, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack lapis = new ItemStack(Items.DYE, 1, 4);
        ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);

        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotCopper, 9), "blockCopper"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotTin, 9), "blockTin"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotSilver, 9), "blockSilver"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotLead, 9), "blockLead"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotAluminum, 9), "blockAluminum"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotNickel, 9), "blockNickel"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotPlatinum, 9), "blockPlatinum"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotSteel, 9), "blockSteel"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotElectrum, 9), "blockElectrum"));
        crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotBronze, 9), "blockBronze"));

        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetCopper, 9), "ingotCopper"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetTin, 9), "ingotTin"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetSilver, 9), "ingotSilver"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetLead, 9), "ingotLead"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetAluminum, 9), "ingotAluminum"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetNickel, 9), "ingotNickel"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetPlatinum, 9), "ingotPlatinum"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetSteel, 9), "ingotSteel"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetElectrum, 9), "ingotElectrum"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetBronze, 9), "ingotBronze"));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetCoal, 8), Items.COAL));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetCoal, 8), charcoal));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetDiamond, 9), Items.DIAMOND));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetEmerald, 9), Items.EMERALD));
        crafting.add(ShapelessOre(new ItemStack(ModNuggets.nuggetLapis, 9), lapis));

        if(ConfigHandler.metalPlates && ConfigHandler.plateRecipe && ConfigHandler.hammerwire) {
            crafting.add(ShapelessOre(ModPlates.plateIron, hammerTool, "ingotIron", "ingotIron"));
            crafting.add(ShapelessOre(ModPlates.plateGold, hammerTool, "ingotGold", "ingotGold"));
            crafting.add(ShapelessOre(ModPlates.plateCopper, hammerTool, "ingotCopper", "ingotCopper"));
            crafting.add(ShapelessOre(ModPlates.plateTin, hammerTool, "ingotTin", "ingotTin"));
            crafting.add(ShapelessOre(ModPlates.plateSilver, hammerTool, "ingotSilver", "ingotSilver"));
            crafting.add(ShapelessOre(ModPlates.plateLead, hammerTool, "ingotLead", "ingotLead"));
            crafting.add(ShapelessOre(ModPlates.plateAluminum, hammerTool, "ingotAluminum", "ingotAluminum"));
            crafting.add(ShapelessOre(ModPlates.plateNickel, hammerTool, "ingotNickel", "ingotNickel"));
            crafting.add(ShapelessOre(ModPlates.platePlatinum, hammerTool, "ingotPlatinum", "ingotPlatinum"));
            crafting.add(ShapelessOre(ModPlates.plateSteel, hammerTool, "ingotSteel", "ingotSteel"));
            crafting.add(ShapelessOre(ModPlates.plateElectrum, hammerTool, "ingotElectrum", "ingotElectrum"));
            crafting.add(ShapelessOre(ModPlates.plateBronze, hammerTool, "ingotBronze", "ingotBronze"));
            crafting.add(ShapelessOre(ModPlates.plateCoal, hammerTool, Items.COAL, Items.COAL));
            crafting.add(ShapelessOre(ModPlates.plateDiamond, hammerTool, Items.DIAMOND, Items.DIAMOND));
            crafting.add(ShapelessOre(ModPlates.plateEmerald, hammerTool, Items.EMERALD, Items.EMERALD));
            crafting.add(ShapelessOre(ModPlates.plateRedstone, hammerTool, Items.REDSTONE, Items.REDSTONE));
            crafting.add(ShapelessOre(ModPlates.plateLapis, hammerTool, lapis, lapis));
        }

        if(ConfigHandler.metalWires && ConfigHandler.wireRecipe && ConfigHandler.hammerwire) {
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireIron, 3), wireCutterTool, "plateIron"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireGold, 3), wireCutterTool, "plateGold"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireCopper, 3), wireCutterTool, "plateCopper"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireTin, 3), wireCutterTool, "plateTin"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireSilver, 3), wireCutterTool, "plateSilver"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireLead, 3), wireCutterTool, "plateLead"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireAluminum, 3), wireCutterTool, "plateAluminum"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireNickel, 3), wireCutterTool, "plateNickel"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wirePlatinum, 3), wireCutterTool, "platePlatinum"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireSteel, 3), wireCutterTool, "plateSteel"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireElectrum, 3), wireCutterTool, "plateElectrum"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireBronze, 3), wireCutterTool, "plateBronze"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireCoal, 3), wireCutterTool, "plateCoal"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireDiamond, 3), wireCutterTool, "plateDiamond"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireEmerald, 3), wireCutterTool, "plateEmerald"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireRedstone, 3), wireCutterTool, "plateRedstone"));
            crafting.add(ShapelessOre(new ItemStack(ModWires.wireLapis, 3), wireCutterTool, "plateLapis"));
        }

        if(ConfigHandler.oreToDustRecipe){
        crafting.add(ShapelessOre(new ItemStack(ModDusts.ironDust, 2), hammerTool, "oreIron"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.goldDust, 2), hammerTool, "oreGold"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.copperDust, 2), hammerTool, "oreCopper"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.tinDust, 2), hammerTool, "oreTin"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.silverDust, 2), hammerTool, "oreSilver"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.leadDust, 2), hammerTool, "oreLead"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.aluminumDust, 2), hammerTool, "oreAluminum"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.nickelDust, 2), hammerTool, "oreNickel"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.platinumDust, 2), hammerTool, "orePlatinum"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.steelDust, 2), hammerTool, "oreSteel"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.electrumDust, 2), hammerTool, "oreElectrum"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.bronzeDust, 2), hammerTool, "oreBronze"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.coalDust, 2), hammerTool, "oreCoal"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.diamondDust, 2), hammerTool, "oreDiamond"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.emeraldDust, 2), hammerTool, "oreEmerald"));
        crafting.add(ShapelessOre(new ItemStack(Items.REDSTONE,  3), hammerTool, "oreRedstone"));
        crafting.add(ShapelessOre(new ItemStack(ModDusts.lapisDust, 2), hammerTool, "oreLapis"));}

        if(ConfigHandler.ingotToDustRecipe){
        crafting.add(ShapelessOre(ModDusts.ironDust, hammerTool, "ingotIron"));
        crafting.add(ShapelessOre(ModDusts.goldDust, hammerTool, "ingotGold"));
        crafting.add(ShapelessOre(ModDusts.copperDust, hammerTool, "ingotCopper"));
        crafting.add(ShapelessOre(ModDusts.tinDust, hammerTool, "ingotTin"));
        crafting.add(ShapelessOre(ModDusts.silverDust, hammerTool, "ingotSilver"));
        crafting.add(ShapelessOre(ModDusts.leadDust, hammerTool, "ingotLead"));
        crafting.add(ShapelessOre(ModDusts.aluminumDust, hammerTool, "ingotAluminum"));
        crafting.add(ShapelessOre(ModDusts.nickelDust, hammerTool, "ingotNickel"));
        crafting.add(ShapelessOre(ModDusts.platinumDust, hammerTool, "ingotPlatinum"));
        crafting.add(ShapelessOre(ModDusts.steelDust, hammerTool, "ingotSteel"));
        crafting.add(ShapelessOre(ModDusts.electrumDust, hammerTool, "ingotElectrum"));
        crafting.add(ShapelessOre(ModDusts.bronzeDust, hammerTool, "ingotBronze"));
        crafting.add(ShapelessOre(ModDusts.coalDust, hammerTool, Items.COAL));
        crafting.add(ShapelessOre(ModDusts.diamondDust, hammerTool, Items.DIAMOND));
        crafting.add(ShapelessOre(ModDusts.emeraldDust, hammerTool, Items.EMERALD));
        crafting.add(ShapelessOre(ModDusts.lapisDust, hammerTool, lapis));}
    }

    private static ShapelessOreRecipe ShapelessOre(Item output, Object... input){
        return new ShapelessOreRecipe(new ItemStack(output), input);
    }
    private static ShapelessOreRecipe ShapelessOre(Block output, Object... input){
        return new ShapelessOreRecipe(new ItemStack(output), input);
    }
    private static ShapelessOreRecipe ShapelessOre(ItemStack output, Object... input){
        return new ShapelessOreRecipe(output, input);
    }
}

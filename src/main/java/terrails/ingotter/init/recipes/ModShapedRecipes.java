package terrails.ingotter.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import terrails.ingotter.init.blocks.ModBlocks;
import terrails.ingotter.init.items.ModIngots;

import java.util.List;

public class ModShapedRecipes {

    public static void init() {
        List<IRecipe> crafting = CraftingManager.getInstance().getRecipeList();
        ItemStack lapis = new ItemStack(Items.DYE, 1 , 4);

        crafting.add(ShapedOre(ModIngots.ingotCopper, "CCC", "CCC", "CCC", 'C', "nuggetCopper"));
        crafting.add(ShapedOre(ModIngots.ingotTin, "CCC", "CCC", "CCC", 'C', "nuggetTin"));
        crafting.add(ShapedOre(ModIngots.ingotSilver, "CCC", "CCC", "CCC", 'C', "nuggetSilver"));
        crafting.add(ShapedOre(ModIngots.ingotLead, "CCC", "CCC", "CCC", 'C', "nuggetLead"));
        crafting.add(ShapedOre(ModIngots.ingotAluminum, "CCC", "CCC", "CCC", 'C', "nuggetAluminum"));
        crafting.add(ShapedOre(ModIngots.ingotNickel, "CCC", "CCC", "CCC", 'C', "nuggetNickel"));
        crafting.add(ShapedOre(ModIngots.ingotPlatinum, "CCC", "CCC", "CCC", 'C', "nuggetPlatinum"));
        crafting.add(ShapedOre(ModIngots.ingotSteel, "CCC", "CCC", "CCC", 'C', "nuggetSteel"));
        crafting.add(ShapedOre(ModIngots.ingotElectrum, "CCC", "CCC", "CCC", 'C', "nuggetElectrum"));
        crafting.add(ShapedOre(ModIngots.ingotBronze, "CCC", "CCC", "CCC", 'C', "nuggetBronze"));
        crafting.add(ShapedOre(Items.COAL, "CCC", "C C", "CCC", 'C', "nuggetCoal"));
        crafting.add(ShapedOre(Items.DIAMOND, "DDD", "DDD", "DDD", 'D', "nuggetDiamond"));
        crafting.add(ShapedOre(Items.EMERALD, "EEE", "EEE", "EEE", 'E', "nuggetEmerald"));
        crafting.add(ShapedOre(lapis, "LLL", "LLL", "LLL", 'L', "nuggetLapis"));

        crafting.add(ShapedOre(ModBlocks.blockCopper, "CCC", "CCC", "CCC", 'C', "ingotCopper"));
        crafting.add(ShapedOre(ModBlocks.blockTin, "CCC", "CCC", "CCC", 'C', "ingotTin"));
        crafting.add(ShapedOre(ModBlocks.blockSilver, "CCC", "CCC", "CCC", 'C', "ingotSilver"));
        crafting.add(ShapedOre(ModBlocks.blockLead, "CCC", "CCC", "CCC", 'C', "ingotLead"));
        crafting.add(ShapedOre(ModBlocks.blockAluminum, "CCC", "CCC", "CCC", 'C', "ingotAluminum"));
        crafting.add(ShapedOre(ModBlocks.blockNickel, "CCC", "CCC", "CCC", 'C', "ingotNickel"));
        crafting.add(ShapedOre(ModBlocks.blockPlatinum, "CCC", "CCC", "CCC", 'C', "ingotPlatinum"));
        crafting.add(ShapedOre(ModBlocks.blockSteel, "CCC", "CCC", "CCC", 'C', "ingotSteel"));
        crafting.add(ShapedOre(ModBlocks.blockElectrum, "CCC", "CCC", "CCC", 'C', "ingotElectrum"));
        crafting.add(ShapedOre(ModBlocks.blockBronze, "CCC", "CCC", "CCC", 'C', "ingotBronze"));
    }

    public static ShapedOreRecipe ShapedOre(Item output, Object... recipe){
        return new ShapedOreRecipe(new ItemStack(output), recipe);
    }
    public static ShapedOreRecipe ShapedOre(Block output, Object... recipe){
        return new ShapedOreRecipe(new ItemStack(output), recipe);
    }
    public static ShapedOreRecipe ShapedOre(ItemStack output, Object... recipe){
        return new ShapedOreRecipe(output, recipe);
    }
}

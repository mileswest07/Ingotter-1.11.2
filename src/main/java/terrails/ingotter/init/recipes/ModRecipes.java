package terrails.ingotter.init.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.init.items.ModDusts;
import terrails.ingotter.init.items.ModIngots;
import terrails.ingotter.init.items.ModItems;

import java.util.List;

public class ModRecipes {

    public static void init() {
        List<IRecipe> crafting = CraftingManager.getInstance().getRecipeList();
        ItemStack planksAll = new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE);

        if (ConfigHandler.bronzeElectrumSteel) {
            crafting.add(ShapelessOre(new ItemStack(ModIngots.ingotBronze, 4), "ingotCopper", "ingotCopper", "ingotCopper", "ingotTin"));
            crafting.add(ShapelessOre(ModDusts.steelDust, "ingotIron", Items.COAL));
        }
        if (ConfigHandler.dusts && ConfigHandler.bronzeElectrumSteel){
            crafting.add(ShapelessOre(new ItemStack(ModDusts.electrumDust, 2), "dustSilver", "dustGold"));
        }
        if (ConfigHandler.hammerwire) {
            crafting.add(ShapedOre(ModItems.hammerTool, "  I", " S ", "S  ", 'I', "ingotIron", 'S', Items.STICK));
        //    crafting.add(ShapedOre(ModItems.wireCutter, "I I", " S ", "P P", 'I', "ingotIron", 'S', Items.STICK, 'P', planksAll));
        }
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

    public static ShapelessOreRecipe ShapelessOre(Item input, Object... output){
        return new ShapelessOreRecipe(new ItemStack(input), output);
    }
    public static ShapelessOreRecipe ShapelessOre(Block input, Object... output){
        return new ShapelessOreRecipe(new ItemStack(input), output);
    }
    public static ShapelessOreRecipe ShapelessOre(ItemStack input, Object... output){
        return new ShapelessOreRecipe(input, output);
    }

    public static ShapedOreRecipe ShapedOre(Item input, Object... output){
        return new ShapedOreRecipe(new ItemStack(input), output);
    }
    public static ShapedOreRecipe ShapedOre(Block input, Object... output){
        return new ShapedOreRecipe(new ItemStack(input), output);
    }
    public static ShapedOreRecipe ShapedOre(ItemStack input, Object... output){
        return new ShapedOreRecipe(input, output);
    }
}

package terrails.ingotter.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import terrails.ingotter.Constants;

import java.io.File;

import static terrails.ingotter.config.ConfigOreHandler.configIngotter;
import static terrails.ingotter.config.ConfigOreHandler.configOreVariables;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigHandler {

    public static Configuration config;
    private static File configDir;

    public static final String GENERAL_SETTINGS = "General";
    public static final String FEATURES = "Features";

    // Recipes
    public static final String RECIPES = "Recipes";
    public static final String CRAFTING_RECIPES = "Crafting";
    public static final String FURNACE_RECIPES = "Furnace";

    // Crafting Recipes
    public static boolean ingotToDustRecipe;
    public static boolean oreToDustRecipe;
    public static boolean plateRecipe;
    public static boolean wireRecipe;
    public static boolean bronzeElectrumSteel;

    // Furnace Recipes
    public static boolean oreToIngotSmelting;
    public static boolean dustToIngotSmelting;
    
    // Items and Blocks
    public static boolean metalPlates;
    public static boolean metalWires;
    public static boolean dusts;
    public static boolean hammerwire;
    public static boolean armor;
    public static boolean tools;
    public static boolean customBlocks;

    public static void init(File directory) {
        directory = new File(directory, Constants.MODID);
        directory.mkdir();
        ConfigHandler.configDir = directory;

        config = new Configuration(new File(configDir, "Ingotter.cfg"));
        mainConfig();

        }

    @SubscribeEvent
    public void configChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(Constants.MODID)) {
            mainConfig();
            configOreVariables();
        }
    }

    public static void mainConfig()
    {
        //Crafting Recipe
        bronzeElectrumSteel = config.get(RECIPES + "." + CRAFTING_RECIPES, "Bronze, Electrum, Steel", true).getBoolean();
        ingotToDustRecipe = config.get(RECIPES + "." + CRAFTING_RECIPES, "Ingot To Dust", true).getBoolean();
        oreToDustRecipe = config.get(RECIPES + "." + CRAFTING_RECIPES, "Ore To Dust", true).getBoolean();
        plateRecipe = config.get(RECIPES + "." + CRAFTING_RECIPES, "Plates", true).getBoolean();
        wireRecipe = config.get(RECIPES + "." + CRAFTING_RECIPES, "Wires", true).getBoolean();

        //Furnace Recipe
        oreToIngotSmelting = config.get(RECIPES + "." + FURNACE_RECIPES, "Ore To Ingot", true).getBoolean();
        dustToIngotSmelting = config.get(RECIPES + "." + FURNACE_RECIPES, "Dust To Ingot", true).getBoolean();

        //Items and Blocks
        metalPlates = config.get(FEATURES, "Plates", true).getBoolean();
        metalWires = config.get(FEATURES, "Wires", true).getBoolean();
        dusts = config.get(FEATURES, "Dusts", true).getBoolean();
        hammerwire = config.get(FEATURES, "Hammer & Wire Cutters", true).getBoolean();
        customBlocks = config.get(FEATURES, "Custom Blocks", true).getBoolean();

        if (config.hasChanged()) {
        config.save();
        }
    }
}

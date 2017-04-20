package terrails.ingotter.config.ore;

import net.minecraftforge.common.config.Configuration;
import terrails.ingotter.Constants;
import terrails.ingotter.worldgen.ore.CustomOreGen;

import java.io.File;

public class ConfigCustomOreGen {

    public static Configuration configCustomWorld;
    private static File configCustomOreGenDir;

    public static String[] oreToReplace;
    public static String[] minY;
    public static String[] maxY;
    public static String[] minVein;
    public static String[] maxVein;
    public static String[] veinChance;

    public static final String WORLD = "Ore Generation";
    public static final String Y_LEVEL = ".Y Levels";
    public static final String VEINS = ".Veins";

    public static void init(File oreGenDir) {
        oreGenDir = new File(oreGenDir, Constants.MODID + "/" + "world");
        oreGenDir.mkdir();
        ConfigCustomOreGen.configCustomOreGenDir = oreGenDir;
        ConfigCustomOreGen.configCustomWorld = new Configuration(new File(oreGenDir, "Custom-Ore-Generation.cfg"));
        configCustomWorld.addCustomCategoryComment(WORLD, ORE_GENERATION);

        // Defined Ore
        String[] oreReplace = configCustomWorld.getStringList("ore_to_gen", WORLD, EMPTY_STRING, "ore which should have custom ore gen\n");
        StringBuilder strBuilderOre = new StringBuilder();
        for (int i = 0; i < oreReplace.length; i++) {strBuilderOre.append(oreReplace[i]);}
        oreToReplace = strBuilderOre.toString().split(",");

        // Min Y Level
        String[] oreMinY = configCustomWorld.getStringList("min_y_level", WORLD + Y_LEVEL, EMPTY_STRING, "ore min y level\n");
        StringBuilder strBuilderMinY = new StringBuilder();
        for (int i = 0; i < oreMinY.length; i++){strBuilderMinY.append(oreMinY[i]);}
        minY = strBuilderMinY.toString().split(",");

        // Max Y Level
        String[] oreMaxY = configCustomWorld.getStringList("max_y_level", WORLD + Y_LEVEL, EMPTY_STRING, "ore max y level\n");
        StringBuilder strBuilderMaxY = new StringBuilder();
        for (int i = 0; i < oreMaxY.length; i++){strBuilderMaxY.append(oreMaxY[i]);}
        maxY = strBuilderMaxY.toString().split(",");

        // Min Vein Size
        String[] oreMinVeinSize = configCustomWorld.getStringList("min_vein_size", WORLD + VEINS, EMPTY_STRING, "ore min vein size\n");
        StringBuilder strBuilderMinVein = new StringBuilder();
        for (int i = 0; i < oreMinVeinSize.length; i++){strBuilderMinVein.append(oreMinVeinSize[i]);}
        minVein = strBuilderMinVein.toString().split(",");

        // Max Vein Size
        String[] oreMaxVeinSize = configCustomWorld.getStringList("max_vein_size", WORLD + VEINS, EMPTY_STRING, "ore max vein size\n");
        StringBuilder strBuilderMaxVein = new StringBuilder();
        for (int i = 0; i < oreMaxVeinSize.length; i++){strBuilderMaxVein.append(oreMaxVeinSize[i]);}
        maxVein = strBuilderMaxVein.toString().split(",");

        // Veins Per Chunk
        String[] oreVeinChance = configCustomWorld.getStringList("veins_per_chunk", WORLD + VEINS, EMPTY_STRING, "ore veins per chunk\n");
        StringBuilder strBuilderVeinChance = new StringBuilder();
        for (int i = 0; i < oreVeinChance.length; i++){strBuilderVeinChance.append(oreVeinChance[i]);}
        veinChance = strBuilderVeinChance.toString().split(",");

        if (configCustomWorld.hasChanged()) {
            configCustomWorld.save();
        }
    }

    private static String ORE_GENERATION =
            "The Settings you have to type for each ore in each category:" +
                    "\n[Ore To Generate]: ModID:OreName, example: minecraft:iron_ore" +
                    "\n[Min Vein Size]: ModID:OreName=NUMBER, example: minecraft:iron_ore=12" +
                    "\n[Max Vein Size]: ModID:OreName=NUMBER, example: minecraft:iron_ore=6" +
                    "\n[Min Y Level]: ModID:OreName=NUMBER, example: minecraft:iron_ore=40" +
                    "\n[Max Y Level]: ModID:OreName=NUMBER, example: minecraft:iron_ore=80" +
                    "\n[Veins Per Chunk] ModID:OreName=NUMBER, example: minecraft:iron_ore=15";

    private final static String[] EMPTY_STRING = {};
}

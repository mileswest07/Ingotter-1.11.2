package terrails.ingotter.config;

import net.minecraftforge.common.config.Configuration;
import terrails.ingotter.Constants;
import java.io.File;

import static terrails.ingotter.config.ore.ConfigEndHandler.oreEndGenConfig;
import static terrails.ingotter.config.ore.ConfigNetherHandler.oreNetherGenConfig;
import static terrails.ingotter.config.ore.ConfigOverworldHandler.oreOverworldGenConfig;

public class ConfigOreHandler {

    public static Configuration configWorld;
    private static File configOreGenDir;

    //World
    public static final String WORLD = "World Generation";
    public static boolean oreGen;

    public static void init(File oreGenDir) {
        oreGenDir = new File(oreGenDir, Constants.MODID + "/" + "world");
        oreGenDir.mkdir();
        ConfigOreHandler.configOreGenDir = oreGenDir;

        ConfigOreHandler.configWorld = new Configuration(new File(oreGenDir, "Ore-Generation.cfg"));
        mainOreGenConfig();
        oreOverworldGenConfig();
        oreNetherGenConfig();
        oreEndGenConfig();
    }

    private static String ORE_GENERATION =
            "The Settings below will have ore generation. Range of options:" +
            "\nMax Vein Size [range: 1 ~ 64]" +
            "\nMin Vein Size [range: 1 ~ 64]" +
            "\nMax Y Level [range: 1 ~ 256]" +
            "\nMin Y Level [range: 1 ~ 256]" +
            "\nVeins Per Chunk [range: 1 ~ 48]";

    public static void mainOreGenConfig(){
        configWorld.addCustomCategoryComment(WORLD, ORE_GENERATION);
        oreGen = configWorld.get(WORLD, "Generate Ores", true).getBoolean();

        if (configWorld.hasChanged()) {
            configWorld.save();
        }
    }

}

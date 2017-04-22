package terrails.ingotter.config;

import net.minecraftforge.common.config.Configuration;
import terrails.ingotter.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;


public class ConfigOreHandler{

    public static Configuration configWorld;
    public static File configCustomOreGenDir;
    
    public static Configuration configIngotter;
    public static File configIngotterOreGenDir;

    public static String[] oreArray;
    public static String[] oreIngotterArray;



    //   public static String[] oreGeneration;
//    public static String[] oreIngotterGeneration

    public static boolean oreBoolean;
    public static boolean oreIngotterBoolean;

    public static final String WORLD = "Custom Generation";
    public static final String WORLD_INGOTTER = "Ingotter Generation";

    public static void init(File oreGenCustomDir, File oreGenIngotterDir) {
        oreGenCustomDir = new File(oreGenCustomDir, Constants.MODID + "/" + "world");
        oreGenCustomDir.mkdir();
        ConfigOreHandler.configCustomOreGenDir = oreGenCustomDir;
        ConfigOreHandler.configWorld = new Configuration(new File(oreGenCustomDir, "Custom-Generation.cfg"));
        
        oreGenIngotterDir = new File(oreGenIngotterDir, Constants.MODID + "/" + "world");
        oreGenIngotterDir.mkdir();
        ConfigOreHandler.configIngotterOreGenDir = oreGenIngotterDir;
        ConfigOreHandler.configIngotter = new Configuration(new File(oreGenIngotterDir, "Ingotter-Generation.cfg"));
        
        configOreVariables();

    }

    public static void configOreVariables(){
        configWorld.addCustomCategoryComment(WORLD, CATEGORY_COMMENT());
        configIngotter.addCustomCategoryComment(WORLD_INGOTTER, CATEGORY_COMMENT());

        // Custom Ore Config
        oreBoolean = configWorld.getBoolean("generate defined ores", WORLD, true, "enable generating of ores in this config");

        String[] oreGeneration = configWorld.getStringList("generation", WORLD, EMPTY_STRING, "custom ore generation");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < oreGeneration.length; i++) {
            stringBuilder.append(oreGeneration[i]);
        }
        oreArray = stringBuilder.toString().split(";");

        if (configWorld.hasChanged()) {configWorld.save();}

        
        // Ingotter Ore Config
        oreIngotterBoolean = configIngotter.getBoolean("generate defined ores", WORLD_INGOTTER, true, "enable generating of ores in this config");

        String[] oreIngotterGeneration = configIngotter.getStringList("ingotter generation", WORLD_INGOTTER, INGOTTER_DEFAULT(), STRING_LIST_INGOTTER());
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < oreIngotterGeneration.length; i++) {
            stringBuilder1.append(oreIngotterGeneration[i]);
        }
        oreIngotterArray = stringBuilder1.toString().split(";");

        if (configIngotter.hasChanged()) {configIngotter.save();}
    }


    private final static String[] EMPTY_STRING = {};

    private static String STRING_LIST_INGOTTER(){
        return "ingotter ores (feel free to edit or remove some ores), I written some hashtags (#) before some ores so they don't spawn\n";
    }

    private static String[] INGOTTER_DEFAULT(){
        return new String[]{
                // Overworld
                "" +
                        "ingotter:copper_ore -minVein:4 -maxVein:9 -minY:40 -maxY:90 -perChunk:14 -dimension:0;",
                "ingotter:tin_ore -minVein:3 -maxVein:8 -minY:25 -maxY:60 -perChunk:12 -dimension:0;",
                "ingotter:silver_ore -minVein:3 -maxVein:7 -minY:5 -maxY:25 -perChunk:9 -dimension:0;",
                "ingotter:lead_ore -minVein:4 -maxVein:8 -minY:15 -maxY:30 -perChunk:8 -dimension:0;",
                "ingotter:aluminum_ore -minVein:2 -maxVein:8 -minY:25 -maxY:80 -perChunk:8 -dimension:0;",
                "ingotter:nickel_ore -minVein:3 -maxVein:6 -minY:20 -maxY:40 -perChunk:9 -dimension:0;",
                "ingotter:platinum_ore -minVein:1 -maxVein:1 -minY:2 -maxY:24 -perChunk:1 -dimension:0;",
                "#ingotter:steel_ore -minVein:3 -maxVein:5 -minY:5 -maxY:32 -perChunk:5 -dimension:0;",
                "#ingotter:electrum_ore -minVein:3 -maxVein:6 -minY:0 -maxY:18 -perChunk:5 -dimension:0;",
                "#ingotter:bronze_ore -minVein:5 -maxVein:9 -minY:10 -maxY:45 -perChunk:7 -dimension:0;" +
                        "",
                // Nether
                "ingotter:copper_ore_nether -minVein:4 -maxVein:8 -minY:20 -maxY:120 -perChunk:14 -dimension:-1;",
                "ingotter:tin_ore_nether -minVein:2 -maxVein:8 -minY:25 -maxY:100 -perChunk:12 -dimension:-1;",
                "ingotter:silver_ore_nether -minVein:3 -maxVein:9 -minY:10 -maxY:100 -perChunk:9 -dimension:-1;",
                "ingotter:lead_ore_nether -minVein:4 -maxVein:8 -minY:15 -maxY:30 -perChunk:8 -dimension:-1;",
                "ingotter:aluminum_ore_nether -minVein:4 -maxVein:9 -minY:15 -maxY:105 -perChunk:8 -dimension:-1;",
                "ingotter:nickel_ore_nether -minVein:4 -maxVein:8 -minY:15 -maxY:90 -perChunk:9 -dimension:-1;",
                "ingotter:platinum_ore_nether -minVein:1 -maxVein:3 -minY:15 -maxY:80 -perChunk:4 -dimension:-1;",
                "ingotter:iron_ore_nether -minVein:6 -maxVein:10 -minY:15 -maxY:100 -perChunk:12 -dimension:-1;",
                "ingotter:gold_ore_nether -minVein:6 -maxVein:10 -minY:15 -maxY:70 -perChunk:7 -dimension:-1;",
                "ingotter:diamond_ore_nether -minVein:4 -maxVein:8 -minY:15 -maxY:85 -perChunk:6 -dimension:-1;",
                "ingotter:emerald_ore_nether -minVein:2 -maxVein:5 -minY:15 -maxY:105 -perChunk:5 -dimension:-1;",
                "ingotter:coal_ore_nether -minVein:8 -maxVein:16 -minY:15 -maxY:130 -perChunk:6 -dimension:-1;",
                "ingotter:lapis_ore_nether -minVein:6 -maxVein:11 -minY:15 -maxY:95 -perChunk:5 -dimension:-1;",
                "ingotter:redstone_ore_nether -minVein:4 -maxVein:8 -minY:15 -maxY:90 -perChunk:5 -dimension:-1;",
                "#ingotter:steel_ore_nether -minVein:5 -maxVein:10 -minY:5 -maxY:85 -perChunk:12 -dimension:-1;",
                "#ingotter:electrum_ore_nether -minVein:3 -maxVein:6 -minY:5 -maxY:90 -perChunk:7 -dimension:-1;",
                "#ingotter:bronze_ore_nether -minVein:6 -maxVein:12 -minY:15 -maxY:90 -perChunk:9 -dimension:-1;" +
                        "",
                // End
                "ingotter:copper_ore_end -minVein:4 -maxVein:8 -minY:50 -maxY:125 -perChunk:14 -dimension:1;",
                "ingotter:tin_ore_end -minVein:2 -maxVein:8 -minY:25 -maxY:130 -perChunk:12 -dimension:1;",
                "ingotter:silver_ore_end -minVein:3 -maxVein:9 -minY:20 -maxY:115 -perChunk:9 -dimension:1;",
                "ingotter:lead_ore_end -minVein:4 -maxVein:8 -minY:45 -maxY:110 -perChunk:8 -dimension:1;",
                "ingotter:aluminum_ore_end -minVein:4 -maxVein:9 -minY:15 -maxY:120 -perChunk:8 -dimension:1;",
                "ingotter:nickel_ore_end -minVein:4 -maxVein:8 -minY:15 -maxY:130 -perChunk:9 -dimension:1;",
                "ingotter:platinum_ore_end -minVein:1 -maxVein:3 -minY:15 -maxY:125 -perChunk:4 -dimension:1;",
                "ingotter:iron_ore_end -minVein:6 -maxVein:10 -minY:15 -maxY:100 -perChunk:12 -dimension:1;",
                "ingotter:gold_ore_end -minVein:6 -maxVein:10 -minY:15 -maxY:115 -perChunk:7 -dimension:1;",
                "ingotter:diamond_ore_end -minVein:4 -maxVein:8 -minY:15 -maxY:140 -perChunk:6 -dimension:1;",
                "ingotter:emerald_ore_end -minVein:2 -maxVein:5 -minY:15 -maxY:135 -perChunk:5 -dimension:1;",
                "ingotter:coal_ore_end -minVein:8 -maxVein:16 -minY:15 -maxY:130 -perChunk:6 -dimension:1;",
                "ingotter:lapis_ore_end -minVein:6 -maxVein:11 -minY:15 -maxY:125 -perChunk:5 -dimension:1;",
                "ingotter:redstone_ore_end -minVein:4 -maxVein:8 -minY:15 -maxY:120 -perChunk:5 -dimension:1;",
                "#ingotter:steel_ore_end -minVein:5 -maxVein:10 -minY:5 -maxY:110 -perChunk:12 -dimension:1;",
                "#ingotter:electrum_ore_end -minVein:3 -maxVein:6 -minY:5 -maxY:130 -perChunk:7 -dimension:1;",
                "#ingotter:bronze_ore_end -minVein:6 -maxVein:12 -minY:15 -maxY:125 -perChunk:9 -dimension:1;"
        };
    }

    public static String GENERATION_COMMENT() {
        return "The variables you have to type when adding ores:" +
                "\nNORMAL [IT WILL GENERATE IN STONE IN ANY DIMENSION, IF DIMENSION ALLOWS IT]" +
                "\nModID:OreName meta:NUMBER minvein:NUMBER maxvein:NUMBER miny:NUMBER maxy:NUMBER perchunk:NUMBER " +
                "\nexample: forestry:resources meta:0 minvein:12 maxvein:28 miny:110 maxy:245 perchunk:15" +
                "\nConfig option above will make forestry appatite ore spawn with vein size in range from 12 to 28 and y level from 110 to 245 " +
                "\nand it would spawn around 15 ores per chunk, if you change meta to 1 it will spawn copper ore, because forestry uses metadata for ores\n" +

                "\nGENERATE IN DEFINED DIMENSION [IT WILL GENERATE IN STONE IN DEFINED DIMENSION, IF DIMENSION ALLOWS IT]" +
                "\nModID:OreName meta:NUMBER minvein:NUMBER maxvein:NUMBER miny:NUMBER maxy:NUMBER perchunk:NUMBER dimension:DIM-NUMBER.DIM-NUMBER " +
                "\nexample: forestry:resources meta:0 minvein:12 maxvein:28 miny:110 maxy:245 perchunk:15 dimension:-1.0.1" +
                "\nConfig option above will make forestry appetite ore spawn and will replace stone in" +
                "\n-1 (Nether), 0 (Overworld) and 1 (End) dimension (You need a dot between every dimension number)\n" +

                "\nREPLACE DEFINED BLOCK [IT WILL GENERATE IN DEFINED BLOCK IN ANY DIMENSION, IF DIMENSION ALLOWS IT]" +
                "\nModID:OreName meta:NUMBER minvein:NUMBER maxvein:NUMBER miny:NUMBER maxy:NUMBER perchunk:NUMBER replace:BLOCK.BLOCK " +
                "\nexample: forestry:resources meta:0 minvein:12 maxvein:28 miny:110 maxy:245 perchunk:15 replace:minecraft:stone.minecraft:netherrack.minecraft:end_stone" +
                "\nConfig option above will make forestry appetite ore spawn and will replace Stone, Netherrack and End Stone in any dimension (You need a dot between every block name)\n" +

                "\nREPLACE DEFINED BLOCK IN DEFINED DIMENSION [IT WILL GENERATE IN DEFINED BLOCK IN DEFINED DIMENSION, IF DIMENSION ALLOWS IT]" +
                "\nModID:OreName meta:NUMBER minvein:NUMBER maxvein:NUMBER miny:NUMBER maxy:NUMBER perchunk:NUMBER replace:BLOCK.ANOTHER_BLOCK.ANOTHER dimension:DIM-NUMBER.DIM-NUMBER" +
                "\nexample: forestry:resources meta:0 minvein:12 maxvein:28 miny:110 maxy:245 perchunk:15 replace:minecraft:stone.minecraft:netherrack.minecraft:end_stone dimension:-1.0.1 " +
                "\nThe settings above will generate ores in -1 (Nether), 0 (Overworld) and 1 (End) dimension and " +
                "\nwill only replace Stone, Netherrack and End Stone (You need a dot between dimension number and block name)";
    }

    private static String CATEGORY_COMMENT(){
        return
                "The Guide:\n" +
                        "\n" +
                        "Variables:\n" +
                        "-minY: (Define the lowest Y level where block should spawn, example: -minY:20)\n" +
                        "-maxY: (Define the highest Y level where block should spawn, example: -maxY:80)\n" +
                        "-minVein: (Define the lowest vein size of the block, example: -minVein:4)\n" +
                        "-maxVein: (Define the highest vein size of the block, example: -maxVein:10)\n" +
                        "-perChunk: (Define how much veins of the block should spawn per chunk, example: -perChunk:2)\n\n\n" +
                        "-meta:      [OPTIONAL VARIABLE], blocks without this variable will have metadata set to 0\n" +
                        "            (Define metadata of the block, example: -meta:2)\n\n" +
                        "-dimension: [OPTIONAL VARIABLE], blocks without this variable will generate in any dimension\n" +
                        "            (Define in which dimension ore should spawn, you need to use dimension number and not the name)\n" +
                        "             example: -dimension:0 (this will spawn the ore in overworld), if you want to use multiple dimensions:\n" +
                        "             example: -dimension:0.-1 (this will spawn the ore in overworld and nether, you have to use a dot between each number!\n" +
                        "             Using this variable without -replace: variable: using -1 (nether) will generate block in netherrack,\n" +
                        "             0 (overworld) will generate in stone, 1 (end) will generate in end stone, every other dimension is stone only\n\n" +
                        "-replace:   [OPTIONAL VARIABLE], blocks without this variable will generate in stone\n" +
                        "            (Define which block should be replaced by the generating block)\n" +
                        "             example: -replace:minecraft:cobblestone (this will spawn it only in cobblestone), if you want multiple blocks:\n" +
                        "             example: -replace:minecraft:cobblestone.minecraft:netherrack (this will spawn it in cobblestone and netherrack),\n" +
                        "             you have to use a dot between each block name (Metadata for this variable will be added)!\n" +
                        "             Using this variable without -dimension: variable: the blocks defined will work in any possible dimension\n\n" +

                        "             At the start of each line always put the name of a block to generate and at the end of line put a semicolon (;)\n" +
                        "             example: forestry:resources -meta:1 -minVein:4 -maxVein:8 -minY:40 -maxY:90 -perChunk:5;\n" +
                        "             You can check how I did it with Ingotter ores in Ingotter-Generation.cfg";
    }

}

package terrails.ingotter.config.ore;

import static terrails.ingotter.config.ConfigOreHandler.WORLD;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigNetherHandler {

    public static final String NETHER = "Nether";

    private static final String ORE_NETHER_ALUMINUM = "Aluminum Settings";
    private static final String ORE_NETHER_COPPER = "Copper Settings";
    private static final String ORE_NETHER_LEAD = "Lead Settings";
    private static final String ORE_NETHER_NICKEL = "Nickel Settings";
    private static final String ORE_NETHER_PLATINUM = "Platinum Settings";
    private static final String ORE_NETHER_SILVER = "Silver Settings";
    private static final String ORE_NETHER_TIN = "Tin Settings";
    private static final String ORE_NETHER_STEEL = "Steel Settings";
    private static final String ORE_NETHER_ELECTRUM = "Electrum Settings";
    private static final String ORE_NETHER_BRONZE = "Bronze Settings";
    private static final String ORE_NETHER_IRON = "Iron Settings";
    private static final String ORE_NETHER_GOLD = "Gold Settings";
    private static final String ORE_NETHER_DIAMOND = "Diamond Settings";
    private static final String ORE_NETHER_EMERALD = "Emerald Settings";
    private static final String ORE_NETHER_COAL = "Coal Settings";
    private static final String ORE_NETHER_LAPIS = "Lapis Lazuli Settings";
    private static final String ORE_NETHER_REDSTONE = "Redstone Settings";
    private static final String ORE_NETHER_QUARTZ = "Quartz Settings";


    //Nether Config
    public static boolean oreGen;

    public static boolean copper;
    public static int copperMinY;
    public static int copperMaxY;
    public static int copperMinVeinSize;
    public static int copperMaxVeinSize;
    public static int copperVeinChance;

    public static boolean tin;
    public static int tinMinY;
    public static int tinMaxY;
    public static int tinMinVeinSize;
    public static int tinMaxVeinSize;
    public static int tinVeinChance;

    public static boolean silver;
    public static int silverMinY;
    public static int silverMaxY;
    public static int silverMinVeinSize;
    public static int silverMaxVeinSize;
    public static int silverVeinChance;

    public static boolean lead;
    public static int leadMinY;
    public static int leadMaxY;
    public static int leadMinVeinSize;
    public static int leadMaxVeinSize;
    public static int leadVeinChance;

    public static boolean aluminum;
    public static int aluminumMinY;
    public static int aluminumMaxY;
    public static int aluminumMinVeinSize;
    public static int aluminumMaxVeinSize;
    public static int aluminumVeinChance;

    public static boolean nickel;
    public static int nickelMinY;
    public static int nickelMaxY;
    public static int nickelMinVeinSize;
    public static int nickelMaxVeinSize;
    public static int nickelVeinChance;

    public static boolean platinum;
    public static int platinumMinY;
    public static int platinumMaxY;
    public static int platinumMinVeinSize;
    public static int platinumMaxVeinSize;
    public static int platinumVeinChance;

    public static boolean steel;
    public static int steelMinY;
    public static int steelMaxY;
    public static int steelMinVeinSize;
    public static int steelMaxVeinSize;
    public static int steelVeinChance;

    public static boolean electrum;
    public static int electrumMinY;
    public static int electrumMaxY;
    public static int electrumMinVeinSize;
    public static int electrumMaxVeinSize;
    public static int electrumVeinChance;

    public static boolean bronze;
    public static int bronzeMinY;
    public static int bronzeMaxY;
    public static int bronzeMinVeinSize;
    public static int bronzeMaxVeinSize;
    public static int bronzeVeinChance;

    public static boolean iron;
    public static int ironMinY;
    public static int ironMaxY;
    public static int ironMinVeinSize;
    public static int ironMaxVeinSize;
    public static int ironVeinChance;

    public static boolean gold;
    public static int goldMinY;
    public static int goldMaxY;
    public static int goldMinVeinSize;
    public static int goldMaxVeinSize;
    public static int goldVeinChance;

    public static boolean diamond;
    public static int diamondMinY;
    public static int diamondMaxY;
    public static int diamondMinVeinSize;
    public static int diamondMaxVeinSize;
    public static int diamondVeinChance;

    public static boolean emerald;
    public static int emeraldMinY;
    public static int emeraldMaxY;
    public static int emeraldMinVeinSize;
    public static int emeraldMaxVeinSize;
    public static int emeraldVeinChance;

    public static boolean coal;
    public static int coalMinY;
    public static int coalMaxY;
    public static int coalMinVeinSize;
    public static int coalMaxVeinSize;
    public static int coalVeinChance;

    public static boolean lapis;
    public static int lapisMinY;
    public static int lapisMaxY;
    public static int lapisMinVeinSize;
    public static int lapisMaxVeinSize;
    public static int lapisVeinChance;

    public static boolean redstone;
    public static int redstoneMinY;
    public static int redstoneMaxY;
    public static int redstoneMinVeinSize;
    public static int redstoneMaxVeinSize;
    public static int redstoneVeinChance;

    public static boolean quartz;
    public static int quartzMinY;
    public static int quartzMaxY;
    public static int quartzMinVeinSize;
    public static int quartzMaxVeinSize;
    public static int quartzVeinChance;
    
    private static String NETHER_ORE = WORLD + "." + NETHER;
    public static void oreNetherGenConfig()
    {
        oreGen = configWorld.get(NETHER_ORE, "Generate Everything", true).getBoolean();

        //Copper
        copper = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Generate Ore", true).getBoolean();
        copperMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Min Y Level", 20, "", 1, 256).getInt();
        copperMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Max Y Level", 120, "", 1, 256).getInt();
        copperMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Min Vein Size", 4, "", 1, 64).getInt();
        copperMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Max Vein Size", 8, "", 1, 64).getInt();
        copperVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COPPER, "Veins Per Chunk", 14, "", 1, 48).getInt();

        //Tin
        tin = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Generate Ore", true).getBoolean();
        tinMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Min Y Level", 25, "", 1, 256).getInt();
        tinMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Max Y Level", 100, "", 1, 256).getInt();
        tinMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Min Vein Size", 2, "", 1, 64).getInt();
        tinMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Max Vein Size", 8, "", 1, 64).getInt();
        tinVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_TIN, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Silver
        silver = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Generate Ore", true).getBoolean();
        silverMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Min Y Level", 5, "", 1, 256).getInt();
        silverMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Max Y Level", 90, "", 1, 256).getInt();
        silverMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Min Vein Size", 3, "", 1, 64).getInt();
        silverMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Max Vein Size", 9, "", 1, 64).getInt();
        silverVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_SILVER, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Lead
        lead = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Generate Ore", true).getBoolean();
        leadMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Min Y Level", 15, "", 1, 256).getInt();
        leadMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Max Y Level", 105, "", 1, 256).getInt();
        leadMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Min Vein Size", 7, "", 1, 64).getInt();
        leadMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Max Vein Size", 9, "", 1, 64).getInt();
        leadVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LEAD, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Aluminum
        aluminum = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Generate Ore", true).getBoolean();
        aluminumMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Min Y Level", 20, "", 1, 256).getInt();
        aluminumMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Max Y Level", 95, "", 1, 256).getInt();
        aluminumMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Min Vein Size", 4, "", 1, 64).getInt();
        aluminumMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Max Vein Size", 9, "", 1, 64).getInt();
        aluminumVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ALUMINUM, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Nickel
        nickel = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Generate Ore", true).getBoolean();
        nickelMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Min Y Level", 15, "", 1, 256).getInt();
        nickelMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Max Y Level", 90, "", 1, 256).getInt();
        nickelMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Min Vein Size", 4, "", 1, 64).getInt();
        nickelMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Max Vein Size", 8, "", 1, 64).getInt();
        nickelVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_NICKEL, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Platinum
        platinum = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Generate Ore", true).getBoolean();
        platinumMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Min Y Level", 8, "", 1, 256).getInt();
        platinumMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Max Y Level", 80, "", 1, 256).getInt();
        platinumMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Min Vein Size", 3, "", 1, 64).getInt();
        platinumMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Max Vein Size", 5, "", 1, 64).getInt();
        platinumVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_PLATINUM, "Veins Per Chunk", 5, "", 1, 48).getInt();

        //Steel
        steel = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Generate Ore", false).getBoolean();
        steelMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Min Y Level", 5, "", 1, 256).getInt();
        steelMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Max Y Level", 85, "", 1, 256).getInt();
        steelMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Min Vein Size", 5, "", 1, 64).getInt();
        steelMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Max Vein Size", 10, "", 1, 64).getInt();
        steelVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_STEEL, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Electrum
        electrum = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Generate Ore", false).getBoolean();
        electrumMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Min Y Level", 1, "", 1, 256).getInt();
        electrumMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Max Y Level", 90, "", 1, 256).getInt();
        electrumMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Min Vein Size", 3, "", 1, 64).getInt();
        electrumMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Max Vein Size", 6, "", 1, 64).getInt();
        electrumVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_ELECTRUM, "Veins Per Chunk", 7, "", 1, 48).getInt();

        //Bronze
        bronze = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Generate Ore", false).getBoolean();
        bronzeMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Min Y Level", 15, "", 1, 256).getInt();
        bronzeMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Max Y Level", 90, "", 1, 256).getInt();
        bronzeMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Min Vein Size", 6, "", 1, 64).getInt();
        bronzeMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Max Vein Size", 12, "", 1, 64).getInt();
        bronzeVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_BRONZE, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Iron
        iron = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Generate Ore", true).getBoolean();
        ironMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Min Y Level", 15, "", 1, 256).getInt();
        ironMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Max Y Level", 100, "", 1, 256).getInt();
        ironMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Min Vein Size", 6, "", 1, 64).getInt();
        ironMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Max Vein Size", 10, "", 1, 64).getInt();
        ironVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_IRON, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Gold
        gold = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Generate Ore", true).getBoolean();
        goldMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Min Y Level", 15, "", 1, 256).getInt();
        goldMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Max Y Level", 70, "", 1, 256).getInt();
        goldMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Min Vein Size", 6, "", 1, 64).getInt();
        goldMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Max Vein Size", 10, "", 1, 64).getInt();
        goldVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_GOLD, "Veins Per Chunk", 7, "", 1, 48).getInt();

        //Diamond
        diamond = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Generate Ore", true).getBoolean();
        diamondMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Min Y Level", 15, "", 1, 256).getInt();
        diamondMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Max Y Level", 85, "", 1, 256).getInt();
        diamondMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Min Vein Size", 4, "", 1, 64).getInt();
        diamondMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Max Vein Size", 8, "", 1, 64).getInt();
        diamondVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_DIAMOND, "Veins Per Chunk", 6, "", 1, 48).getInt();

        //Emerald
        emerald = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Generate Ore", true).getBoolean();
        emeraldMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Min Y Level", 15, "", 1, 256).getInt();
        emeraldMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Max Y Level", 105, "", 1, 256).getInt();
        emeraldMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Min Vein Size", 4, "", 1, 64).getInt();
        emeraldMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Max Vein Size", 6, "", 1, 64).getInt();
        emeraldVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_EMERALD, "Veins Per Chunk", 5, "", 1, 48).getInt();

        //Coal
        coal = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Generate Ore", true).getBoolean();
        coalMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Min Y Level", 15, "", 1, 256).getInt();
        coalMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Max Y Level", 95, "", 1, 256).getInt();
        coalMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Min Vein Size", 8, "", 1, 64).getInt();
        coalMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Max Vein Size", 16, "", 1, 64).getInt();
        coalVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_COAL, "Veins Per Chunk", 6, "", 1, 48).getInt();

        //Lapis
        lapis = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Generate Ore", true).getBoolean();
        lapisMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Min Y Level", 15, "", 1, 256).getInt();
        lapisMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Max Y Level", 85, "", 1, 256).getInt();
        lapisMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Min Vein Size", 6, "", 1, 64).getInt();
        lapisMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Max Vein Size", 11, "", 1, 64).getInt();
        lapisVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_LAPIS, "Veins Per Chunk", 4, "", 1, 48).getInt();

        //Redstone
        redstone = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Generate Ore", true).getBoolean();
        redstoneMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Min Y Level", 15, "", 1, 256).getInt();
        redstoneMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Max Y Level", 90, "", 1, 256).getInt();
        redstoneMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Min Vein Size", 4, "", 1, 64).getInt();
        redstoneMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Max Vein Size", 8, "", 1, 64).getInt();
        redstoneVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_REDSTONE, "Veins Per Chunk", 5, "", 1, 48).getInt();

        //Quartz
        quartz = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Generate Ore", true).getBoolean();
        quartzMinY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Min Y Level", 10, "", 1, 256).getInt();
        quartzMaxY = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Max Y Level", 118, "", 1, 256).getInt();
        quartzMinVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Min Vein Size", 5, "", 1, 64).getInt();
        quartzMaxVeinSize = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Max Vein Size", 14, "", 1, 64).getInt();
        quartzVeinChance = configWorld.get(NETHER_ORE + "." +  ORE_NETHER_QUARTZ, "Veins Per Chunk", 5, "", 1, 48).getInt();

        if (configWorld.hasChanged()) {
            configWorld.save();
        }
    }
}

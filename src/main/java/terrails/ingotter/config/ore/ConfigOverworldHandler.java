package terrails.ingotter.config.ore;

import static terrails.ingotter.config.ConfigOreHandler.WORLD;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigOverworldHandler {

    public static final String OVERWORLD = "Overworld";

    private static final String ORE_IRON = "Iron Settings";
    private static final String ORE_GOLD = "Gold Settings";
    private static final String ORE_DIAMOND = "Diamond Settings";
    private static final String ORE_EMERALD = "Emerald Settings";
    private static final String ORE_COAL = "Coal Settings";
    private static final String ORE_LAPIS = "Lapis Lazuli Settings";
    private static final String ORE_REDSTONE = "Redstone Settings";
    private static final String ORE_ALUMINUM = "Aluminum Settings";
    private static final String ORE_COPPER = "Copper Settings";
    private static final String ORE_LEAD = "Lead Settings";
    private static final String ORE_NICKEL = "Nickel Settings";
    private static final String ORE_PLATINUM = "Platinum Settings";
    private static final String ORE_SILVER = "Silver Settings";
    private static final String ORE_TIN = "Tin Settings";
    private static final String ORE_STEEL = "Steel Settings";
    private static final String ORE_ELECTRUM = "Electrum Settings";
    private static final String ORE_BRONZE = "Bronze Settings";

    //Overworld Config
    public static boolean oreGen;

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
    public static boolean spawnInExtremeHills;
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

    private static final String OVERWORLD_GEN = WORLD + "." + OVERWORLD;
    public static void oreOverworldGenConfig()
    {
        oreGen = configWorld.get(OVERWORLD_GEN, "Generate Everything", true).getBoolean();
        //Iron
        iron = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Generate Ore", true).getBoolean();
        ironMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Min Y Level", 0, "", 0, 256).getInt();
        ironMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Max Y Level", 64, "", 0, 256).getInt();
        ironMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Min Vein Size", 3, "", 0, 64).getInt();
        ironMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Max Vein Size", 9, "", 0, 64).getInt();
        ironVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_IRON, "Veins Per Chunk", 20, "", 0, 48).getInt();

        //Gold
        gold = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Generate Ore", true).getBoolean();
        goldMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Min Y Level", 0, "", 0, 256).getInt();
        goldMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Max Y Level", 32, "", 0, 256).getInt();
        goldMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Min Vein Size", 3, "", 0, 64).getInt();
        goldMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Max Vein Size", 9, "", 0, 64).getInt();
        goldVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_GOLD, "Veins Per Chunk", 2, "", 0, 48).getInt();

        //Diamond
        diamond = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Generate Ore", true).getBoolean();
        diamondMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Min Y Level", 0, "", 0, 256).getInt();
        diamondMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Max Y Level", 16, "", 0, 256).getInt();
        diamondMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Min Vein Size", 2, "", 0, 64).getInt();
        diamondMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Max Vein Size", 8, "", 0, 64).getInt();
        diamondVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_DIAMOND, "Veins Per Chunk", 1, "", 0, 48).getInt();

        //Emerald
        emerald = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Generate Ore", true).getBoolean();
        spawnInExtremeHills = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Spawn In Extreme Hills", true).getBoolean();
        emeraldMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Min Y Level", 4, "", 0, 256).getInt();
        emeraldMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Max Y Level", 32, "", 0, 256).getInt();
        emeraldMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Min Vein Size", 1, "", 0, 64).getInt();
        emeraldMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Max Vein Size", 1, "", 0, 64).getInt();
        emeraldVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_EMERALD, "Veins Per Chunk", 8, "", 0, 48).getInt();

        //Coal
        coal = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Generate Ore", true).getBoolean();
        coalMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Min Y Level", 0, "", 0, 256).getInt();
        coalMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Max Y Level", 128, "", 0, 256).getInt();
        coalMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Min Vein Size", 6, "", 0, 64).getInt();
        coalMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Max Vein Size", 17, "", 0, 64).getInt();
        coalVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_COAL, "Veins Per Chunk", 20, "", 0, 48).getInt();

        //Lapis Lazuli
        lapis = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Generate Ore", true).getBoolean();
        lapisMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Min Y Level", 0, "", 0, 256).getInt();
        lapisMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Max Y Level", 24, "", 0, 256).getInt();
        lapisMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Min Vein Size", 4, "", 0, 64).getInt();
        lapisMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Max Vein Size", 7, "", 0, 64).getInt();
        lapisVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_LAPIS, "Veins Per Chunk", 1, "", 0, 48).getInt();

        //Redstone
        redstone = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Generate Ore", true).getBoolean();
        redstoneMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Min Y Level", 0, "", 0, 256).getInt();
        redstoneMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Max Y Level", 16, "", 0, 256).getInt();
        redstoneMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Min Vein Size", 5, "", 0, 64).getInt();
        redstoneMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Max Vein Size", 8, "", 0, 64).getInt();
        redstoneVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_REDSTONE, "Veins Per Chunk", 8, "", 0, 48).getInt();


        //Copper
        copper = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Generate Ore", true).getBoolean();
        copperMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Min Y Level", 45, "", 0, 256).getInt();
        copperMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Max Y Level", 80, "", 0, 256).getInt();
        copperMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Min Vein Size", 4, "", 0, 64).getInt();
        copperMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Max Vein Size", 8, "", 0, 64).getInt();
        copperVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_COPPER, "Veins Per Chunk", 14, "", 0, 48).getInt();

        //Tin
        tin = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Generate Ore", true).getBoolean();
        tinMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Min Y Level", 25, "", 0, 256).getInt();
        tinMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Max Y Level", 55, "", 0, 256).getInt();
        tinMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Min Vein Size", 2, "", 0, 64).getInt();
        tinMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Max Vein Size", 8, "", 0, 64).getInt();
        tinVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_TIN, "Veins Per Chunk", 12, "", 0, 48).getInt();

        //Silver
        silver = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Generate Ore", true).getBoolean();
        silverMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Min Y Level", 5, "", 0, 256).getInt();
        silverMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Max Y Level", 25, "", 0, 256).getInt();
        silverMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Min Vein Size", 3, "", 0, 64).getInt();
        silverMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Max Vein Size", 7, "", 0, 64).getInt();
        silverVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_SILVER, "Veins Per Chunk", 9, "", 0, 48).getInt();

        //Lead
        lead = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Generate Ore", true).getBoolean();
        leadMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Min Y Level", 15, "", 0, 256).getInt();
        leadMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Max Y Level", 30, "", 0, 256).getInt();
        leadMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Min Vein Size", 6, "", 0, 64).getInt();
        leadMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Max Vein Size", 8, "", 0, 64).getInt();
        leadVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_LEAD, "Veins Per Chunk", 8, "", 0, 48).getInt();

        //Aluminum
        aluminum = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Generate Ore", true).getBoolean();
        aluminumMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Min Y Level", 20, "", 0, 256).getInt();
        aluminumMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Max Y Level", 60, "", 0, 256).getInt();
        aluminumMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Min Vein Size", 2, "", 0, 64).getInt();
        aluminumMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Max Vein Size", 8, "", 0, 64).getInt();
        aluminumVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_ALUMINUM, "Veins Per Chunk", 8, "", 0, 48).getInt();

        //Nickel
        nickel = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Generate Ore", true).getBoolean();
        nickelMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Min Y Level", 20, "", 0, 256).getInt();
        nickelMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Max Y Level", 40, "", 0, 256).getInt();
        nickelMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Min Vein Size", 3, "", 0, 64).getInt();
        nickelMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Max Vein Size", 6, "", 0, 64).getInt();
        nickelVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_NICKEL, "Veins Per Chunk", 9, "", 0, 48).getInt();

        //Platinum
        platinum = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Generate Ore", true).getBoolean();
        platinumMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Min Y Level", 2, "", 0, 256).getInt();
        platinumMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Max Y Level", 24, "", 0, 256).getInt();
        platinumMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Min Vein Size", 1, "", 0, 64).getInt();
        platinumMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Max Vein Size", 1, "", 0, 64).getInt();
        platinumVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_PLATINUM, "Veins Per Chunk", 1, "", 0, 48).getInt();

        //Steel
        steel = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Generate Ore", false).getBoolean();
        steelMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Min Y Level", 5, "", 0, 256).getInt();
        steelMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Max Y Level", 32, "", 0, 256).getInt();
        steelMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Min Vein Size", 3, "", 0, 64).getInt();
        steelMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Max Vein Size", 5, "", 0, 64).getInt();
        steelVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_STEEL, "Veins Per Chunk", 5, "", 0, 48).getInt();

        //Electrum
        electrum = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Generate Ore", false).getBoolean();
        electrumMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Min Y Level", 1, "", 0, 256).getInt();
        electrumMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Max Y Level", 18, "", 0, 256).getInt();
        electrumMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Min Vein Size", 3, "", 0, 64).getInt();
        electrumMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Max Vein Size", 6, "", 0, 64).getInt();
        electrumVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_ELECTRUM, "Veins Per Chunk", 5, "", 0, 48).getInt();

        //Bronze
        bronze = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Generate Ore", false).getBoolean();
        bronzeMinY = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Min Y Level", 10, "", 0, 256).getInt();
        bronzeMaxY = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Max Y Level", 45, "", 0, 256).getInt();
        bronzeMinVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Min Vein Size", 5, "", 0, 64).getInt();
        bronzeMaxVeinSize = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Max Vein Size", 9, "", 0, 64).getInt();
        bronzeVeinChance = configWorld.get(OVERWORLD_GEN + "." + ORE_BRONZE, "Veins Per Chunk", 7, "", 0, 48).getInt();

        if (configWorld.hasChanged()) {
            configWorld.save();
        }
    }
}

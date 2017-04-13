package terrails.ingotter.config.ore;

import static terrails.ingotter.config.ConfigOreHandler.WORLD;
import static terrails.ingotter.config.ConfigOreHandler.configWorld;

public class ConfigEndHandler {

    public static final String END = "The End";

    private static final String ORE_END_ALUMINUM = "Aluminum Settings";
    private static final String ORE_END_COPPER = "Copper Settings";
    private static final String ORE_END_LEAD = "Lead Settings";
    private static final String ORE_END_NICKEL = "Nickel Settings";
    private static final String ORE_END_PLATINUM = "Platinum Settings";
    private static final String ORE_END_SILVER = "Silver Settings";
    private static final String ORE_END_TIN = "Tin Settings";
    private static final String ORE_END_STEEL = "Steel Settings";
    private static final String ORE_END_ELECTRUM = "Electrum Settings";
    private static final String ORE_END_BRONZE = "Bronze Settings";
    private static final String ORE_END_IRON = "Iron Settings";
    private static final String ORE_END_GOLD = "Gold Settings";
    private static final String ORE_END_DIAMOND = "Diamond Settings";
    private static final String ORE_END_EMERALD = "Emerald Settings";
    private static final String ORE_END_COAL = "Coal Settings";
    private static final String ORE_END_LAPIS = "Lapis Lazuli Settings";
    private static final String ORE_END_REDSTONE = "Redstone Settings";

    //End Config
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

    private static String END_ORE = WORLD + "." + END;
    public static void oreGenConfig()
    {
        oreGen = configWorld.get(END_ORE, "Generate Everything", true).getBoolean();

        //Copper
        copper = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Generate Ore", true).getBoolean();
        copperMinY = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Min Y Level", 45, "", 1, 256).getInt();
        copperMaxY = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Max Y Level", 80, "", 1, 256).getInt();
        copperMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Min Vein Size", 4, "", 1, 64).getInt();
        copperMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Max Vein Size", 8, "", 1, 64).getInt();
        copperVeinChance = configWorld.get(END_ORE + "." +  ORE_END_COPPER, "Veins Per Chunk", 14, "", 1, 48).getInt();

        //Tin
        tin = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Generate Ore", true).getBoolean();
        tinMinY = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Min Y Level", 25, "", 1, 256).getInt();
        tinMaxY = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Max Y Level", 55, "", 1, 256).getInt();
        tinMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Min Vein Size", 2, "", 1, 64).getInt();
        tinMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Max Vein Size", 8, "", 1, 64).getInt();
        tinVeinChance = configWorld.get(END_ORE + "." +  ORE_END_TIN, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Silver
        silver = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Generate Ore", true).getBoolean();
        silverMinY = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Min Y Level", 5, "", 1, 256).getInt();
        silverMaxY = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Max Y Level", 50, "", 1, 256).getInt();
        silverMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Min Vein Size", 3, "", 1, 64).getInt();
        silverMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Max Vein Size", 9, "", 1, 64).getInt();
        silverVeinChance = configWorld.get(END_ORE + "." +  ORE_END_SILVER, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Lead
        lead = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Generate Ore", true).getBoolean();
        leadMinY = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Min Y Level", 15, "", 1, 256).getInt();
        leadMaxY = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Max Y Level", 60, "", 1, 256).getInt();
        leadMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Min Vein Size", 7, "", 1, 64).getInt();
        leadMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Max Vein Size", 9, "", 1, 64).getInt();
        leadVeinChance = configWorld.get(END_ORE + "." +  ORE_END_LEAD, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Aluminum
        aluminum = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Generate Ore", true).getBoolean();
        aluminumMinY = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Min Y Level", 20, "", 1, 256).getInt();
        aluminumMaxY = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Max Y Level", 75, "", 1, 256).getInt();
        aluminumMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Min Vein Size", 4, "", 1, 64).getInt();
        aluminumMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Max Vein Size", 9, "", 1, 64).getInt();
        aluminumVeinChance = configWorld.get(END_ORE + "." +  ORE_END_ALUMINUM, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Nickel
        nickel = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Generate Ore", true).getBoolean();
        nickelMinY = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Min Y Level", 20, "", 1, 256).getInt();
        nickelMaxY = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Max Y Level", 50, "", 1, 256).getInt();
        nickelMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Min Vein Size", 4, "", 1, 64).getInt();
        nickelMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Max Vein Size", 8, "", 1, 64).getInt();
        nickelVeinChance = configWorld.get(END_ORE + "." +  ORE_END_NICKEL, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Platinum
        platinum = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Generate Ore", true).getBoolean();
        platinumMinY = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Min Y Level", 8, "", 1, 256).getInt();
        platinumMaxY = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Max Y Level", 60, "", 1, 256).getInt();
        platinumMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Min Vein Size", 3, "", 1, 64).getInt();
        platinumMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Max Vein Size", 5, "", 1, 64).getInt();
        platinumVeinChance = configWorld.get(END_ORE + "." +  ORE_END_PLATINUM, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Steel
        steel = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Generate Ore", false).getBoolean();
        steelMinY = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Min Y Level", 5, "", 1, 256).getInt();
        steelMaxY = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Max Y Level", 70, "", 1, 256).getInt();
        steelMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Min Vein Size", 5, "", 1, 64).getInt();
        steelMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Max Vein Size", 10, "", 1, 64).getInt();
        steelVeinChance = configWorld.get(END_ORE + "." +  ORE_END_STEEL, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Electrum
        electrum = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Generate Ore", false).getBoolean();
        electrumMinY = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Min Y Level", 1, "", 1, 256).getInt();
        electrumMaxY = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Max Y Level", 90, "", 1, 256).getInt();
        electrumMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Min Vein Size", 3, "", 1, 64).getInt();
        electrumMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Max Vein Size", 6, "", 1, 64).getInt();
        electrumVeinChance = configWorld.get(END_ORE + "." +  ORE_END_ELECTRUM, "Veins Per Chunk", 7, "", 1, 48).getInt();

        //Bronze
        bronze = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Generate Ore", false).getBoolean();
        bronzeMinY = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Min Y Level", 15, "", 1, 256).getInt();
        bronzeMaxY = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Max Y Level", 70, "", 1, 256).getInt();
        bronzeMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Min Vein Size", 6, "", 1, 64).getInt();
        bronzeMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Max Vein Size", 12, "", 1, 64).getInt();
        bronzeVeinChance = configWorld.get(END_ORE + "." +  ORE_END_BRONZE, "Veins Per Chunk", 9, "", 1, 48).getInt();

        //Iron
        iron = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Generate Ore", true).getBoolean();
        ironMinY = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Min Y Level", 15, "", 1, 256).getInt();
        ironMaxY = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Max Y Level", 120, "", 1, 256).getInt();
        ironMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Min Vein Size", 6, "", 1, 64).getInt();
        ironMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Max Vein Size", 10, "", 1, 64).getInt();
        ironVeinChance = configWorld.get(END_ORE + "." +  ORE_END_IRON, "Veins Per Chunk", 12, "", 1, 48).getInt();

        //Gold
        gold = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Generate Ore", true).getBoolean();
        goldMinY = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Min Y Level", 15, "", 1, 256).getInt();
        goldMaxY = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Max Y Level", 70, "", 1, 256).getInt();
        goldMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Min Vein Size", 6, "", 1, 64).getInt();
        goldMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Max Vein Size", 10, "", 1, 64).getInt();
        goldVeinChance = configWorld.get(END_ORE + "." +  ORE_END_GOLD, "Veins Per Chunk", 7, "", 1, 48).getInt();

        //Diamond
        diamond = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Generate Ore", true).getBoolean();
        diamondMinY = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Min Y Level", 15, "", 1, 256).getInt();
        diamondMaxY = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Max Y Level", 75, "", 1, 256).getInt();
        diamondMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Min Vein Size", 4, "", 1, 64).getInt();
        diamondMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Max Vein Size", 8, "", 1, 64).getInt();
        diamondVeinChance = configWorld.get(END_ORE + "." +  ORE_END_DIAMOND, "Veins Per Chunk", 10, "", 1, 48).getInt();

        //Emerald
        emerald = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Generate Ore", true).getBoolean();
        emeraldMinY = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Min Y Level", 15, "", 1, 256).getInt();
        emeraldMaxY = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Max Y Level", 128, "", 1, 256).getInt();
        emeraldMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Min Vein Size", 4, "", 1, 64).getInt();
        emeraldMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Max Vein Size", 6, "", 1, 64).getInt();
        emeraldVeinChance = configWorld.get(END_ORE + "." +  ORE_END_EMERALD, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Coal
        coal = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Generate Ore", true).getBoolean();
        coalMinY = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Min Y Level", 15, "", 1, 256).getInt();
        coalMaxY = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Max Y Level", 80, "", 1, 256).getInt();
        coalMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Min Vein Size", 8, "", 1, 64).getInt();
        coalMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Max Vein Size", 16, "", 1, 64).getInt();
        coalVeinChance = configWorld.get(END_ORE + "." +  ORE_END_COAL, "Veins Per Chunk", 8, "", 1, 48).getInt();

        //Lapis
        lapis = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Generate Ore", true).getBoolean();
        lapisMinY = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Min Y Level", 15, "", 1, 256).getInt();
        lapisMaxY = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Max Y Level", 85, "", 1, 256).getInt();
        lapisMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Min Vein Size", 6, "", 1, 64).getInt();
        lapisMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Max Vein Size", 11, "", 1, 64).getInt();
        lapisVeinChance = configWorld.get(END_ORE + "." +  ORE_END_LAPIS, "Veins Per Chunk", 13, "", 1, 48).getInt();

        //Redstone
        redstone = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Generate Ore", true).getBoolean();
        redstoneMinY = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Min Y Level", 15, "", 1, 256).getInt();
        redstoneMaxY = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Max Y Level", 80, "", 1, 256).getInt();
        redstoneMinVeinSize = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Min Vein Size", 4, "", 1, 64).getInt();
        redstoneMaxVeinSize = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Max Vein Size", 8, "", 1, 64).getInt();
        redstoneVeinChance = configWorld.get(END_ORE + "." +  ORE_END_REDSTONE, "Veins Per Chunk", 10, "", 1, 48).getInt();

        if (configWorld.hasChanged()) {
            configWorld.save();
        }
    }

}

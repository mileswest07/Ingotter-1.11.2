package terrails.ingotter.init.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;

public class ModPlates {

    public static ItemBase plateIron;
    public static ItemBase plateGold;
    public static ItemBase plateCopper;
    public static ItemBase plateTin;
    public static ItemBase plateSilver;
    public static ItemBase plateLead;
    public static ItemBase plateAluminum;
    public static ItemBase plateNickel;
    public static ItemBase platePlatinum;
    public static ItemBase plateSteel;
    public static ItemBase plateElectrum;
    public static ItemBase plateBronze;
    public static ItemBase plateCoal;
    public static ItemBase plateDiamond;
    public static ItemBase plateEmerald;
    public static ItemBase plateRedstone;
    public static ItemBase plateLapis;

    public static void init() {
        Constants.LOGGER.info("Loading Plates...");
        plateIron = register(new ItemBase("iron_plate"));
        plateGold = register(new ItemBase("gold_plate"));
        plateCopper = register(new ItemBase("copper_plate"));
        plateTin = register(new ItemBase("tin_plate"));
        plateSilver = register(new ItemBase("silver_plate"));
        plateLead = register(new ItemBase("lead_plate"));
        plateAluminum = register(new ItemBase("aluminum_plate"));
        plateNickel = register(new ItemBase("nickel_plate"));
        platePlatinum = register(new ItemBase("platinum_plate"));
        plateSteel = register(new ItemBase("steel_plate"));
        plateElectrum = register(new ItemBase("electrum_plate"));
        plateBronze = register(new ItemBase("bronze_plate"));

        plateCoal = register(new ItemBase("coal_plate"));
        plateDiamond = register(new ItemBase("diamond_plate"));
        plateEmerald = register(new ItemBase("emerald_plate"));
        plateRedstone = register(new ItemBase("redstone_plate"));
        plateLapis = register(new ItemBase("lapis_plate"));
    }
    
    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

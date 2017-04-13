package terrails.ingotter.init.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;

public class ModWires {

    public static ItemBase wireIron;
    public static ItemBase wireGold;
    public static ItemBase wireCopper;
    public static ItemBase wireTin;
    public static ItemBase wireSilver;
    public static ItemBase wireLead;
    public static ItemBase wireAluminum;
    public static ItemBase wireNickel;
    public static ItemBase wirePlatinum;
    public static ItemBase wireSteel;
    public static ItemBase wireElectrum;
    public static ItemBase wireBronze;
    public static ItemBase wireCoal;
    public static ItemBase wireDiamond;
    public static ItemBase wireEmerald;
    public static ItemBase wireRedstone;
    public static ItemBase wireLapis;

    public static void init() {
        Constants.LOGGER.info("Loading Wires...");
        wireIron = register(new ItemBase("iron_wire"));
        wireGold = register(new ItemBase("gold_wire"));
        wireCopper = register(new ItemBase("copper_wire"));
        wireTin = register(new ItemBase("tin_wire"));
        wireSilver = register(new ItemBase("silver_wire"));
        wireLead = register(new ItemBase("lead_wire"));
        wireAluminum = register(new ItemBase("aluminum_wire"));
        wireNickel = register(new ItemBase("nickel_wire"));
        wirePlatinum = register(new ItemBase("platinum_wire"));
        wireSteel = register(new ItemBase("steel_wire"));
        wireElectrum = register(new ItemBase("electrum_wire"));
        wireBronze = register(new ItemBase("bronze_wire"));

        wireCoal = register(new ItemBase("coal_wire"));
        wireDiamond = register(new ItemBase("diamond_wire"));
        wireEmerald = register(new ItemBase("emerald_wire"));
        wireRedstone = register(new ItemBase("redstone_wire"));
        wireLapis = register(new ItemBase("lapis_wire"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

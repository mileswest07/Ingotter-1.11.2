package terrails.ingotter.init.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;

public class ModDusts {
    
    public static ItemBase ironDust;
    public static ItemBase goldDust;
    public static ItemBase copperDust;
    public static ItemBase tinDust;
    public static ItemBase silverDust;
    public static ItemBase leadDust;
    public static ItemBase aluminumDust;
    public static ItemBase nickelDust;
    public static ItemBase platinumDust;
    public static ItemBase steelDust;
    public static ItemBase electrumDust;
    public static ItemBase bronzeDust;
    public static ItemBase coalDust;
    public static ItemBase diamondDust;
    public static ItemBase emeraldDust;
    public static ItemBase lapisDust;

    public static void init() {
        Constants.LOGGER.info("Loading Dusts...");
        ironDust = register(new ItemBase("iron_dust"));
        goldDust = register(new ItemBase("gold_dust"));
        copperDust = register(new ItemBase("copper_dust"));
        tinDust = register(new ItemBase("tin_dust"));
        silverDust = register(new ItemBase("silver_dust"));
        leadDust = register(new ItemBase("lead_dust"));
        aluminumDust = register(new ItemBase("aluminum_dust"));
        nickelDust = register(new ItemBase("nickel_dust"));
        platinumDust = register(new ItemBase("platinum_dust"));
        steelDust = register(new ItemBase("steel_dust"));
        electrumDust = register(new ItemBase("electrum_dust"));
        bronzeDust = register(new ItemBase("bronze_dust"));

        coalDust = register(new ItemBase("coal_dust"));
        diamondDust = register(new ItemBase("diamond_dust"));
        emeraldDust = register(new ItemBase("emerald_dust"));
        lapisDust = register(new ItemBase("lapis_dust"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}
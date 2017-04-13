package terrails.ingotter.init.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;

public class ModNuggets {

    public static ItemBase nuggetCopper;
    public static ItemBase nuggetTin;
    public static ItemBase nuggetSilver;
    public static ItemBase nuggetLead;
    public static ItemBase nuggetAluminum;
    public static ItemBase nuggetNickel;
    public static ItemBase nuggetPlatinum;
    public static ItemBase nuggetSteel;
    public static ItemBase nuggetElectrum;
    public static ItemBase nuggetBronze;
    public static ItemBase nuggetCoal;
    public static ItemBase nuggetDiamond;
    public static ItemBase nuggetEmerald;
    public static ItemBase nuggetLapis;

    public static void init() {
        Constants.LOGGER.info("Loading Nuggets...");
        nuggetCopper = register(new ItemBase("copper_nugget"));
        nuggetTin = register(new ItemBase("tin_nugget"));
        nuggetSilver = register(new ItemBase("silver_nugget"));
        nuggetLead = register(new ItemBase("lead_nugget"));
        nuggetAluminum = register(new ItemBase("aluminum_nugget"));
        nuggetNickel = register(new ItemBase("nickel_nugget"));
        nuggetPlatinum = register(new ItemBase("platinum_nugget"));
        nuggetSteel = register(new ItemBase("steel_nugget"));
        nuggetElectrum = register(new ItemBase("electrum_nugget"));
        nuggetBronze = register(new ItemBase("bronze_nugget"));

        nuggetCoal = register(new ItemBase("coal_nugget"));
        nuggetDiamond = register(new ItemBase("diamond_nugget"));
        nuggetEmerald = register(new ItemBase("emerald_nugget"));
        nuggetLapis = register(new ItemBase("lapis_nugget"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

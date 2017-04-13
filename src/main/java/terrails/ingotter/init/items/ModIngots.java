package terrails.ingotter.init.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;

public class ModIngots {
    
    public static ItemBase ingotCopper;
    public static ItemBase ingotTin;
    public static ItemBase ingotSilver;
    public static ItemBase ingotLead;
    public static ItemBase ingotAluminum;
    public static ItemBase ingotNickel;
    public static ItemBase ingotPlatinum;
    public static ItemBase ingotSteel;
    public static ItemBase ingotElectrum;
    public static ItemBase ingotBronze;

    public static void init() {
        Constants.LOGGER.info("Loading Ingots...");
        ingotCopper = register(new ItemBase("copper_ingot"));
        ingotTin = register(new ItemBase("tin_ingot"));
        ingotSilver = register(new ItemBase("silver_ingot"));
        ingotLead = register(new ItemBase("lead_ingot"));
        ingotAluminum = register(new ItemBase("aluminum_ingot"));
        ingotNickel = register(new ItemBase("nickel_ingot"));
        ingotPlatinum = register(new ItemBase("platinum_ingot"));
        ingotSteel = register(new ItemBase("steel_ingot"));
        ingotElectrum = register(new ItemBase("electrum_ingot"));
        ingotBronze = register(new ItemBase("bronze_ingot"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

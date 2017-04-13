package terrails.ingotter.init.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.base.ItemBase;
import terrails.ingotter.base.CraftingDurabilityItemBase;

public class ModItems {

    public static CraftingDurabilityItemBase hammerTool;
    public static CraftingDurabilityItemBase wireCutter;

    public static void init() {
        Constants.LOGGER.info("Loading Tools...");
        hammerTool = register(new CraftingDurabilityItemBase("hammer", 128, true));
        wireCutter = register(new CraftingDurabilityItemBase("wire_cutters", 128, ChatFormatting.GREEN + "Work In Progress"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemBase) {
            ((ItemBase)item).registerItemModel();
        }

        return item;
    }
}

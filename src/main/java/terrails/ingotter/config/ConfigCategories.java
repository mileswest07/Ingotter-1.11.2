package terrails.ingotter.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;
import terrails.ingotter.Constants;

import java.util.ArrayList;
import java.util.List;

public class ConfigCategories {

    //General Settings Category
    public static class GeneralSettings extends GuiConfigEntries.CategoryEntry {
        public GeneralSettings(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen, getGeneralElements(), Constants.MODID,
                    true, true, "config/" + Constants.MODID);
        }

        private static List<IConfigElement> getGeneralElements() {

            List<IConfigElement> list = new ArrayList<IConfigElement>();
            List<IConfigElement> RECIPE_SETTINGS = new ConfigElement(ConfigHandler.config.getCategory(ConfigHandler.RECIPES.toLowerCase())).getChildElements();
            List<IConfigElement> FEATURE_SETTINGS = new ConfigElement(ConfigHandler.config.getCategory(ConfigHandler.FEATURES.toLowerCase())).getChildElements();

            list.add(new DummyConfigElement.DummyCategoryElement("Recipes", "config.category.arrowRecipes", RECIPE_SETTINGS));
            list.add(new DummyConfigElement.DummyCategoryElement("Features", "config.category.arrowFeatures", FEATURE_SETTINGS));

            return list;
        }

    }

    //World Generation Category
    public static class WorldGeneration extends GuiConfigEntries.CategoryEntry {
        public WorldGeneration(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen, getGeneralElements(), Constants.MODID,
                    false, false, "config/" + Constants.MODID + "/world");
        }

        private static List<IConfigElement> getGeneralElements() {

            List<IConfigElement> list = new ArrayList<IConfigElement>();
            List<IConfigElement> CUSTOM_SETTINGS = new ConfigElement(ConfigOreHandler.configWorld.getCategory(ConfigOreHandler.WORLD.toLowerCase())).getChildElements();
            List<IConfigElement> INGOTTER_SETTINGS = new ConfigElement(ConfigOreHandler.configIngotter.getCategory(ConfigOreHandler.WORLD_INGOTTER.toLowerCase())).getChildElements();

            list.add(new DummyConfigElement.DummyCategoryElement("Custom Generation", "config.category.arrowCustom", CUSTOM_SETTINGS));
            list.add(new DummyConfigElement.DummyCategoryElement("Ingotter Generation", "config.category.arrowIngotter", INGOTTER_SETTINGS));

            return list;
        }

    }
}

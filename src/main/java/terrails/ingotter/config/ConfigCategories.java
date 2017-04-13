package terrails.ingotter.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ore.ConfigEndHandler;
import terrails.ingotter.config.ore.ConfigNetherHandler;
import terrails.ingotter.config.ore.ConfigOverworldHandler;

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

    public static class OreGenSettings extends GuiConfigEntries.CategoryEntry {

        public OreGenSettings(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(this.owningScreen, getGeneralElements(), Constants.MODID,
                    false, false, "config/" + Constants.MODID);
        }

        private static List<IConfigElement> getGeneralElements() {

            List<IConfigElement> list = new ArrayList<IConfigElement>();
            List<IConfigElement> OVERWORLD_SETTINGS = new ConfigElement(ConfigOreHandler.configWorld.getCategory(ConfigOverworldHandler.OVERWORLD.toLowerCase())).getChildElements();
            List<IConfigElement> NETHER_SETTINGS = new ConfigElement(ConfigOreHandler.configWorld.getCategory(ConfigNetherHandler.NETHER.toLowerCase())).getChildElements();
            List<IConfigElement> END_SETTINGS = new ConfigElement(ConfigOreHandler.configWorld.getCategory(ConfigEndHandler.END.toLowerCase())).getChildElements();


            list.add(new DummyConfigElement.DummyCategoryElement("Oveworld", "config.category.arrowOverworldOreGen", OVERWORLD_SETTINGS));
            list.add(new DummyConfigElement.DummyCategoryElement("Nether", "config.category.arrowNetherOreGen", NETHER_SETTINGS));
            list.add(new DummyConfigElement.DummyCategoryElement("End", "config.category.arrowEndOreGen", END_SETTINGS));
            list.addAll(new ConfigElement(ConfigOreHandler.configWorld.getCategory(ConfigOreHandler.WORLD.toLowerCase())).getChildElements());

            return list;
        }
    }
}

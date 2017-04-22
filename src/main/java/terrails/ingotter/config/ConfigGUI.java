package terrails.ingotter.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import terrails.ingotter.Constants;

import java.util.ArrayList;
import java.util.List;

public class ConfigGUI extends GuiConfig {

    public ConfigGUI(GuiScreen parentScreen)
    {
        super(parentScreen,
                ConfigGUI.getConfigElements(), Constants.MODID,
                false, false, "config/" + Constants.MODID);
    }
    @SuppressWarnings("allDeprecation")
    private static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        list.add(new DummyConfigElement.DummyCategoryElement("General Settings", "config.category.arrowGeneral", ConfigCategories.GeneralSettings.class));
        list.add(new DummyConfigElement.DummyCategoryElement("World Generation", "config.category.arrowWorldGeneration", ConfigCategories.WorldGeneration.class));

        return list;
    }
}

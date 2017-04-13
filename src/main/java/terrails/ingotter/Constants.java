package terrails.ingotter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrails.ingotter.init.ModCreativeTab;

public class Constants {

    public static final String MODID = "ingotter";
    public static final String NAME = "Ingotter";
    public static final String VERSION = "@VERSION@";
    public static final String GUIFACTORY = "terrails.ingotter.config.ConfigFactoryGUI";
    public static final String CLIENT_PROXY = "terrails.ingotter.proxies.ClientProxy";
    public static final String SERVER_PROXY = "terrails.ingotter.proxies.ServerProxy";
    public static final String MCVERSION = "[1.11.2]";
    public static final ModCreativeTab creativeTab = new ModCreativeTab();
    public static final Logger LOGGER = LogManager.getLogger(NAME);
}

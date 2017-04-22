package terrails.ingotter;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import terrails.ingotter.config.ConfigWatch;
import terrails.ingotter.proxies.CommonProxy;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Mod(modid = Constants.MODID,
        name = Constants.NAME,
        version = Constants.VERSION,
        guiFactory = Constants.GUIFACTORY,
        acceptedMinecraftVersions = Constants.MCVERSION)
public class Ingotter {
    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        //Path genCustom = Paths.get(event.getModConfigurationDirectory().toString());
        //System.out.println(genCustom);
        //Path myDir = Paths.get(event.getModConfigurationDirectory().toString());


        // I use "directory\world" because I have an subdirectory in my config folder and I only want to track that directory
        Path myDir = Paths.get(event.getModConfigurationDirectory() + Constants.MODID + File.separator + "world");
        ConfigWatch.testForConfigChange(myDir);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
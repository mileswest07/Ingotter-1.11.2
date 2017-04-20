package terrails.ingotter;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import terrails.ingotter.config.ore.ConfigCustomOreGen;
import terrails.ingotter.proxies.CommonProxy;

import java.io.File;
import java.util.Arrays;

@Mod(modid = Constants.MODID,
        name = Constants.NAME,
        version = Constants.VERSION,
        guiFactory = Constants.GUIFACTORY,
        acceptedMinecraftVersions = Constants.MCVERSION)
public class Ingotter {
    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
       // Block ore = Block.getBlockFromName();
        //    Minecraft.getMinecraft().player.sendMessage(new TextComponentString("THE NAME IS" + ore));
      //  Constants.LOGGER.info("THE NAME IS " + ore);
    }
}
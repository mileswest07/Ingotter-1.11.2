package terrails.ingotter.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.config.ConfigWatch;
import terrails.ingotter.init.FuelHandler;
import terrails.ingotter.init.blocks.ModBlocks;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.init.items.*;
import terrails.ingotter.init.ModOreDictionary;
import terrails.ingotter.init.recipes.ModRecipes;
import terrails.ingotter.init.recipes.ModShapedRecipes;
import terrails.ingotter.init.recipes.ModShapelessRecipes;
import terrails.ingotter.init.recipes.ModSmeltingRecipes;
import terrails.ingotter.worldgen.ore.DefinedBlockDimOreGen;
import terrails.ingotter.worldgen.ore.DefinedBlockOreGen;
import terrails.ingotter.worldgen.ore.DefinedDimOreGen;
import terrails.ingotter.worldgen.ore.NormalOreGen;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonProxy {


    public void preInit(FMLPreInitializationEvent e) {
        ModOres.init();
        ModBlocks.init();
        ModIngots.init();
        ModNuggets.init();
        ModItems.init();
        ModPlates.init();
        ModDusts.init();
        ModWires.init();
        FuelHandler.init();

        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        ConfigHandler.init(e.getModConfigurationDirectory());

        MinecraftForge.EVENT_BUS.register(new ConfigOreHandler());
        ConfigOreHandler.init(e.getModConfigurationDirectory(), e.getModConfigurationDirectory());

        MinecraftForge.ORE_GEN_BUS.register(new NormalOreGen());
        GameRegistry.registerWorldGenerator(new NormalOreGen(), 0);

        MinecraftForge.ORE_GEN_BUS.register(new DefinedDimOreGen());
        GameRegistry.registerWorldGenerator(new DefinedDimOreGen(), 0);

        MinecraftForge.ORE_GEN_BUS.register(new DefinedBlockOreGen());
        GameRegistry.registerWorldGenerator(new DefinedBlockOreGen(), 0);

        MinecraftForge.ORE_GEN_BUS.register(new DefinedBlockDimOreGen());
        GameRegistry.registerWorldGenerator(new DefinedBlockDimOreGen(), 0);
    }

    public void init(FMLInitializationEvent e) {
        ModOreDictionary.registerOreDictionary();
        ModRecipes.init();
        ModShapelessRecipes.init();
        ModShapedRecipes.init();
        ModSmeltingRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}

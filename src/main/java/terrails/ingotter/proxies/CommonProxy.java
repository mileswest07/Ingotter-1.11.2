package terrails.ingotter.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.init.FuelHandler;
import terrails.ingotter.init.blocks.ModBlocks;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.init.items.*;
import terrails.ingotter.init.ModOreDictionary;
import terrails.ingotter.init.recipes.ModRecipes;
import terrails.ingotter.init.recipes.ModShapedRecipes;
import terrails.ingotter.init.recipes.ModShapelessRecipes;
import terrails.ingotter.init.recipes.ModSmeltingRecipes;
import terrails.ingotter.worldgen.ore.EndOreGen;
import terrails.ingotter.worldgen.ore.NetherOreGen;
import terrails.ingotter.worldgen.ore.OverworldOreGen;

public class CommonProxy {


    public void preInit(FMLPreInitializationEvent e) {
        ModOres.init();
        ModBlocks.init();
        ModIngots.init();
        ModNuggets.init();
        ModItems.init();
        ModPlates.init();
        ModDusts.init();
        FuelHandler.init();
        //    ModWires.init();

        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        ConfigHandler.init(e.getModConfigurationDirectory());
        ConfigOreHandler.init(e.getModConfigurationDirectory());

        MinecraftForge.ORE_GEN_BUS.register(new OverworldOreGen());
        MinecraftForge.ORE_GEN_BUS.register(new NetherOreGen());
        MinecraftForge.ORE_GEN_BUS.register(new EndOreGen());

        GameRegistry.registerWorldGenerator(new OverworldOreGen(), 0);
        GameRegistry.registerWorldGenerator(new NetherOreGen(), 0);
        GameRegistry.registerWorldGenerator(new EndOreGen(), 0);
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

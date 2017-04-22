package terrails.ingotter.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.init.blocks.ModBlocks;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.init.items.*;

public class ModOreDictionary {

    public static void registerOreDictionary(){

        //Ores
        if(ConfigOreHandler.oreBoolean){
        add("oreCopper", ModOres.oreCopper);
        add("oreTin", ModOres.oreTin);
        add("oreSilver", ModOres.oreSilver);
        add("oreLead", ModOres.oreLead);
        add("oreAluminum", ModOres.oreAluminum); add("oreAluminium", ModOres.oreAluminum);
        add("oreNickel", ModOres.oreNickel); add("oreFerrous", ModOres.oreNickel);
        add("orePlatinum", ModOres.orePlatinum);
        add("oreSteel", ModOres.oreSteel);
        add("oreElectrum", ModOres.oreElectrum);
        add("oreBronze", ModOres.oreBronze);}

        if(ConfigOreHandler.oreBoolean){
        add("oreCopper", ModOres.oreNetherCopper);
        add("oreTin", ModOres.oreNetherTin);
        add("oreSilver", ModOres.oreNetherSilver);
        add("oreLead", ModOres.oreNetherLead);
        add("oreAluminum", ModOres.oreNetherAluminum); add("oreAluminium", ModOres.oreNetherAluminum);
        add("oreNickel", ModOres.oreNetherNickel); add("oreFerrous", ModOres.oreNetherNickel);
        add("orePlatinum", ModOres.oreNetherPlatinum);
        add("oreSteel", ModOres.oreNetherSteel);
        add("oreElectrum", ModOres.oreNetherElectrum);
        add("oreBronze", ModOres.oreNetherBronze);
        add("oreLapis", ModOres.oreNetherLapis);
        add("oreDiamond", ModOres.oreNetherDiamond);
        add("oreIron", ModOres.oreNetherIron);
        add("oreGold", ModOres.oreNetherGold);
        add("oreRedstone", ModOres.oreNetherRedstone);
        add("oreEmerald", ModOres.oreNetherEmerald);
        add("oreCoal", ModOres.oreNetherCoal);}

        if(ConfigOreHandler.oreBoolean){
        add("oreCopper", ModOres.oreEndCopper);
        add("oreTin", ModOres.oreEndTin);
        add("oreSilver", ModOres.oreEndSilver);
        add("oreLead", ModOres.oreEndLead);
        add("oreAluminum", ModOres.oreEndAluminum); add("oreAluminium", ModOres.oreEndAluminum);
        add("oreNickel", ModOres.oreEndNickel); add("oreFerrous", ModOres.oreEndNickel);
        add("orePlatinum", ModOres.oreEndPlatinum);
        add("oreSteel", ModOres.oreEndSteel);
        add("oreElectrum", ModOres.oreEndElectrum);
        add("oreBronze", ModOres.oreEndBronze);
        add("oreLapis", ModOres.oreEndLapis);
        add("oreDiamond", ModOres.oreEndDiamond);
        add("oreIron", ModOres.oreEndIron);
        add("oreGold", ModOres.oreEndGold);
        add("oreRedstone", ModOres.oreEndRedstone);
        add("oreEmerald", ModOres.oreEndEmerald);
        add("oreCoal", ModOres.oreEndCoal);}

        //Nuggets
        add("nuggetCopper", ModNuggets.nuggetCopper);
        add("nuggetTin", ModNuggets.nuggetTin);
        add("nuggetSilver", ModNuggets.nuggetSilver);
        add("nuggetLead", ModNuggets.nuggetLead);
        add("nuggetAluminum", ModNuggets.nuggetAluminum); add("nuggetAluminium", ModNuggets.nuggetAluminum);
        add("nuggetNickel", ModNuggets.nuggetNickel); add("nuggetFerrous", ModNuggets.nuggetNickel);
        add("nuggetPlatinum", ModNuggets.nuggetPlatinum);
        add("nuggetSteel", ModNuggets.nuggetSteel);
        add("nuggetElectrum", ModNuggets.nuggetElectrum);
        add("nuggetBronze", ModNuggets.nuggetBronze);
        add("nuggetCoal", ModNuggets.nuggetCoal);
        add("nuggetDiamond", ModNuggets.nuggetDiamond);
        add("nuggetEmerald", ModNuggets.nuggetEmerald);
        add("nuggetLapis", ModNuggets.nuggetLapis);

        //Ingots
        add("ingotCopper", ModIngots.ingotCopper);
        add("ingotTin", ModIngots.ingotTin);
        add("ingotSilver", ModIngots.ingotSilver);
        add("ingotLead", ModIngots.ingotLead);
        add("ingotAluminum", ModIngots.ingotAluminum); add("ingotAluminium", ModIngots.ingotAluminum);
        add("ingotNickel", ModIngots.ingotNickel); add("ingotFerrous", ModIngots.ingotNickel);
        add("ingotPlatinum", ModIngots.ingotPlatinum);
        add("ingotSteel", ModIngots.ingotSteel);
        add("ingotElectrum", ModIngots.ingotElectrum);
        add("ingotBronze", ModIngots.ingotBronze);

        //Blocks
        add("blockCopper", ModBlocks.blockCopper);
        add("blockTin", ModBlocks.blockTin);
        add("blockSilver", ModBlocks.blockSilver);
        add("blockLead", ModBlocks.blockLead);
        add("blockAluminum", ModBlocks.blockAluminum); add("blockAluminium", ModBlocks.blockAluminum);
        add("blockNickel", ModBlocks.blockNickel); add("blockFerrous", ModBlocks.blockNickel);
        add("blockPlatinum", ModBlocks.blockPlatinum);
        add("blockSteel", ModBlocks.blockSteel);
        add("blockElectrum", ModBlocks.blockElectrum);
        add("blockBronze", ModBlocks.blockBronze);

        //Dusts
        if(ConfigHandler.dusts){
        add("dustSteel", ModDusts.steelDust);
        add("dustCopper", ModDusts.copperDust);
        add("dustTin", ModDusts.tinDust);
        add("dustSilver", ModDusts.silverDust);
        add("dustLead", ModDusts.leadDust);
        add("dustAluminum", ModDusts.aluminumDust); add("dustAluminium", ModDusts.aluminumDust);
        add("dustNickel", ModDusts.nickelDust); add("dustFerrous", ModDusts.nickelDust);
        add("dustPlatinum", ModDusts.platinumDust);
        add("dustSteel", ModDusts.steelDust);
        add("dustElectrum", ModDusts.electrumDust);
        add("dustBronze", ModDusts.bronzeDust);
        add("dustIron", ModDusts.ironDust);
        add("dustGold", ModDusts.goldDust);
        add("dustCoal", ModDusts.coalDust);
        add("dustDiamond", ModDusts.diamondDust);
        add("dustEmerald", ModDusts.emeraldDust);
        add("dustLapis", ModDusts.lapisDust);}


        //Plate
        if(ConfigHandler.metalPlates){
        add("plateIron", ModPlates.plateIron);
        add("plateGold", ModPlates.plateGold);
        add("plateCopper", ModPlates.plateCopper);
        add("plateTin", ModPlates.plateTin);
        add("plateSilver", ModPlates.plateSilver);
        add("plateLead", ModPlates.plateLead);
        add("plateAluminum", ModPlates.plateAluminum); add("plateAluminium", ModPlates.plateAluminum);
        add("plateNickel", ModPlates.plateNickel); add("plateFerrous", ModPlates.plateNickel);
        add("platePlatinum", ModPlates.platePlatinum);
        add("plateSteel", ModPlates.plateSteel);
        add("plateElectrum", ModPlates.plateElectrum);
        add("plateBronze", ModPlates.plateBronze);
        add("plateCoal", ModPlates.plateCoal);
        add("plateDiamond", ModPlates.plateDiamond);
        add("plateEmerald", ModPlates.plateEmerald);
        add("plateRedstone", ModPlates.plateRedstone);
        add("plateLapis", ModPlates.plateLapis);}
    }

    private static void add(String oreDict, Block block){
        OreDictionary.registerOre(oreDict, block);
    }
    
    private static void add(String oreDict, Item item){
        OreDictionary.registerOre(oreDict, item);
    }

    
    private static void add(String oreDict, ItemStack stack){
        OreDictionary.registerOre(oreDict, stack);
    }
    
}

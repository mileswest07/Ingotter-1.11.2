package terrails.ingotter.init;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import terrails.ingotter.Constants;
import terrails.ingotter.config.ConfigHandler;
import terrails.ingotter.config.ConfigOreHandler;
import terrails.ingotter.config.ore.ConfigEndHandler;
import terrails.ingotter.config.ore.ConfigNetherHandler;
import terrails.ingotter.config.ore.ConfigOverworldHandler;
import terrails.ingotter.init.blocks.ModBlocks;
import terrails.ingotter.init.blocks.ModOres;
import terrails.ingotter.init.items.*;

import java.util.List;

public class ModCreativeTab extends CreativeTabs {

    private NonNullList<ItemStack> list;

    public ModCreativeTab() {
        super(Constants.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModOres.oreCopper);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> list) {
        this.list = list;

        if(ConfigHandler.hammerwire) {
            this.add(ModItems.hammerTool);
            this.add(ModItems.wireCutter);
        }

        if(ConfigOverworldHandler.oreGen && ConfigOreHandler.oreGen) {
            this.add(ModOres.oreCopper);
            this.add(ModOres.oreTin);
            this.add(ModOres.oreSilver);
            this.add(ModOres.oreLead);
            this.add(ModOres.oreAluminum);
            this.add(ModOres.oreNickel);
            this.add(ModOres.orePlatinum);
            this.add(ModOres.oreSteel);
            this.add(ModOres.oreElectrum);
            this.add(ModOres.oreBronze);
        }

        if(ConfigNetherHandler.oreGen && ConfigOreHandler.oreGen) {
            this.add(ModOres.oreNetherCopper);
            this.add(ModOres.oreNetherTin);
            this.add(ModOres.oreNetherSilver);
            this.add(ModOres.oreNetherLead);
            this.add(ModOres.oreNetherAluminum);
            this.add(ModOres.oreNetherNickel);
            this.add(ModOres.oreNetherPlatinum);
            this.add(ModOres.oreNetherSteel);
            this.add(ModOres.oreNetherElectrum);
            this.add(ModOres.oreNetherBronze);
            this.add(ModOres.oreNetherIron);
            this.add(ModOres.oreNetherGold);
            this.add(ModOres.oreNetherDiamond);
            this.add(ModOres.oreNetherLapis);
            this.add(ModOres.oreNetherRedstone);
            this.add(ModOres.oreNetherEmerald);
            this.add(ModOres.oreNetherCoal);
        }

        if(ConfigEndHandler.oreGen && ConfigOreHandler.oreGen) {
            this.add(ModOres.oreEndCopper);
            this.add(ModOres.oreEndTin);
            this.add(ModOres.oreEndSilver);
            this.add(ModOres.oreEndLead);
            this.add(ModOres.oreEndAluminum);
            this.add(ModOres.oreEndNickel);
            this.add(ModOres.oreEndPlatinum);
            this.add(ModOres.oreEndSteel);
            this.add(ModOres.oreEndElectrum);
            this.add(ModOres.oreEndBronze);
            this.add(ModOres.oreEndIron);
            this.add(ModOres.oreEndGold);
            this.add(ModOres.oreEndDiamond);
            this.add(ModOres.oreEndLapis);
            this.add(ModOres.oreEndRedstone);
            this.add(ModOres.oreEndEmerald);
            this.add(ModOres.oreEndCoal);
        }

        this.add(ModBlocks.blockCopper);
        this.add(ModBlocks.blockTin);
        this.add(ModBlocks.blockSilver);
        this.add(ModBlocks.blockLead);
        this.add(ModBlocks.blockAluminum);
        this.add(ModBlocks.blockNickel);
        this.add(ModBlocks.blockPlatinum);
        this.add(ModBlocks.blockSteel);
        this.add(ModBlocks.blockElectrum);
        this.add(ModBlocks.blockBronze);

        this.add(ModIngots.ingotCopper);
        this.add(ModIngots.ingotTin);
        this.add(ModIngots.ingotSilver);
        this.add(ModIngots.ingotLead);
        this.add(ModIngots.ingotAluminum);
        this.add(ModIngots.ingotNickel);
        this.add(ModIngots.ingotPlatinum);
        this.add(ModIngots.ingotSteel);
        this.add(ModIngots.ingotElectrum);
        this.add(ModIngots.ingotBronze);

        if(ConfigHandler.metalPlates) {
            this.add(ModPlates.plateCopper);
            this.add(ModPlates.plateTin);
            this.add(ModPlates.plateSilver);
            this.add(ModPlates.plateLead);
            this.add(ModPlates.plateAluminum);
            this.add(ModPlates.plateNickel);
            this.add(ModPlates.platePlatinum);
            this.add(ModPlates.plateSteel);
            this.add(ModPlates.plateElectrum);
            this.add(ModPlates.plateBronze);
            this.add(ModPlates.plateIron);
            this.add(ModPlates.plateGold);
            this.add(ModPlates.plateCoal);
            this.add(ModPlates.plateDiamond);
            this.add(ModPlates.plateEmerald);
            this.add(ModPlates.plateLapis);
            this.add(ModPlates.plateRedstone);
        }

        if(ConfigHandler.metalWires){
            this.add(ModWires.wireIron);
            this.add(ModWires.wireGold);
            this.add(ModWires.wireCopper);
            this.add(ModWires.wireTin);
            this.add(ModWires.wireSilver);
            this.add(ModWires.wireLead);
            this.add(ModWires.wireAluminum);
            this.add(ModWires.wireNickel);
            this.add(ModWires.wirePlatinum);
            this.add(ModWires.wireSteel);
            this.add(ModWires.wireElectrum);
            this.add(ModWires.wireBronze);
            this.add(ModWires.wireCoal);
            this.add(ModWires.wireDiamond);
            this.add(ModWires.wireEmerald);
            this.add(ModWires.wireLapis);
            this.add(ModWires.wireRedstone);
        }

        this.add(ModNuggets.nuggetCopper);
        this.add(ModNuggets.nuggetTin);
        this.add(ModNuggets.nuggetSilver);
        this.add(ModNuggets.nuggetLead);
        this.add(ModNuggets.nuggetAluminum);
        this.add(ModNuggets.nuggetNickel);
        this.add(ModNuggets.nuggetPlatinum);
        this.add(ModNuggets.nuggetSteel);
        this.add(ModNuggets.nuggetElectrum);
        this.add(ModNuggets.nuggetBronze);
        this.add(ModNuggets.nuggetCoal);
        this.add(ModNuggets.nuggetDiamond);
        this.add(ModNuggets.nuggetEmerald);
        this.add(ModNuggets.nuggetLapis);

        if(ConfigHandler.dusts) {
            this.add(ModDusts.copperDust);
            this.add(ModDusts.tinDust);
            this.add(ModDusts.silverDust);
            this.add(ModDusts.leadDust);
            this.add(ModDusts.aluminumDust);
            this.add(ModDusts.nickelDust);
            this.add(ModDusts.platinumDust);
            this.add(ModDusts.steelDust);
            this.add(ModDusts.electrumDust);
            this.add(ModDusts.bronzeDust);
            this.add(ModDusts.ironDust);
            this.add(ModDusts.goldDust);
            this.add(ModDusts.coalDust);
            this.add(ModDusts.diamondDust);
            this.add(ModDusts.emeraldDust);
            this.add(ModDusts.lapisDust);
        }
    }

    public void add(Item item){
        if(item != null){
            item.getSubItems(item, Constants.creativeTab, this.list);
        }
    }

    public void add(Block block){
        if(block != null){
            block.getSubBlocks(new ItemStack(block).getItem(), Constants.creativeTab, this.list);
        }
    }
}

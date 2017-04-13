package terrails.ingotter.base;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreBase extends BlockBase {


    public BlockOreBase(String name) {
        super(name, Material.ROCK);
    }

    @Override
    public BlockOreBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    public BlockOreBase setHarvestLevel(int level) {
        super.setHarvestLevel("pickaxe", level);
        return this;
    }

    public BlockOreBase setLightLevel(float value) {
        super.setLightLevel(value);
        return this;
    }
}

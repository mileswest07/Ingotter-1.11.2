package terrails.ingotter.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import terrails.ingotter.Constants;
import terrails.ingotter.Ingotter;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setRegistryName(name);
        setUnlocalizedName(Constants.MODID + "." + name);
        setCreativeTab(Constants.creativeTab);
    }
    public void registerItemModel() {
        Ingotter.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}

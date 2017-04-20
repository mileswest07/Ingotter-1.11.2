package terrails.ingotter.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import terrails.ingotter.Constants;
import terrails.ingotter.Ingotter;

public class BlockBase extends Block {

    protected String name;
    protected boolean replaceable;

    public BlockBase(String name, Material material) {
        super(material);
        this.name = name;
        setRegistryName(name);
        setUnlocalizedName(Constants.MODID + "." + name);
        setHardness(3f);
        setResistance(5f);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(Constants.creativeTab);
    }
    public BlockBase(String name) {
        this(name, Material.IRON);
    }
    public BlockBase(String name, Material material, boolean replaceable){
        this(name, material);
        this.replaceable = replaceable;
    }

    public void registerItemModel(ItemBlock itemBlock) {
        Ingotter.proxy.registerItemRenderer(itemBlock, 0, name);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
    public BlockBase setHarvestLevel(int level) {
        super.setHarvestLevel("pickaxe", level);
        return this;
    }
    public boolean isBlockReplaceable(World world, int x, int y, int z)
    {
        return replaceable;
    }
    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return replaceable;
    }


}
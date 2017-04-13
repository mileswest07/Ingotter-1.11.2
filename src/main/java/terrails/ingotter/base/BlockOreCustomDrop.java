package terrails.ingotter.base;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockOreCustomDrop extends BlockOreBase {

    private Item drop;
    private int meta;
    private int least;
    private int max;

    public BlockOreCustomDrop(String name, Item drop, int meta) {
        super(name);
        this.drop = drop;
        this.meta = meta;
    }

    public BlockOreCustomDrop(String name, Item drop) {
        super(name);
        this.drop = drop;
    }

    public BlockOreCustomDrop(String name, Item drop, int meta, int least_quantity, int most_quantity){
        this(name, drop, meta);
        this.least = least_quantity;
        this.max = most_quantity;
    }

    @Override
    public BlockOreCustomDrop setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    public BlockOreCustomDrop setHarvestLevel(int level) {
        super.setHarvestLevel("pickaxe", level);
        return this;
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return drop;
    }

    @Override
    public int damageDropped(IBlockState blockstate) {
        return this.meta;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return ThreadLocalRandom.current().nextInt(quantityDropped(random), fortune + 2);
    //    return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
        if (this.least >= this.max)
            return this.least;
        return this.least + random.nextInt(this.max - this.least + fortune + 1);
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }
}

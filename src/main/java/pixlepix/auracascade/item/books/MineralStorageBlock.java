package pixlepix.auracascade.item.books;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import pixlepix.auracascade.block.tile.TileStorageBookshelf;
import pixlepix.auracascade.item.ItemStorageBook;

import java.util.Arrays;

/**
 * Created by localmacaccount on 1/27/15.
 */
public class MineralStorageBlock extends ItemStorageBook {
    public Block[] blocks = new Block[]{Blocks.lapis_block, Blocks.coal_block, Blocks.diamond_block, Blocks.gold_block, Blocks.iron_block, Blocks.redstone_block, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.gold_ore, Blocks.iron_ore, Blocks.lapis_ore, Blocks.quartz_ore, Blocks.quartz_block, Blocks.redstone_ore};
    public Item[] items = new Item[]{Items.quartz, Items.dye, Items.diamond, Items.gold_ingot, Items.iron_ingot, Items.coal, Items.redstone};
    public String[] ores = new String[]{"ore", "ingot", "dust"};

    @Override
    public int getMaxStackSize() {
        return 100000;
    }

    @Override
    public int getHeldStacks() {
        return 8;
    }

    @Override
    public boolean isItemValid(ItemStack stack, TileStorageBookshelf tileStorageBookshelf) {
        Item item = stack.getItem();
        if (Block.getBlockFromItem(item) != null) {
            Block block = Block.getBlockFromItem(item);
            if (Arrays.asList(blocks).contains(block)) {
                return true;
            }
        }
        if (Arrays.asList(items).contains(item)) {
            return true;
        }
        int[] ids = OreDictionary.getOreIDs(stack);
        for (int i : ids) {
            String s = OreDictionary.getOreName(i);
            if (Arrays.asList(ores).contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getItemName() {
        return "mineralBook";
    }
}

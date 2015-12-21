package org.meelock.collectionofthings.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import org.meelock.collectionofthings.blocks.COTBlocks;
import org.meelock.collectionofthings.ref.NameRef;
import org.meelock.collectionofthings.tileentity.TileEntityPlacedItem;

public class ItemPlaceable extends Item {

	protected ItemPlaceable() {
		super();
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (player.inventory.getCurrentItem().getItem() != this)
			return false;
		ForgeDirection dir = ForgeDirection.VALID_DIRECTIONS[side];
		int ox = x + dir.offsetX, oy = y + dir.offsetY, oz = z + dir.offsetZ;
		world.setBlock(ox, oy, oz,
				COTBlocks.getBlock(NameRef.Blocks.PLACED_ITEM));
		TileEntityPlacedItem tile = (TileEntityPlacedItem) world.getTileEntity(
				ox, oy, oz);
		ItemStack single = player.inventory.decrStackSize(
				player.inventory.currentItem, 1);
		tile.setItem(single);
		world.setBlockMetadataWithNotify(ox, oy, oz, side, 2);
		System.out.println("Placing item on side: " + side);
		return true;
	}
}

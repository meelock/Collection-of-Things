package org.meelock.collectionofthings.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
		world.setBlock(x, y, z, COTBlocks.getBlock(NameRef.Blocks.PLACED_ITEM));
		TileEntityPlacedItem tile = (TileEntityPlacedItem) world.getTileEntity(
				x, y, z);
		ItemStack single = player.inventory.decrStackSize(
				player.inventory.currentItem, 1);
		tile.setItem(single);
		world.setBlockMetadataWithNotify(x, y, z, side, 2);
		return true;
	}
}

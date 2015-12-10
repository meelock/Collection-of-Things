package org.meelock.collectionofthings.tileentity.factory;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.meelock.collectionofthings.tileentity.TileEntityPlacedItem;

public class TileEntityPlacedItemFactory implements TileEntityFactory {

	@Override
	public TileEntity buildTileEntity(World world, int meta) {
		return new TileEntityPlacedItem();
	}

	@Override
	public Class<? extends TileEntity> getTileEntityClass() {
		return TileEntityPlacedItem.class;
	}

}

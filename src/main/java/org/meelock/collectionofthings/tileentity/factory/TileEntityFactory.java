package org.meelock.collectionofthings.tileentity.factory;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public interface TileEntityFactory {
	public abstract TileEntity buildTileEntity(World world, int meta);

	public abstract Class<? extends TileEntity> getTileEntityClass();
}

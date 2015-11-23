package org.meelock.collectionofthings.blocks;

import org.meelock.collectionofthings.ref.NameRef;
import org.meelock.collectionofthings.tileentity.COTTileEntities;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlacedItem extends BlockContainer {

	public BlockPlacedItem(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return COTTileEntities.create(NameRef.TileEntities.PLACED_ITEM, world,
				meta);
	}
}

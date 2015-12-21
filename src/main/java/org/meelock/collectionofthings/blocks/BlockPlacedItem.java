package org.meelock.collectionofthings.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.meelock.collectionofthings.ref.NameRef;
import org.meelock.collectionofthings.tileentity.COTTileEntities;
import org.meelock.collectionofthings.tileentity.TileEntityPlacedItem;

public class BlockPlacedItem extends BlockContainer {

	public BlockPlacedItem(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	public static void setBlockSide(World world, int x, int y, int z, int side) {
		world.setBlockMetadataWithNotify(x, y, z, side % 6, 3);
	}

	public static int getBlockSide(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) % 6;
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlacedItem) {
			return ((TileEntityPlacedItem) te).getItem().getIconIndex();
		}

		return Blocks.glass.getIcon(side, world.getBlockMetadata(x, y, z));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return COTTileEntities.create(NameRef.TileEntities.PLACED_ITEM, world,
				meta);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_,
			int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		return null;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlacedItem) {
			ItemStack stack = ((TileEntityPlacedItem) te).getItem();
			if (stack != null)
				return stack.getItem();
		}
		return Item.getItemById(0);
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPlacedItem) {
			ItemStack stack = ((TileEntityPlacedItem) te).getItem();
			if (stack != null)
				return stack.getItemDamage();
		}
		return 0;
	}
}

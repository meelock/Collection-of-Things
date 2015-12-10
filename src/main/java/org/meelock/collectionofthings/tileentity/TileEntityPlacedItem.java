package org.meelock.collectionofthings.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlacedItem extends TileEntity {
	private ItemStack item;

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}

	@Override
	public void readFromNBT(NBTTagCompound root) {
		super.readFromNBT(root);
		NBTTagCompound itemTag = root.getCompoundTag("Item");
		item = ItemStack.loadItemStackFromNBT(itemTag);
	}

	@Override
	public void writeToNBT(NBTTagCompound root) {
		super.writeToNBT(root);
		NBTTagCompound itemTag = new NBTTagCompound();
		item.writeToNBT(itemTag);
		root.setTag("Item", itemTag);
	}
}

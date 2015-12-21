package org.meelock.collectionofthings.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPlacedItem extends TileEntity {
	private ItemStack item;

	public TileEntityPlacedItem() {
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}

	@Override
	public void readFromNBT(NBTTagCompound root) {
		super.readFromNBT(root);
		readData(root);
	}

	@Override
	public void writeToNBT(NBTTagCompound root) {
		super.writeToNBT(root);
		writeData(root);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound root = new NBTTagCompound();
		writeData(root);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, root);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readData(pkt.func_148857_g());
	}

	private void readData(NBTTagCompound root) {
		NBTTagCompound itemTag = root.getCompoundTag("Item");
		item = ItemStack.loadItemStackFromNBT(itemTag);
	}

	private void writeData(NBTTagCompound root) {
		NBTTagCompound itemTag = new NBTTagCompound();
		item.writeToNBT(itemTag);
		root.setTag("Item", itemTag);
	}

	@Override
	public void invalidate() {
		super.invalidate();
	}

	@Override
	public void validate() {
		super.validate();
	}
}

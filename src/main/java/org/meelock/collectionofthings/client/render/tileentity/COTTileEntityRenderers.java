package org.meelock.collectionofthings.client.render.tileentity;

import org.meelock.collectionofthings.ref.NameRef;
import org.meelock.collectionofthings.tileentity.COTTileEntities;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class COTTileEntityRenderers {
	public static void register() {
		ClientRegistry.bindTileEntitySpecialRenderer(
				COTTileEntities.getTileClass(NameRef.TileEntities.PLACED_ITEM),
				new TileEntityPlacedItemRenderer());
	}
}

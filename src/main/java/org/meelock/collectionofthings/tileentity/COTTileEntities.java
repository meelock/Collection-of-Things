package org.meelock.collectionofthings.tileentity;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.meelock.collectionofthings.tileentity.factory.TileEntityFactory;

import cpw.mods.fml.common.registry.GameRegistry;

public class COTTileEntities {

	public static HashMap<String, TileEntityFactory> factories = new HashMap<String, TileEntityFactory>();

	public static void init() {

	}

	public static void register(TileEntityFactory factory, String name) {
		factories.put(name, factory);
		GameRegistry.registerTileEntity(factory.getTileEntityClass(), name);
	}

	public static TileEntity create(String name, World world, int meta) {
		if (!factories.containsKey(name))
			return null;
		return factories.get(name).buildTileEntity(world, meta);
	}

	public static Class<? extends TileEntity> getTileClass(String name) {
		if (!factories.containsKey(name))
			return null;
		return factories.get(name).getTileEntityClass();
	}
}

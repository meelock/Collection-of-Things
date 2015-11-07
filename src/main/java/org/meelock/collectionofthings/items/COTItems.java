package org.meelock.collectionofthings.items;

import java.util.HashMap;

import net.minecraft.item.Item;

public class COTItems {
	private static final HashMap<String, Item> items = new HashMap<String, Item>();

	public static void init() {

	}

	public static <T extends Item> T addItem(T item, String name) {
		item.setUnlocalizedName(name);
		item.setTextureName(name);
		items.put(name, item);
		return item;
	}

	public static Item getItem(String name) {
		return items.get(name);
	}
}

package org.meelock.collectionofthings.items;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class COTItems {
	private static final HashMap<String, Item> items = new HashMap<String, Item>();
	private static final HashMap<String, String> oreDictMap = new HashMap<String, String>();

	public static void init() {

	}

	public static <T extends Item> T addItem(T item, String name) {
		item.setUnlocalizedName(name);
		item.setTextureName(name);
		items.put(name, item);
		return item;
	}

	public static <T extends Item> T addItem(T item, String name, String oreName) {
		item.setUnlocalizedName(name);
		item.setTextureName(name);
		items.put(name, item);
		oreDictMap.put(name, oreName);
		return item;
	}

	public static void registerOres() {
		Set<Entry<String, Item>> entrySet = items.entrySet();
		for (Entry<String, Item> entry : entrySet) {
			if (oreDictMap.containsKey(entry.getKey()))
				OreDictionary.registerOre(oreDictMap.get(entry.getKey()),
						entry.getValue());
		}
	}

	public static Item getItem(String name) {
		return items.get(name);
	}
}

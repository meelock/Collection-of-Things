package org.meelock.collectionofthings.items;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.meelock.collectionofthings.ref.ModRef;
import org.meelock.collectionofthings.ref.NameRef;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class COTItems {
	private static final HashMap<String, Item> items = new HashMap<String, Item>();
	private static final HashMap<String, String> oreDictMap = new HashMap<String, String>();

	public static void init() {
		addItem(new ItemPlaceable(), NameRef.Items.ACTIVATOR_STONE,
				CreativeTabs.tabMisc);
		addItem(new ItemPlasticBar(), NameRef.Items.PLASTICBAR, CreativeTabs.tabMaterials);
	}

	public static <T extends Item> T addItem(T item, String name,
			CreativeTabs tab) {
		item.setUnlocalizedName(name);
		item.setTextureName(ModRef.MOD_ID + ":" + name);
		item.setCreativeTab(tab);
		items.put(name, item);
		GameRegistry.registerItem(item, name);
		return item;
	}

	public static <T extends Item> T addItem(T item, String name,
			CreativeTabs tab, String oreName) {
		item.setUnlocalizedName(name);
		item.setTextureName(ModRef.MOD_ID + ":" + name);
		item.setCreativeTab(tab);
		items.put(name, item);
		oreDictMap.put(name, oreName);
		GameRegistry.registerItem(item, name);
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

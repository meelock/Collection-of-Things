package org.meelock.collectionofthings.blocks;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.meelock.collectionofthings.cfg.COTConfig;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

public class COTBlocks {
	private static final HashMap<String, Block> blocks = new HashMap<String, Block>();
	private static final HashMap<String, String> oreDictMap = new HashMap<String, String>();

	public static void init() {

	}

	public static <T extends Block> T addBlock(T block, String name) {
		if (!COTConfig.isBlockEnabled(name))
			return block;
		block.setBlockName(name);
		block.setBlockTextureName(name);
		blocks.put(name, block);
		return block;
	}

	public static <T extends Block> T addBlock(T block, String name,
			String oreName) {
		if (!COTConfig.isBlockEnabled(name))
			return block;
		block.setBlockName(name);
		block.setBlockTextureName(name);
		blocks.put(name, block);
		oreDictMap.put(name, oreName);
		return block;
	}

	public static void registerBlocks() {
		Set<Entry<String, Block>> entrySet = blocks.entrySet();
		for (Entry<String, Block> entry : entrySet) {
			GameRegistry.registerBlock(entry.getValue(), entry.getKey());
			if (oreDictMap.containsKey(entry.getKey()))
				OreDictionary.registerOre(oreDictMap.get(entry.getKey()),
						entry.getValue());
		}
	}

	public static Block getBlock(String name) {
		return blocks.get(name);
	}
}

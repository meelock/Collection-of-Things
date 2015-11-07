package org.meelock.collectionofthings.blocks;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class COTBlocks {
	private static final HashMap<String, Block> blocks = new HashMap<String, Block>();

	public static void init() {

	}

	public static <T extends Block> T addBlock(T block, String name) {
		block.setBlockName(name);
		block.setBlockTextureName(name);
		blocks.put(name, block);
		return block;
	}

	public static void registerBlocks() {
		Set<Entry<String, Block>> entrySet = blocks.entrySet();
		for (Entry<String, Block> entry : entrySet) {
			GameRegistry.registerBlock(entry.getValue(), entry.getKey());
		}
	}

	public static Block getBlock(String name) {
		return blocks.get(name);
	}
}

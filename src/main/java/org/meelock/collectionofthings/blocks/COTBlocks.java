package org.meelock.collectionofthings.blocks;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

import org.meelock.collectionofthings.cfg.COTConfig;
import org.meelock.collectionofthings.ref.ModRef;
import org.meelock.collectionofthings.ref.NameRef;

import cpw.mods.fml.common.registry.GameRegistry;

public class COTBlocks {
	private static final HashMap<String, Block> blocks = new HashMap<String, Block>();
	private static final HashMap<String, String> oreDictMap = new HashMap<String, String>();

	public static void init() {
		// not sure this line's purpose
		addBlock(new TestBlock(Material.rock), "ItemLayingOnTheGround", CreativeTabs.tabBlock);
		addBlock(new BlockElectricFence(Material.rock), NameRef.Blocks.ELECTRIC_FENCE, CreativeTabs.tabDecorations);
		addBlock(new BlockPlacedItem(Material.rock), NameRef.Blocks.PLACED_ITEM, null);
	}

	public static <T extends Block> T addBlock(T block, String name, CreativeTabs tab) {
		if (!COTConfig.isBlockEnabled(name))
			return block;
		block.setBlockName(name);
		block.setBlockTextureName(ModRef.MOD_ID + ":" + name);
		block.setCreativeTab(tab);
		blocks.put(name, block);
		return block;
	}

	public static <T extends Block> T addBlock(T block, String name, CreativeTabs tab, String oreName) {
		if (!COTConfig.isBlockEnabled(name))
			return block;
		block.setBlockName(name);
		block.setBlockTextureName(ModRef.MOD_ID + ":" + name);
		block.setCreativeTab(tab);
		blocks.put(name, block);
		oreDictMap.put(name, oreName);
		return block;
	}

	public static void registerBlocks() {
		Set<Entry<String, Block>> entrySet = blocks.entrySet();
		for (Entry<String, Block> entry : entrySet) {
			GameRegistry.registerBlock(entry.getValue(), entry.getKey());
			if (oreDictMap.containsKey(entry.getKey()))
				OreDictionary.registerOre(oreDictMap.get(entry.getKey()), entry.getValue());
		}
	}

	public static Block getBlock(String name) {
		return blocks.get(name);
	}
}

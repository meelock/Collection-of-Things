package org.meelock.collectionofthings.proxy;

import org.meelock.collectionofthings.blocks.COTBlocks;
import org.meelock.collectionofthings.items.COTItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		COTBlocks.init();
		COTItems.init();
	}

	public void init(FMLInitializationEvent event) {
		COTBlocks.registerBlocks();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}

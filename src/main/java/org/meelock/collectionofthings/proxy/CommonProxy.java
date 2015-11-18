package org.meelock.collectionofthings.proxy;

import org.meelock.collectionofthings.blocks.COTBlocks;
import org.meelock.collectionofthings.cfg.COTConfig;
import org.meelock.collectionofthings.items.COTItems;
import org.meelock.collectionofthings.world.gen.WorldgeneratorCoT;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		COTConfig.loadConfig(event.getSuggestedConfigurationFile());
		COTBlocks.init();
		COTItems.init();
		COTConfig.saveConfig();
	}

	public void init(FMLInitializationEvent event) {
		COTBlocks.registerBlocks();
		COTItems.registerOres();
		GameRegistry.registerWorldGenerator(new WorldgeneratorCoT(), 0);
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}

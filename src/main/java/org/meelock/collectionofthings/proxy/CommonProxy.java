package org.meelock.collectionofthings.proxy;

import org.meelock.collectionofthings.blocks.COTBlocks;
import org.meelock.collectionofthings.cfg.COTConfig;
import org.meelock.collectionofthings.items.COTItems;
import org.meelock.collectionofthings.log.COTLog;
import org.meelock.collectionofthings.tileentity.COTTileEntities;
import org.meelock.collectionofthings.world.gen.WorldGeneratorCoT;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		COTLog.init(event.getModLog());
		COTConfig.loadConfig(event.getSuggestedConfigurationFile());
		COTBlocks.init();
		COTItems.init();
		COTTileEntities.init();
		COTConfig.saveConfig();
	}

	public void init(FMLInitializationEvent event) {
		COTBlocks.registerBlocks();
		COTItems.registerOres();
		GameRegistry.registerWorldGenerator(new WorldGeneratorCoT(), 0);
		registerTileEntityRenderers();
	}

	public void registerTileEntityRenderers() {
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}

package org.meelock.collectionofthings;

import org.meelock.collectionofthings.proxy.CommonProxy;
import org.meelock.collectionofthings.ref.CPRef;
import org.meelock.collectionofthings.ref.ModRef;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModRef.MOD_ID)
public class CollectionOfThings {
	@Mod.Instance(ModRef.MOD_ID)
	public static CollectionOfThings instance;

	@SidedProxy(clientSide = CPRef.CLIENT_PROXY, serverSide = CPRef.SERVER_PROXY)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}

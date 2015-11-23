package org.meelock.collectionofthings.proxy;

import org.meelock.collectionofthings.client.render.tileentity.COTTileEntityRenderers;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerTileEntityRenderers() {
		COTTileEntityRenderers.register();
	}

}

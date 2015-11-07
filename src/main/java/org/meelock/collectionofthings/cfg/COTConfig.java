package org.meelock.collectionofthings.cfg;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class COTConfig {
	public static Configuration cfg;

	public static void loadConfig(File file) {
		cfg = new Configuration(file);
	}

	public static boolean isBlockEnabled(String name) {
		return cfg.get("blocksEnabled", name, true).getBoolean();
	}

	public static void saveConfig() {
		cfg.save();
	}
}

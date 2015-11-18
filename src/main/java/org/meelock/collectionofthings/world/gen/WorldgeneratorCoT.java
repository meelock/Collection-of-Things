package org.meelock.collectionofthings.world.gen;

import java.util.Random;

import org.meelock.collectionofthings.blocks.COTBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldgeneratorCoT implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		default:
		}
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		for (int i = 0; i < 1; i++) {
			int x = random.nextInt(16) + blockX;
			int z = random.nextInt(16) + blockZ;
			int y = random.nextInt(40);
			new WorldGenArtifactRuin().generate(world, random, x, 40, z);
		}
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {

	}

}

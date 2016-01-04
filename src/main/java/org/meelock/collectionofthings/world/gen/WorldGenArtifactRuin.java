package org.meelock.collectionofthings.world.gen;

import java.util.Random;

import org.meelock.collectionofthings.world.gen.util.SetblockUtil;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenArtifactRuin extends WorldGenerator {

	// Reference
	// par1World.setBlock(x, y, z, Blocks.someblock);
	@Override
	public boolean generate(World par1World, Random par2Random, int x, int y, int z) {

		SetblockUtil.fillCube(par1World, x, y, z, x + 9, y + 9, z + 9, Blocks.stonebrick, 0, 3);
		SetblockUtil.fill(par1World, x + 1, y + 1, z + 1, x + 8, y + 8, z + 8, Blocks.air, 0, 3);
		par1World.setBlock(x + 1, y + 1, z + 1, Blocks.stone_slab);
		SetblockUtil.fill(par1World, x + 4, y + 8, z + 4, x + 5, y + 8, z + 5, Blocks.glowstone, 0, 3);

		return true;
	}

}

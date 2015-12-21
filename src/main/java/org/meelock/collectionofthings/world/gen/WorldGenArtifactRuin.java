package org.meelock.collectionofthings.world.gen;

import java.util.Random;

import org.meelock.collectionofthings.world.gen.util.SetblockUtil;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenArtifactRuin extends WorldGenerator {

	@Override
	public boolean generate(World par1World, Random par2Random, int x, int y, int z) {

		// Reference
		// par1World.setBlock(par3, par4, par5, Blocks.stonebrick);
		SetblockUtil.fill(par1World, x, y, z, x + 9, y, z + 9, Blocks.stonebrick, 0, 3);
		SetblockUtil.fill(par1World, x, y, z, x + 9, y + 9, z, Blocks.stonebrick, 0, 3);
		SetblockUtil.fill(par1World, x + 1, y + 1, z + 1, x + 7, y + 7, z + 7, Blocks.air, 0, 3);

		return true;
	}

}

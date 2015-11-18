package org.meelock.collectionofthings.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenArtifactRuin extends WorldGenerator {

	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
		
 // layer 1
		par1World.setBlock(par3, par4, par5, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4, par5, Blocks.stonebrick);
		par1World.setBlock(par3 - 2, par4, par5, Blocks.stonebrick);
		par1World.setBlock(par3, par4, par5 - 1, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4, par5 - 1, Blocks.stonebrick);
		par1World.setBlock(par3 - 2, par4, par5 - 1, Blocks.stonebrick);
		par1World.setBlock(par3, par4, par5 - 2, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4, par5 - 2, Blocks.stonebrick);
		par1World.setBlock(par3 - 2, par4, par5 - 2, Blocks.stonebrick);
 // layer 2
		par1World.setBlock(par3, par4 + 1, par5, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4 + 1, par5, Blocks.stonebrick);
		par1World.setBlock(par3 - 2, par4 + 1, par5, Blocks.stonebrick);
		par1World.setBlock(par3, par4 + 1, par5 - 1, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4 + 1, par5 - 1, Blocks.air);
		par1World.setBlock(par3 - 2, par4 + 1, par5 - 1, Blocks.stonebrick);
		par1World.setBlock(par3, par4 + 1, par5 - 2, Blocks.stonebrick);
		par1World.setBlock(par3 - 1, par4 + 1, par5 - 2, Blocks.stonebrick);
		par1World.setBlock(par3 - 2, par4 + 1, par5 - 2, Blocks.stonebrick);
		System.out.println("generated test structure");
		return true;
	}

}

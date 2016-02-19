package org.meelock.collectionofthings.blocks;

import org.meelock.collectionofthings.ref.ModRef;
import org.meelock.collectionofthings.ref.NameRef;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockElectricFence extends BlockFence {

	public BlockElectricFence(Material mat) {
		super(ModRef.MOD_ID + ":" + NameRef.Blocks.ELECTRIC_FENCE, mat);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {

		entity.attackEntityFrom(DamageSource.onFire, 1f);

	}

}

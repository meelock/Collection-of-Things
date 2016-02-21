package org.meelock.collectionofthings.blocks;

import org.meelock.collectionofthings.ref.ModRef;
import org.meelock.collectionofthings.ref.NameRef;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockLaserFence extends BlockFence {

	public BlockLaserFence(Material mat) {
		super(ModRef.MOD_ID + ":" + NameRef.Blocks.LASER_FENCE, mat);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if(!(entity instanceof EntityItem)){
		entity.attackEntityFrom(DamageSource.onFire, 5f);
		
		/**
		 * unimplemented destruction of flamable items
		 */
		}//else if(GameRegistry.getFuelValue(((EntityItem)entity).getEntityItem()) > 0){
//			entity.attackEntityFrom(DamageSource.onFire, 5f);
//		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		return null;
	}

}

package org.meelock.collectionofthings.world.gen.util;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class SetblockUtil {
	public static void fill(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block, int metadata,
			int notify) {
		for (int x = x1; x1 < x2 ? x <= x2 : x >= x2; x += x1 < x2 ? 1 : -1) {
			for (int y = y1; y1 < y2 ? y <= y2 : y >= y2; y += y1 < y2 ? 1 : -1) {
				for (int z = z1; z1 < z2 ? z <= z2 : z >= z2; z += z1 < z2 ? 1 : -1) {
					world.setBlock(x, y, z, block, metadata, notify);
					}
				
				}
		
			}

		}
		public static void fillCube(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block, int metadata,
				int notify) {
				

						SetblockUtil.fill(world, x1, y1, z1, x2, y1, z2, block, metadata, notify);
						SetblockUtil.fill(world, x1, y1, z1, x2, y2, z1, block, metadata, notify);
						SetblockUtil.fill(world, x1, y1, z1, x1, y2, z2, block, metadata, notify);
						SetblockUtil.fill(world, x1, y1, z2, x2, y2, z2, block, metadata, notify);
						SetblockUtil.fill(world, x2, y1, z1, x2, y2, z2, block, metadata, notify);
						SetblockUtil.fill(world, x1, y2, z1, x2, y2, z2, block, metadata, notify);
						
						
						

			}
	}

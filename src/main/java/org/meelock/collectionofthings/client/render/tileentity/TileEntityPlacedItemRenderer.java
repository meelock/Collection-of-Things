package org.meelock.collectionofthings.client.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.meelock.collectionofthings.blocks.BlockPlacedItem;
import org.meelock.collectionofthings.tileentity.TileEntityPlacedItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityPlacedItemRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float frame) {
		if (!(tile instanceof TileEntityPlacedItem))
			return;

		TileEntityPlacedItem placed = (TileEntityPlacedItem) tile;

		ItemStack itemstack = placed.getItem();

		if (itemstack != null) {
			int ix = (int) x, iy = (int) y, iz = (int) z;

			World world = placed.getWorldObj();

			int side = BlockPlacedItem.getBlockSide(world, ix, iy, iz);
			ForgeDirection direct = ForgeDirection.VALID_DIRECTIONS[side];

			EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D,
					itemstack);
			Item item = entityitem.getEntityItem().getItem();
			entityitem.getEntityItem().stackSize = 1;
			entityitem.hoverStart = 0.0F;
			GL11.glPushMatrix();

			// old render translation code
			// GL11.glTranslatef(-0.453125F * (float) direct.offsetX, -0.453125F
			// * (float) direct.offsetY, -0.453125F
			// * (float) direct.offsetZ);
			// GL11.glRotatef(180.0F + p_82402_1_.rotationYaw, 0.0F, 1.0F,
			// 0.0F);
			// GL11.glRotatef((float) (-90 * p_82402_1_.getRotation()), 0.0F,
			// 0.0F, 1.0F);
			//
			// switch (p_82402_1_.getRotation()) {
			// case 1:
			// GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
			// break;
			// case 2:
			// GL11.glTranslatef(0.0F, -0.32F, 0.0F);
			// break;
			// case 3:
			// GL11.glTranslatef(0.16F, -0.16F, 0.0F);
			// }

			GL11.glTranslated(x + 0.5d, y + 0.5d, z + 0.5d);
			
//			System.out.println("I am rendering! " + direct);

			switch (direct) {
			case DOWN:
				GL11.glTranslatef(0f, -0.5f + (1f / 16f), 0f);
				GL11.glRotatef(90f, 1f, 0f, 0f);
				break;
			case UP:
				break;
			case NORTH:
				break;
			case SOUTH:
				break;
			case WEST:
				break;
			case EAST:
				break;
			default:
				break;
			}

			// TODO add render placed item event
			// net.minecraftforge.client.event.RenderItemInFrameEvent event =
			// new net.minecraftforge.client.event.RenderItemInFrameEvent(
			// p_82402_1_, this);
			// if
			// (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
			// {
			// if (item == Items.filled_map) {
			// this.renderManager.renderEngine
			// .bindTexture(mapBackgroundTextures);
			// Tessellator tessellator = Tessellator.instance;
			// GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			// GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			// float f = 0.0078125F;
			// GL11.glScalef(f, f, f);
			//
			// switch (p_82402_1_.getRotation()) {
			// case 0:
			// GL11.glTranslatef(-64.0F, -87.0F, -1.5F);
			// break;
			// case 1:
			// GL11.glTranslatef(-66.5F, -84.5F, -1.5F);
			// break;
			// case 2:
			// GL11.glTranslatef(-64.0F, -82.0F, -1.5F);
			// break;
			// case 3:
			// GL11.glTranslatef(-61.5F, -84.5F, -1.5F);
			// }
			//
			// GL11.glNormal3f(0.0F, 0.0F, -1.0F);
			// MapData mapdata = Items.filled_map.getMapData(
			// entityitem.getEntityItem(), p_82402_1_.worldObj);
			// GL11.glTranslatef(0.0F, 0.0F, -1.0F);
			//
			// if (mapdata != null) {
			// this.field_147917_g.entityRenderer.getMapItemRenderer()
			// .func_148250_a(mapdata, true);
			// }
			// } else {
			if (item == Items.compass) {
				TextureManager texturemanager = Minecraft.getMinecraft()
						.getTextureManager();
				texturemanager.bindTexture(TextureMap.locationItemsTexture);
				TextureAtlasSprite textureatlassprite1 = ((TextureMap) texturemanager
						.getTexture(TextureMap.locationItemsTexture))
						.getAtlasSprite(Items.compass.getIconIndex(
								entityitem.getEntityItem()).getIconName());

				if (textureatlassprite1 instanceof TextureCompass) {
					TextureCompass texturecompass = (TextureCompass) textureatlassprite1;
					double d0 = texturecompass.currentAngle;
					double d1 = texturecompass.angleDelta;
					texturecompass.currentAngle = 0.0D;
					texturecompass.angleDelta = 0.0D;
					texturecompass
							.updateCompass(
									placed.getWorldObj(),
									x,
									z,
									side < 2 ? 0
											: ((double) MathHelper
													.wrapAngleTo180_float((float) (180 + side * 90))),
									false, true);
					texturecompass.currentAngle = d0;
					texturecompass.angleDelta = d1;
				}
			}

			RenderItem.renderInFrame = true;
			RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D,
					0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;

			if (item == Items.compass) {
				TextureAtlasSprite textureatlassprite = ((TextureMap) Minecraft
						.getMinecraft().getTextureManager()
						.getTexture(TextureMap.locationItemsTexture))
						.getAtlasSprite(Items.compass.getIconIndex(
								entityitem.getEntityItem()).getIconName());

				if (textureatlassprite.getFrameCount() > 0) {
					textureatlassprite.updateAnimation();
				}
			}
			// }
			// }

			GL11.glPopMatrix();
		}
	}

}

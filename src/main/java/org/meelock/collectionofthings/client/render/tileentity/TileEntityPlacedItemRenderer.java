package org.meelock.collectionofthings.client.render.tileentity;

import org.lwjgl.opengl.GL11;
import org.meelock.collectionofthings.blocks.BlockPlacedItem;
import org.meelock.collectionofthings.log.COTLog;
import org.meelock.collectionofthings.tileentity.TileEntityPlacedItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

@SideOnly(Side.CLIENT)
public class TileEntityPlacedItemRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float frame) {
		if (!(tile instanceof TileEntityPlacedItem))
			return;

		TileEntityPlacedItem placed = (TileEntityPlacedItem) tile;

		ItemStack itemstack = placed.getItem();

		if (itemstack != null) {
			int bx = placed.xCoord, by = placed.yCoord, bz = placed.zCoord;

			World world = placed.getWorldObj();

			int side = BlockPlacedItem.getBlockSide(world, bx, by, bz);
			// COTLog.info("pos: x: " + bx + ", y: " + by + ", z: " + bz);
			// COTLog.info("Side rendering: " + side);
			ForgeDirection direct = ForgeDirection.VALID_DIRECTIONS[side];

			EntityItem entityitem = new EntityItem(world, 0.0D, 0.0D, 0.0D, itemstack);
			Item item = entityitem.getEntityItem().getItem();
			entityitem.getEntityItem().stackSize = 1;
			entityitem.age = 0;
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

			GL11.glTranslated(x, y, z);
			// System.out.println("I am rendering! " + direct);

			GL11.glTranslatef(0.5f, 0.5f, 0.5f);
			switch (direct) {
			case DOWN:
				GL11.glRotatef(270f, 1f, 0f, 0f);
				break;
			case UP:
				GL11.glRotatef(90f, 1f, 0f, 0f);
				break;
			case NORTH:
				// nothing to do here
				break;
			case SOUTH:
				GL11.glRotatef(180f, 0f, 1f, 0f);
				break;
			case WEST:
				GL11.glRotatef(90f, 0f, 1f, 0f);
				break;
			case EAST:
				GL11.glRotatef(270f, 0f, 1f, 0f);
				break;
			default:
				break;
			}
			GL11.glTranslatef(-0.5f, -0.5f, -0.5f);

			// float f9 = 0.0625F;
			// float f10 = 0.021875F;
			// int b0 = 1;
			GL11.glTranslatef(0.5f, 0f, 0f);
			GL11.glRotatef(180f, 0f, 1f, 0f);
			GL11.glTranslatef(-0.5f, 0f, 0f);
			GL11.glTranslatef(0.5f, 0.05f, -0.0421875f);
			// COTLog.info("Z offset:" + (((f9 + f10) * (float) b0 / 2.0F) - (f9
			// + f10)));
			GL11.glScalef(2f, 2f, 2f);

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
				TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
				texturemanager.bindTexture(TextureMap.locationItemsTexture);
				TextureAtlasSprite textureatlassprite1 = ((TextureMap) texturemanager
						.getTexture(TextureMap.locationItemsTexture))
								.getAtlasSprite(Items.compass.getIconIndex(entityitem.getEntityItem()).getIconName());

				if (textureatlassprite1 instanceof TextureCompass) {
					TextureCompass texturecompass = (TextureCompass) textureatlassprite1;
					double d0 = texturecompass.currentAngle;
					double d1 = texturecompass.angleDelta;
					texturecompass.currentAngle = 0.0D;
					texturecompass.angleDelta = 0.0D;
					texturecompass.updateCompass(placed.getWorldObj(), bx, bz,
							side < 2 ? 0 : ((double) MathHelper.wrapAngleTo180_float((float) (180 + side * 90))), false,
							true);
					texturecompass.currentAngle = d0;
					texturecompass.angleDelta = d1;
				}
			}

			// RenderItem.renderInFrame = true;
			RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			// RenderItem.renderInFrame = false;

			if (item == Items.compass) {
				TextureAtlasSprite textureatlassprite = ((TextureMap) Minecraft.getMinecraft().getTextureManager()
						.getTexture(TextureMap.locationItemsTexture))
								.getAtlasSprite(Items.compass.getIconIndex(entityitem.getEntityItem()).getIconName());

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

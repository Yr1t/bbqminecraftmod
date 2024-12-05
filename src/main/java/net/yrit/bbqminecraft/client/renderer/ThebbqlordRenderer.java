
package net.yrit.bbqminecraft.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.yrit.bbqminecraft.entity.model.ThebbqlordModel;
import net.yrit.bbqminecraft.entity.ThebbqlordEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ThebbqlordRenderer extends GeoEntityRenderer<ThebbqlordEntity> {
	public ThebbqlordRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ThebbqlordModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(ThebbqlordEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ThebbqlordEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 4f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(ThebbqlordEntity entityLivingBaseIn) {
		return 0.0F;
	}
}

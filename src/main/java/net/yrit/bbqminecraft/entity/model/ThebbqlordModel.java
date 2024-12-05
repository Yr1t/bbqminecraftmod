package net.yrit.bbqminecraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.yrit.bbqminecraft.entity.ThebbqlordEntity;

import net.minecraft.resources.ResourceLocation;

public class ThebbqlordModel extends GeoModel<ThebbqlordEntity> {
	@Override
	public ResourceLocation getAnimationResource(ThebbqlordEntity entity) {
		return new ResourceLocation("bbq_minecraft", "animations/lordbbq.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ThebbqlordEntity entity) {
		return new ResourceLocation("bbq_minecraft", "geo/lordbbq.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ThebbqlordEntity entity) {
		return new ResourceLocation("bbq_minecraft", "textures/entities/" + entity.getTexture() + ".png");
	}

}

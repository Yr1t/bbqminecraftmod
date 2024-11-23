
package net.yrit.bbqminecraft.item;

import net.yrit.bbqminecraft.procedures.BBQSauceGiveEffectProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BBQSauceItem extends Item {
	public BBQSauceItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(3).saturationMod(3f).alwaysEat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Delicious BBQ Sauce. Gives you extra might when you need it."));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		BBQSauceGiveEffectProcedure.execute(entity);
		return retval;
	}
}

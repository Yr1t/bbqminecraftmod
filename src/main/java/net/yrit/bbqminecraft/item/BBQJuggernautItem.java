
package net.yrit.bbqminecraft.item;

import net.yrit.bbqminecraft.procedures.BBQJuggernautSpecialInformationProcedure;
import net.yrit.bbqminecraft.procedures.BBQJuggernautBallAttackProcedure;
import net.yrit.bbqminecraft.init.BbqMinecraftModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BBQJuggernautItem extends SwordItem {
	public BBQJuggernautItem() {
		super(new Tier() {
			public int getUses() {
				return 42069;
			}

			public float getSpeed() {
				return 13f;
			}

			public float getAttackDamageBonus() {
				return 23f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(BbqMinecraftModItems.BBQ_ESSENCE.get()), new ItemStack(BbqMinecraftModItems.BBQ_INGOT.get()), new ItemStack(BbqMinecraftModItems.BBQ_SAUCE.get()));
			}
		}, 3, -2.4f, new Item.Properties().fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BBQJuggernautBallAttackProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		double x = entity != null ? entity.getX() : 0.0;
		double y = entity != null ? entity.getY() : 0.0;
		double z = entity != null ? entity.getZ() : 0.0;
		list.add(Component.literal(BBQJuggernautSpecialInformationProcedure.execute(itemstack)));
	}
}

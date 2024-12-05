
package net.yrit.bbqminecraft.item;

import net.yrit.bbqminecraft.procedures.LordBBQSummonRightclickedOnBlockProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import java.util.List;

public class LordBBQSummonItem extends Item {
	public LordBBQSummonItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A74Be extremely prepared."));
		list.add(Component.literal("\u00A78Only usable in the Nether."));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		LordBBQSummonRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}

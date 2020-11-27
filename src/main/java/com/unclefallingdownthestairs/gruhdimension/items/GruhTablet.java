package com.unclefallingdownthestairs.gruhdimension.items;

import com.unclefallingdownthestairs.gruhdimension.components.GruhComponents;
import com.unclefallingdownthestairs.gruhdimension.components.LocCountComponent;
import com.unclefallingdownthestairs.gruhdimension.components.ReturnLocComponent;
import com.unclefallingdownthestairs.gruhdimension.dimension.GruhDimUtil;
import com.unclefallingdownthestairs.gruhdimension.registry.GruhDim;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class GruhTablet extends Item {

    public GruhTablet(Settings settings) {
        super(settings);
    }

    public boolean isInitialized(CompoundTag tag) {
        return tag.contains("target");
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.consume(stack);
        } else {
            CompoundTag tag = stack.getOrCreateTag();
            LocCountComponent count = LocCountComponent.get(world);
            ReturnLocComponent returnLoc = ReturnLocComponent.get(user);
            if (user.getEntityWorld().getRegistryKey() == GruhDim.GRUH_WORLD_KEY) {
                // if we're already in the gruh dimension then teleport out
                ServerWorld destWorld = user.getServer().getWorld(returnLoc.getWorldKey());
                Vec3d destination = returnLoc.getPos();
                ((ServerPlayerEntity)user).teleport(destWorld, destination.x, destination.y, destination.z, user.yaw, user.pitch);
            } else if (isInitialized(tag)) {
                // if we're not in the gruh dimension but it is initialized
                // set player return location
                returnLoc.setReturnPos();
                // teleport to location
                ServerWorld gruhWorld = user.getServer().getWorld(GruhDim.GRUH_WORLD_KEY);
                Vec3d teleportLocation = GruhDimUtil.teleportPos(tag.getInt("target"));
                ((ServerPlayerEntity)user).teleport(gruhWorld, teleportLocation.x, teleportLocation.y, teleportLocation.z, user.yaw, user.pitch);
                // GruhDimUtil.SetReturnBlock(gruhWorld, teleportLocation);
            } else {
                // initialize target
                // create new item
                ItemStack copy = stack.copy();
                copy.setCount(1);
                copy.getOrCreateTag().putInt("target", count.getValue());
                // increase our total locations count
                count.increaseCount();
                // remove one item from the stack
                stack.decrement(1);
                user.giveItemStack(copy);
//                if (stack.isEmpty()) {
//                    return TypedActionResult.consume(copy);
//                } else {
//                    if (user.getStackInHand(hand))
//                    return TypedActionResult.consume(stack);
//                }
                return TypedActionResult.consume(user.getStackInHand(hand));
            }

            return TypedActionResult.success(stack);

        }
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains("target")) {
            tooltip.add(new LiteralText("Tuned to frequency " + (float)Math.abs(Math.sin(tag.getInt("target") * 100) * 100)));
        }
    }
}

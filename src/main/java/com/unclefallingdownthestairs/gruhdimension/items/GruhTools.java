package com.unclefallingdownthestairs.gruhdimension.items;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import com.unclefallingdownthestairs.gruhdimension.registry.GruhItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;

public class GruhTools {

    private static final float FUNNY_CHANCE = .1f;

    private static class GruhToolMaterial implements ToolMaterial {

        private final static Ingredient GRUH_INGREDIENT = Ingredient.ofItems(GruhItems.GRUH_FABRIC);

        @Override
        public int getDurability() { return 250; }

        @Override
        public float getMiningSpeedMultiplier() { return 4.0f; }

        @Override
        public float getAttackDamage() { return 1.0f; }

        @Override
        public int getMiningLevel() { return 4; }

        @Override
        public int getEnchantability() { return 0; }

        @Override
        public Ingredient getRepairIngredient() { return GRUH_INGREDIENT; }

    }

    private static class GruhSwordItem extends SwordItem {
        public GruhSwordItem(Settings settings) {
            super(GRUH_TOOL_MATERIAL, 3, -2.4f, settings);
        }

        @Override
        public void onCraft(ItemStack stack, World world, PlayerEntity player) {
            super.onCraft(stack, world, player);
            if (!IsFunnyEnchanted()) return;
            stack.addEnchantment(Enchantments.UNBREAKING, 7);
            stack.addEnchantment(Enchantments.SHARPNESS, 7);
            stack.addEnchantment(Enchantments.LOOTING, 5);
        }
    }

    private static class GruhShovelItem extends ShovelItem {
        public GruhShovelItem(Settings settings) {
            super(GRUH_TOOL_MATERIAL, 1.5f, -3.0f, settings);
        }

        @Override
        public void onCraft(ItemStack stack, World world, PlayerEntity player) {
            super.onCraft(stack, world, player);
            if (!IsFunnyEnchanted()) return;
            stack.addEnchantment(Enchantments.UNBREAKING, 7);
            stack.addEnchantment(Enchantments.EFFICIENCY, 7);
        }
    }

    private static class GruhPickaxeItem extends PickaxeItem {
        public GruhPickaxeItem(Settings settings) {
            super(GruhTools.GRUH_TOOL_MATERIAL, 1, -2.8f, settings);
        }

        @Override
        public void onCraft(ItemStack stack, World world, PlayerEntity player) {
            super.onCraft(stack, world, player);
            if (!IsFunnyEnchanted()) return;
            stack.addEnchantment(Enchantments.UNBREAKING, 7);
            stack.addEnchantment(Enchantments.EFFICIENCY, 7);
            stack.addEnchantment(Enchantments.FORTUNE, 5);
        }
    }

    private static class GruhAxeItem extends AxeItem {
        public GruhAxeItem(Settings settings) {
            super(GruhTools.GRUH_TOOL_MATERIAL, 5, -3.0f, settings);
        }

        @Override
        public void onCraft(ItemStack stack, World world, PlayerEntity player) {
            super.onCraft(stack, world, player);
            if (!IsFunnyEnchanted()) return;
            stack.addEnchantment(Enchantments.UNBREAKING, 7);
            stack.addEnchantment(Enchantments.EFFICIENCY, 7);
        }
    }

    private static class GruhHoeItem extends HoeItem {
        public GruhHoeItem(Settings settings) {
            super(GruhTools.GRUH_TOOL_MATERIAL, -1, 0, settings);
        }

        @Override
        public void onCraft(ItemStack stack, World world, PlayerEntity player) {
            super.onCraft(stack, world, player);
            if (!IsFunnyEnchanted()) return;
            stack.addEnchantment(Enchantments.UNBREAKING, 7);
        }
    }

    private static final GruhToolMaterial GRUH_TOOL_MATERIAL = new GruhToolMaterial();

    public static final Item GRUH_SWORD = new GruhSwordItem(new FabricItemSettings());
    public static final Item GRUH_SHOVEL = new GruhShovelItem(new FabricItemSettings());
    public static final Item GRUH_PICKAXE = new GruhPickaxeItem(new FabricItemSettings());
    public static final Item GRUH_AXE = new GruhAxeItem(new FabricItemSettings());
    public static final Item GRUH_HOE = new GruhHoeItem(new FabricItemSettings());

    private static final Random rand = new Random();

    private static boolean IsFunnyEnchanted() {
        return rand.nextFloat() < FUNNY_CHANCE;
    }

    public static void RegisterTools() {
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_sword"), GRUH_SWORD);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_shovel"), GRUH_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_pickaxe"), GRUH_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_axe"), GRUH_AXE);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_hoe"), GRUH_HOE);
    }
}

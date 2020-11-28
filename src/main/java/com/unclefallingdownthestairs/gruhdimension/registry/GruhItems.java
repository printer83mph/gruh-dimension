package com.unclefallingdownthestairs.gruhdimension.registry;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import com.unclefallingdownthestairs.gruhdimension.items.GruhTablet;
import com.unclefallingdownthestairs.gruhdimension.items.GruhTools;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GruhItems {

    public static final Item GRUH_TOKEN = new Item(new FabricItemSettings());
    public static final Item GRUH_TABLET = new GruhTablet(new FabricItemSettings());

    // todo: implement cheap gruh tablet to return to overworld

    public static final Item GRUH_FABRIC = new BlockItem(GruhBlocks.GRUH_FABRIC, new FabricItemSettings());

    public static final ItemGroup GRUH_GROUP = FabricItemGroupBuilder.create(
            new Identifier("gruhdimension", "items"))
            .icon(() -> new ItemStack(GRUH_TOKEN))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(GRUH_TOKEN));
                itemStacks.add(new ItemStack(GRUH_TABLET));
                itemStacks.add(new ItemStack(GRUH_FABRIC));
                itemStacks.add(new ItemStack(GruhTools.GRUH_SWORD));
                itemStacks.add(new ItemStack(GruhTools.GRUH_SHOVEL));
                itemStacks.add(new ItemStack(GruhTools.GRUH_PICKAXE));
                itemStacks.add(new ItemStack(GruhTools.GRUH_AXE));
                itemStacks.add(new ItemStack(GruhTools.GRUH_HOE));
            })
            .build();

    public static void RegisterItems() {
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_token"), GRUH_TOKEN);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_tablet"), GRUH_TABLET);
        Registry.register(Registry.ITEM, new Identifier(GruhDimension.MOD_ID, "gruh_fabric"), GRUH_FABRIC);

        GruhTools.RegisterTools();
    }

}



package com.unclefallingdownthestairs.gruhdimension.registry;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import com.unclefallingdownthestairs.gruhdimension.blocks.GruhFabric;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GruhBlocks {

    public static final Block GRUH_FABRIC = new GruhFabric();

    public static void RegisterBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(GruhDimension.MOD_ID, "gruh_fabric"), GRUH_FABRIC);
    }

}

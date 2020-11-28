package com.unclefallingdownthestairs.gruhdimension.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class GruhFabric extends Block {

    public GruhFabric() {
        super(FabricBlockSettings.of(Material.WOOL).hardness(0.3f).sounds(BlockSoundGroup.WOOL));
    }

}

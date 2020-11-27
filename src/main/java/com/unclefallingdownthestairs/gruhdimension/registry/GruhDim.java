package com.unclefallingdownthestairs.gruhdimension.registry;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class GruhDim {
    public static final RegistryKey<World> GRUH_WORLD_KEY = RegistryKey.of(Registry.DIMENSION, GruhDimension.MOD_DIMENSION_ID);
}

package com.unclefallingdownthestairs.gruhdimension.components;

import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public interface LocComponent extends PlayerComponent {

    Vec3d getPos();
    World getWorld();
    RegistryKey<World> getWorldKey();

}

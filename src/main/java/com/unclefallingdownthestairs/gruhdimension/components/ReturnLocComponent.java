package com.unclefallingdownthestairs.gruhdimension.components;

import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class ReturnLocComponent implements LocComponent, PlayerComponent {

    public ReturnLocComponent(PlayerEntity user) {
        this.user = user;
    }

    private RegistryKey<World> world;
    private Vec3d pos;

    public static PlayerEntity user;

    public static ReturnLocComponent get(PlayerEntity user) {
        return (ReturnLocComponent) GruhComponents.RETURN_LOC.get(user);
    }

    public void setReturnPos() {
        pos = new Vec3d(user.getX(), user.getY(), user.getZ());
        world = user.getEntityWorld().getRegistryKey();
    }

    @Override
    public void readFromNbt(CompoundTag compoundTag) {
        String worldString = compoundTag.getString("world");
        if (worldString != null) this.world = RegistryKey.of(Registry.DIMENSION, new Identifier(worldString));
        int[] pos = compoundTag.getIntArray("position");
        if (pos != null) this.pos = new Vec3d(pos[0], pos[1], pos[2]);
    }

    @Override
    public void writeToNbt(CompoundTag compoundTag) {
        if (world != null) compoundTag.putString("world", world.getValue().toString());
        if (pos != null) compoundTag.putIntArray("position", new int[]{(int)pos.x, (int)pos.y, (int)pos.z});
    }

    @Override
    public Vec3d getPos() {
        return pos;
    }

    @Override
    public World getWorld() {
        return user.getServer().getWorld(this.world);
    }

    @Override
    public RegistryKey<World> getWorldKey() {
        return world;
    }
}
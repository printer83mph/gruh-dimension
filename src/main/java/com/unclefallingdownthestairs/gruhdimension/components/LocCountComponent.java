package com.unclefallingdownthestairs.gruhdimension.components;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class LocCountComponent implements IntComponent {

    private int count = 0;

    public static LocCountComponent get(World world) {
        return (LocCountComponent) GruhComponents.LOC_COUNT.get(world);
    }

    @Override
    public int getValue() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public void readFromNbt(CompoundTag compoundTag) {
        this.count = compoundTag.getInt("count");
    }

    @Override
    public void writeToNbt(CompoundTag compoundTag) {
        compoundTag.putInt("count", this.count);
    }
}

package com.unclefallingdownthestairs.gruhdimension.components;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class LocCountComponent implements IntListComponent {

    private static Random rand = new Random();
    private ArrayList<Integer> existingIds;

    public static LocCountComponent get(World world) {
        return (LocCountComponent) GruhComponents.LOC_COUNT.get(world);
    }

    @Override
    public ArrayList<Integer> getValue() {
        return existingIds;
    }

    public int newId() {
        Integer newId;
        do {
            newId = rand.nextInt(2500);
        } while (existingIds != null && existingIds.contains(newId));
        return newId;
    }

    @Override
    public void readFromNbt(CompoundTag compoundTag) {
        existingIds = new ArrayList<Integer>();
        int[] readIds = compoundTag.getIntArray("travelIds");
        for (int i : readIds) {
            existingIds.add(i);
        }
    }

    @Override
    public void writeToNbt(CompoundTag compoundTag) {
        if (existingIds == null) return;
        int[] out = new int[existingIds.size()];
        for (Integer i = 0; i < existingIds.size(); i++) {
            out[i] = existingIds.get(i);
        }
        compoundTag.putIntArray("travelIds", out);
    }
}

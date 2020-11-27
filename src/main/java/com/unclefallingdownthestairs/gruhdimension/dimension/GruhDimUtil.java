package com.unclefallingdownthestairs.gruhdimension.dimension;

import com.unclefallingdownthestairs.gruhdimension.registry.GruhBlocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GruhDimUtil {
    public static Vec3d teleportPos(int id) {
        int xCoord = id % 50;
        int zCoord = (int) Math.floor(id / 50);
        return new Vec3d(xCoord * 1000, 51, zCoord * 1000);
    }

    public static void SetReturnBlock(ServerWorld world, Vec3d teleportLocation) {
        world.setBlockState(new BlockPos(teleportLocation.add(new Vec3d(0, -1, 0))), GruhBlocks.GRUH_FABRIC.getDefaultState());
    }
}

package com.unclefallingdownthestairs.gruhdimension.dimension;

import com.unclefallingdownthestairs.gruhdimension.registry.GruhBlocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GruhDimUtil {
    public static Vec3d GetTeleportPos(int id) {
        int xCoord = id % 50 - 25;
        int zCoord = (int) Math.floor(id / 50) - 25;
        return new Vec3d(xCoord * 2500, 51, zCoord * 2500);
    }

    public static void SetReturnBlock(ServerWorld world, Vec3d teleportLocation) {
        world.setBlockState(new BlockPos(teleportLocation.add(new Vec3d(0, -1, 0))), GruhBlocks.GRUH_FABRIC.getDefaultState());
    }

    public static int GetCurrentId(double x, double z) {
        int bigGridX = (int)Math.floor((x + 1250) / 2500);
        System.out.println("Big grid x: " + bigGridX);
        int bigGridZ = (int)Math.floor((z + 1250) / 2500);
        return (bigGridX + 25) + (50 * (bigGridZ + 25));
    }
}

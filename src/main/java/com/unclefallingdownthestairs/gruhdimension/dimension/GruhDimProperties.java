package com.unclefallingdownthestairs.gruhdimension.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.math.Vec3d;

public class GruhDimProperties extends SkyProperties {

    public GruhDimProperties() {
        super(Float.NaN, true, SkyType.NONE, false, false);
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return new Vec3d(.5, .5, .5);
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return true;
    }

}

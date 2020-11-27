package com.unclefallingdownthestairs.gruhdimension.client;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import com.unclefallingdownthestairs.gruhdimension.dimension.GruhDimProperties;
import com.unclefallingdownthestairs.gruhdimension.mixin.SkyPropertiesAccesser;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GruhdimensionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SkyPropertiesAccesser.getBY_IDENTIFIER().put(new Identifier(GruhDimension.MOD_ID, "sky_property"), new GruhDimProperties());
    }
}

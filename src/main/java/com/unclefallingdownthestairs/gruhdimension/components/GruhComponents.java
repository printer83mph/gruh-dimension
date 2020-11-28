package com.unclefallingdownthestairs.gruhdimension.components;

import com.unclefallingdownthestairs.gruhdimension.GruhDimension;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class GruhComponents implements WorldComponentInitializer, EntityComponentInitializer {

    public static final ComponentKey<IntListComponent> LOC_COUNT =
            ComponentRegistry.getOrCreate(new Identifier(GruhDimension.MOD_ID, "loc_count"), IntListComponent.class);
     public static final ComponentKey<LocComponent> RETURN_LOC =
             ComponentRegistry.getOrCreate(new Identifier(GruhDimension.MOD_ID, "return_loc"), LocComponent.class);

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(LOC_COUNT, properties -> new LocCountComponent());
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(RETURN_LOC, entity -> new ReturnLocComponent(entity));
    }
}

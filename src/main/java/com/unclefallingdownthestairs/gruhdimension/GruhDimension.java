package com.unclefallingdownthestairs.gruhdimension;

import com.unclefallingdownthestairs.gruhdimension.registry.GruhBlocks;
import com.unclefallingdownthestairs.gruhdimension.registry.GruhItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class GruhDimension implements ModInitializer {

    public static final String MOD_ID = "gruhdimension";

    public static final Identifier MOD_DIMENSION_ID = new Identifier(GruhDimension.MOD_ID, "gruh_dimension");

    @Override
    public void onInitialize() {

        GruhBlocks.RegisterBlocks();
        GruhItems.RegisterItems();
//        GruhRecipes.RegisterRecipes();

    }

}

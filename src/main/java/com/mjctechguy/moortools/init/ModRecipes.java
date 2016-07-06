package com.mjctechguy.moortools.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ModRecipes {

    public static void init() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.xp_ten),new ItemStack(Items.EXPERIENCE_BOTTLE),new ItemStack(Items.CARROT));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.xp_ten),new ItemStack(Items.EXPERIENCE_BOTTLE),new ItemStack(Items.BANNER));
    }

}

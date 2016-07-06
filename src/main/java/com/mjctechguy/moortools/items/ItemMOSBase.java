package com.mjctechguy.moortools.items;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjctechguy on 22/06/16.
 */
public class ItemMOSBase extends Item {

    public ItemMOSBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
    }
}


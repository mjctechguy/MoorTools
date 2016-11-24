package com.mjctechguy.moortools.items;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.item.ItemShears;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjcte on 23/10/2016.
 */
public class ItemMOSShears extends ItemShears {
    public ItemMOSShears(String name, int durability) {
        this.setMaxDamage(durability);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
    }
}

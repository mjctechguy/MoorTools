package com.mjctechguy.moortools.items;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ItemMOSSpade extends ItemSpade {
    public ItemMOSSpade(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
    }
}

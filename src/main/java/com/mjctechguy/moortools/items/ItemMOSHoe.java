package com.mjctechguy.moortools.items;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ItemMOSHoe extends ItemHoe {
    public ItemMOSHoe(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
    }
}

package com.mjctechguy.moortools.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by mjctechguy on 22/06/16.
 */

public class ModCreativeTab extends CreativeTabs {

    public ModCreativeTab(String label){
        super(label);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.diamond_Paxel;
    }
}
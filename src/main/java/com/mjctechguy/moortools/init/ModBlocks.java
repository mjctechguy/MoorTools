package com.mjctechguy.moortools.init;

import com.mjctechguy.moortools.blocks.BlockBase;
import com.mjctechguy.moortools.blocks.MTChest;
import net.minecraft.block.material.Material;

/**
 * Created by mjctechguy on 11/07/16.
 */
public class ModBlocks {
    public static MTChest mt_chest;
    public static BlockBase block_base;

    public static void init() {
        mt_chest = new MTChest(Material.ROCK,"mt_chest");
        block_base = new BlockBase(Material.ROCK,"block_base");
    }
}

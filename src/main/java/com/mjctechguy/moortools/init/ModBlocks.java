package com.mjctechguy.moortools.init;

import com.mjctechguy.moortools.blocks.BlockBase;
import com.mjctechguy.moortools.blocks.MTFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;;

/**
 * Created by mjctechguy on 11/07/16.
 */
public class ModBlocks {
    public static MTFurnace mt_furnace;
    public static BlockBase block_base;

    public static void init() {
        mt_furnace = new MTFurnace(Material.ROCK,"mt_furnace");
        block_base = new BlockBase(Material.ROCK,"block_base");
    }
}

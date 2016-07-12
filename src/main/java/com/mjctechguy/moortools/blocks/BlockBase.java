package com.mjctechguy.moortools.blocks;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by mjctechguy on 11/07/16.
 */
public class BlockBase extends Block {

    public BlockBase(Material material, String name) {
        super(material);
        this.setHardness(0.8f);
        this.setResistance(0.5F);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), this.getRegistryName());
    }
}

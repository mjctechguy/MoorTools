package com.mjctechguy.moortools.items;

import com.google.common.collect.Sets;
import com.mjctechguy.moortools.MoorTools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Set;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ItemMOSAxe extends ItemTool
{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.DIRT, Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.STONE});

    public ItemMOSAxe(String name, ToolMaterial material)
    {
        super(material, EFFECTIVE_ON);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }
}




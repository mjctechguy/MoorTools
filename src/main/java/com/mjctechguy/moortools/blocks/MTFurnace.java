package com.mjctechguy.moortools.blocks;

import com.mjctechguy.moortools.MoorTools;
import com.mjctechguy.moortools.gui.GuiHandlerMTFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.mjctechguy.moortools.tileentitys.TileEntityMTFurnace;

import javax.annotation.Nullable;

/**
 * Created by mjctechguy on 11/07/16.
 */
public class MTFurnace extends Block implements ITileEntityProvider {

    public MTFurnace(Material material, String name) {
        super(material);
        this.setHardness(0.8f);
        this.setResistance(0.5F);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), this.getRegistryName());
        GameRegistry.registerTileEntity(TileEntityMTFurnace.class, name);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMTFurnace();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) return true;
        playerIn.openGui(MoorTools.instance, GuiHandlerMTFurnace.getGuiID(),worldIn,pos.getX(),pos.getY(),pos.getZ());
        return true;
    }
}

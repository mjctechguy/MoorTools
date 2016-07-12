package com.mjctechguy.moortools.gui;

import com.mjctechguy.moortools.container.ContainerMTFurnace;
import com.mjctechguy.moortools.tileentitys.TileEntityMTFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by mjctechguy on 12/07/16.
 */
public class GuiHandlerMTFurnace implements IGuiHandler {
    public static int getGuiID() {return 1;};

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.out.println("Incorrect ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileEntityMTFurnace) {
            TileEntityMTFurnace tileEntityMTFurnacen = (TileEntityMTFurnace) tileEntity;
            return new ContainerMTFurnace(player.inventory, tileEntityMTFurnacen);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.out.println("Incorrect ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileEntityMTFurnace) {
            TileEntityMTFurnace tileEntityMTFurnacen = (TileEntityMTFurnace) tileEntity;
            return new ContainerMTFurnace(player.inventory, tileEntityMTFurnacen);
        }

        return null;
    }
}

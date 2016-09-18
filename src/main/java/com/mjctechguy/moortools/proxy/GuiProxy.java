package com.mjctechguy.moortools.proxy;

import com.mjctechguy.moortools.container.ContainerMTChest;
import com.mjctechguy.moortools.gui.GuiMTChest;
import com.mjctechguy.moortools.tileentitys.TileEntityMTChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by mjcte on 04/09/2016.
 */
public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new ContainerMTChest(player.inventory,(TileEntityMTChest) world.getTileEntity(new BlockPos(x,y,z)));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) {
            return new GuiMTChest(player.inventory,(TileEntityMTChest) world.getTileEntity(new BlockPos(x,y,z)));
        }

        return null;
    }
}

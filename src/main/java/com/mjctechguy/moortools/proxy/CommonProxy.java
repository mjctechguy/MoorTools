package com.mjctechguy.moortools.proxy;

import com.mjctechguy.moortools.MoorTools;
import com.mjctechguy.moortools.gui.GuiHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import com.mjctechguy.moortools.gui.GuiHandlerMTFurnace;

/**
 * Created by mjctechguy on 22/06/16.
 */
public class CommonProxy {

    /*public void Cinit() {
        NetworkRegistry.INSTANCE.registerGuiHandler(MoorTools.instance, GuiHandlerRegistry.getInstance());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerMTFurnace(), GuiHandlerMTFurnace.getGuiID());
    }*/
    public void registerItemRender(Item item) {}
    public void registerItemRenders() {}
    public void registerBlockRender(Block block) {}
    public void registerBlockRenders() {}

    public void preInit(FMLPreInitializationEvent e) {

    }


    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}


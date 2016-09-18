package com.mjctechguy.moortools.proxy;

import com.mjctechguy.moortools.MoorTools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by mjctechguy on 22/06/16.
 */
public class CommonProxy {
    public void registerItemRender(Item item) {}
    public void registerItemRenders() {}
    public void registerBlockRender(Block block) {}
    public void registerBlockRenders() {}

    public void preInit(FMLPreInitializationEvent e) {}


    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MoorTools.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {}
}


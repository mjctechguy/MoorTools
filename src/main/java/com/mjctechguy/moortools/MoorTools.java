package com.mjctechguy.moortools;

import com.mjctechguy.moortools.init.ModBlocks;
import com.mjctechguy.moortools.init.ModCreativeTab;
import com.mjctechguy.moortools.init.ModItems;
import com.mjctechguy.moortools.init.ModRecipes;
import com.mjctechguy.moortools.reference.Reference;
import com.mjctechguy.moortools.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)

public class MoorTools {

    @Instance(Reference.MOD_NAME)
    public static MoorTools instance;

    @SidedProxy(clientSide = Reference.MOD_CLIENT_PROXY_CLASS, serverSide = Reference.MOD_SERVER_PROXY_CLASS )
    public static CommonProxy proxy;

    public static final ModCreativeTab creativeTab = new ModCreativeTab(Reference.MOD_ID);

    @EventHandler()
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModBlocks.init();
        ModRecipes.init();
    }

    @EventHandler()
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler()
    public void init(FMLInitializationEvent event) {
        proxy.registerItemRenders();
        proxy.registerBlockRenders();
    }

}

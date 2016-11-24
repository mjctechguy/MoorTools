package com.mjctechguy.moortools.proxy;

import com.mjctechguy.moortools.init.ModBlocks;
import com.mjctechguy.moortools.init.ModItems;
import com.mjctechguy.moortools.init.ModRecipes;
import com.mjctechguy.moortools.reference.Reference;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by mjctechguy on 22/06/16.
 */
public class ClientProxy extends CommonProxy{

    @Override
    public void registerItemRender(Item item) {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }

    @Override
    public void registerItemRenders() {
        registerItemRender(ModItems.wood_Paxel);
        registerItemRender(ModItems.stone_Paxel);
        registerItemRender(ModItems.iron_Paxel);
        registerItemRender(ModItems.diamond_Paxel);
        registerItemRender(ModItems.gold_Paxel);

        registerItemRender(ModItems.wood_Shears);
        registerItemRender(ModItems.stone_Shears);
        registerItemRender(ModItems.gold_Shears);
        registerItemRender(ModItems.diamond_Shears);
        registerItemRender(ModItems.emerald_Shears);
    }

    @Override
    public void registerBlockRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }

    @Override
    public void registerBlockRenders() {
        registerBlockRender(ModBlocks.mt_chest);
        registerBlockRender(ModBlocks.block_base);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModItems.init();
        ModBlocks.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ModRecipes.init();
        registerBlockRenders();
        registerItemRenders();
    }

}

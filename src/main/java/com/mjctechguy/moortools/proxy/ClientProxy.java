package com.mjctechguy.moortools.proxy;

import com.mjctechguy.moortools.init.ModItems;
import com.mjctechguy.moortools.items.ItemMOSBase;
import com.mjctechguy.moortools.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

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
        registerItemRender(ModItems.redDiamond_Axe);
        registerItemRender(ModItems.xp_ten);
    }

    /*@Override
    public void registerBlockRender(BlockMjsExtra block) {
        Item item = Item.getItemFromBlock(block);
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }*/

    /*@Override
    public void registerBlockRenders() {
    }*/
}

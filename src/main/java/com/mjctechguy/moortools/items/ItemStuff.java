package com.mjctechguy.moortools.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by mjctechguy on 11/07/16.
 */
public class ItemStuff extends ItemMOSBase {
    public ItemStuff(){super("stuff");}

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        System.out.print(playerIn.isUser());
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }


}

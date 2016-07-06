package com.mjctechguy.moortools.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by mjctechguy on 22/06/16.
 */
public class ItemMOSXp10 extends ItemMOSBase {
    public ItemMOSXp10() {
        super("xp_ten");
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        tooltip.add("Adds 10 levels of experience on right click.");
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!playerIn.isCreative()) {
            playerIn.addExperienceLevel(10);
            --itemStackIn.stackSize;
        }
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }

}

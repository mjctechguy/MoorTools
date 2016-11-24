package com.mjctechguy.moortools.items;

import com.google.common.collect.ImmutableSet;
import com.mjctechguy.moortools.MoorTools;
import com.mjctechguy.moortools.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collections;
import java.util.Set;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ItemMOSPaxel extends ItemTool
{

    public ItemMOSPaxel(ToolMaterial material, String name )
    {
        super(3.0F + material.getDamageVsEntity(), 1.2F,material, Collections.<Block>emptySet());
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MoorTools.creativeTab);
        GameRegistry.register(this);
        setHarvestLevel("pickaxe",material.getHarvestLevel());
        setHarvestLevel("axe",material.getHarvestLevel());
        setHarvestLevel("shovel",material.getHarvestLevel());
        setHarvestLevel("sword",material.getHarvestLevel());
    }

    private static final Set<Material> EFFECTIVE_ON = ImmutableSet.of(
            // Pickaxe
            Material.ROCK, Material.IRON, Material.IRON, Material.GLASS, Material.PISTON, Material.ANVIL, Material.CIRCUITS,

            // Axe
            Material.WOOD, Material.GOURD, Material.PLANTS, Material.VINE,

            // Shovel
            Material.GRASS, Material.GROUND, Material.SAND, Material.SNOW, Material.CRAFTED_SNOW, Material.CLAY
    );

    private static final Set<Material> SWORD_MATERIALS = ImmutableSet.of(
            Material.PLANTS, Material.VINE, Material.CORAL, Material.LEAVES, Material.GOURD
    );

    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        return EFFECTIVE_ON.contains(state.getMaterial()) || state.getBlock() == Blocks.WEB;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        if (state.getBlock() == Blocks.WEB) {
            return 15.5F;
        }

        for (String type : getToolClasses(stack)) {
            if (state.getBlock().isToolEffective(type, state))
                return efficiencyOnProperMaterial;
        }

        // Not all blocks have a harvest tool/level set, so we need to fall back to checking the Material like the vanilla tools do
        if (EFFECTIVE_ON.contains(state.getMaterial())) {
            return efficiencyOnProperMaterial;
        }

        if (SWORD_MATERIALS.contains(state.getMaterial())) {
            return 5;
        }

        return 5;
    }

    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return super.getItemEnchantability(stack);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        itemStack.damageItem(1, attacker); // Only reduce the durability by 1 point (like swords do) instead of 2 (like tools do)
        return true;
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
            {
                if (block == Blocks.GRASS || block == Blocks.GRASS_PATH)
                {
                    this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }

                if (block == Blocks.DIRT)
                {
                    switch ((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT))
                    {
                        case DIRT:
                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
                            return EnumActionResult.SUCCESS;
                        case COARSE_DIRT:
                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                            return EnumActionResult.SUCCESS;
                    }
                }
            }

            return EnumActionResult.PASS;
        }
    }

    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote)
        {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player);
        }
    }



    //PlayerEvent.ItemCraftedEvent
}




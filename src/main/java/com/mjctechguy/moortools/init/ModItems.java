package com.mjctechguy.moortools.init;

import com.mjctechguy.moortools.items.*;
import com.mjctechguy.moortools.reference.Reference;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;

public class ModItems {

    //Tool Materials
    private static ToolMaterial WOOD_PAXEL = EnumHelper.addToolMaterial("WOOD_PAXEL",0,150,2.0F,0.0F,15);
    private static ToolMaterial STONE_PAXEL = EnumHelper.addToolMaterial("STONE_PAXEL",1,250,4.0F,3f,5);
    private static ToolMaterial IRON_PAXEL = EnumHelper.addToolMaterial("IRON_PAXEL",2,350,6.0F,2.0f,14);
    private static ToolMaterial GOLD_PAXEL = EnumHelper.addToolMaterial("GOLD_PAXEL",0,150,12.0F,0.0f,22);
    private static ToolMaterial DIAMOND_PAXEL = EnumHelper.addToolMaterial("DIAMOND_PAXEL",3,650,8.0F,3.0f,10);


    //Vanilla Material paxels
    public static ItemMOSPaxel wood_Paxel;
    public static ItemMOSPaxel stone_Paxel;
    public static ItemMOSPaxel iron_Paxel;
    public static ItemMOSPaxel gold_Paxel;
    public static ItemMOSPaxel diamond_Paxel;


    //More Shears
    public static ItemMOSShears wood_Shears;
    public static ItemMOSShears stone_Shears;
    public static ItemMOSShears gold_Shears;
    public static ItemMOSShears diamond_Shears;
    public static ItemMOSShears emerald_Shears;
    public static ItemMOSShears obsdian_Shears;



    public static void init() {
        //Paxel for main Vanilla types
        wood_Paxel = new ItemMOSPaxel(ModItems.WOOD_PAXEL,"wood_Paxel");
        stone_Paxel = new ItemMOSPaxel(ModItems.STONE_PAXEL,"stone_Paxel");
        iron_Paxel = new ItemMOSPaxel(ModItems.IRON_PAXEL,"iron_Paxel");
        gold_Paxel = new ItemMOSPaxel(ModItems.GOLD_PAXEL,"gold_Paxel");
        diamond_Paxel = new ItemMOSPaxel(ModItems.DIAMOND_PAXEL,"diamond_Paxel");


        //More Shears
        wood_Shears = new ItemMOSShears("wood_Shears",150);
        stone_Shears = new ItemMOSShears("stone_Shears",250);
        gold_Shears = new ItemMOSShears("gold_Shears",300);
        diamond_Shears = new ItemMOSShears("diamond_Shears",400);
        emerald_Shears = new ItemMOSShears("emerald_Shears",550);
    }
}

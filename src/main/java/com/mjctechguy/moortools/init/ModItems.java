package com.mjctechguy.moortools.init;

import com.mjctechguy.moortools.items.*;

public class ModItems {
    //Xp Stuff
    public static ItemMOSXp10 xp_ten;

    //Red Diamond Pick Tools
    public static ItemMOSPickaxe redDiamond_Pick;
    public static ItemMOSAxe redDiamond_Axe;
    public static ItemMOSSpade redDiamond_Spade;
    public static ItemMOSHoe redDiamond_Hoe;


    public static void init() {
        xp_ten = new ItemMOSXp10();

        //Red Diamond Pick Tools and Sword
        redDiamond_Pick = new ItemMOSPickaxe("redD1iamond_Pick",ModToolMaterials.RED_DIAMOND);
        redDiamond_Axe = new ItemMOSAxe("redDiamond_Axe", ModToolMaterials.RED_DIAMOND);
        redDiamond_Spade = new ItemMOSSpade("redDiamond_Spade",ModToolMaterials.RED_DIAMOND);
        redDiamond_Hoe = new ItemMOSHoe("redDiamond_Hoe",ModToolMaterials.RED_DIAMOND);
    }
}

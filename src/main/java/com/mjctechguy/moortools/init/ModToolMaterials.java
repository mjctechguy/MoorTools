package com.mjctechguy.moortools.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by mjctechguy on 25/06/16.
 */
public class ModToolMaterials {
    public static ToolMaterial RED_DIAMOND = EnumHelper.addToolMaterial("RED_DIAMOND",3, 400,10F,3f,30);
    //public static ToolMaterial GREEN_DIAMOND = EnumHelper.addToolMaterial("RED_DIAMOND",3, 400,8F,3f,30);
    public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", 3, 1000, 15.0F, 4.0F, 30);
}

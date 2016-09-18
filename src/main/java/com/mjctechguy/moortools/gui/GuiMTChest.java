package com.mjctechguy.moortools.gui;

import com.mjctechguy.moortools.MoorTools;
import com.mjctechguy.moortools.container.ContainerMTChest;
import com.mjctechguy.moortools.reference.Reference;
import com.mjctechguy.moortools.tileentitys.TileEntityMTChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;


/**
 * Created by mjctechguy on 12/07/16.
 */
public class GuiMTChest extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID, "textures/gui/mt_chest.png");

    public GuiMTChest(IInventory playerInv, TileEntityMTChest tileEntityMTChest) {
        super(new ContainerMTChest(playerInv,tileEntityMTChest));

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}

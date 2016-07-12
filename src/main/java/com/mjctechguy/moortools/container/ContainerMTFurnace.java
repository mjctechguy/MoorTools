package com.mjctechguy.moortools.container;

import com.mjctechguy.moortools.tileentitys.TileEntityMTFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;


/**
 * Created by mjctechguy on 12/07/16.
 */
public class ContainerMTFurnace extends Container {
    private TileEntityMTFurnace tileEntityMTFurnace;

    private int [] cachedFields;

    private final int HOTBAR_SLOT_COUNT = 9;
    private final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    public final int FUEL_SLOTS_COUNT = 4;
    public final int INPUT_SLOTS_COUNT = 5;
    public final int OUTPUT_SLOTS_COUNT = 5;
    public final int FURNACE_SLOTS_COUNT = FUEL_SLOTS_COUNT + INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;

    private final int VANILLA_FIRST_SLOT_INDEX = 0;
    private final int FIRST_FUEL_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private final int FIRST_INPUT_SLOT_INDEX = FIRST_FUEL_SLOT_INDEX + FUEL_SLOTS_COUNT;
    private final int FIRST_OUTPUT_SLOT_INDEX = FIRST_INPUT_SLOT_INDEX + INPUT_SLOTS_COUNT;

    private final int FIRST_FUEL_SLOT_NUMBER = 0;
    private final int FIRST_INPUT_SLOT_NUMBER = FIRST_FUEL_SLOT_NUMBER + FUEL_SLOTS_COUNT;
    private final int FIRST_OUTPUT_SLOT_NUMBER = FIRST_INPUT_SLOT_NUMBER + INPUT_SLOTS_COUNT;

    public ContainerMTFurnace(InventoryPlayer inventoryPlayer, TileEntityMTFurnace tileEntityMTFurnace) {
        this.tileEntityMTFurnace = tileEntityMTFurnace;

        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;

        final int HOTBAR_XPOS = 8;
        final int HOTBAR_YPOS = 183;

        //Adds Players hotbar to GUI
        for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
            int slotNumber = x;
            addSlotToContainer(new Slot(inventoryPlayer,slotNumber,HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
        }


        final int PLAYER_INVENTORY_XPOS = 8;
        final int PLAYER_INVENTORY_YPOS = 125;
        // Add the rest of the players inventory to the gui
        for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
            for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
                int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
                int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
                int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
                addSlotToContainer(new Slot(inventoryPlayer, slotNumber,  xpos, ypos));
            }
        }

        final int FUEL_SLOTS_XPOS = 53;
        final int FUEL_SLOTS_YPOS = 96;
        // Add the tile fuel slots
        for (int x = 0; x < FUEL_SLOTS_COUNT; x++) {
            int slotNumber = x + FIRST_FUEL_SLOT_NUMBER;
            addSlotToContainer(new SlotFurnaceFuel(inventoryPlayer, slotNumber, FUEL_SLOTS_XPOS + SLOT_X_SPACING * x, FUEL_SLOTS_YPOS));
        }

        final int INPUT_SLOTS_XPOS = 26;
        final int INPUT_SLOTS_YPOS = 24;
        // Add the tile input slots
        for (int y = 0; y < INPUT_SLOTS_COUNT; y++) {
            int slotNumber = y + FIRST_INPUT_SLOT_NUMBER;
            addSlotToContainer(new Slot(inventoryPlayer, slotNumber, INPUT_SLOTS_XPOS, INPUT_SLOTS_YPOS+ SLOT_Y_SPACING * y));
        }

        final int OUTPUT_SLOTS_XPOS = 134;
        final int OUTPUT_SLOTS_YPOS = 24;
        // Add the tile output slots
        for (int y = 0; y < OUTPUT_SLOTS_COUNT; y++) {
            int slotNumber = y + FIRST_OUTPUT_SLOT_NUMBER;
            addSlotToContainer(new SlotFurnaceOutput(inventoryPlayer.player,inventoryPlayer, slotNumber, OUTPUT_SLOTS_XPOS, OUTPUT_SLOTS_YPOS + SLOT_Y_SPACING * y));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        Slot sourceSlot = (Slot)inventorySlots.get(index);
        if (sourceSlot == null || !sourceSlot.getHasStack()) return null;
        ItemStack sourceStack = sourceSlot.getStack();
        ItemStack copyofSourceStack = sourceStack.copy();

        if (index >= VANILLA_FIRST_SLOT_INDEX && index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if TileEntityMTFurnace,get
        }
    }
}

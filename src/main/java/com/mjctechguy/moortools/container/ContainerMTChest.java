package com.mjctechguy.moortools.container;

import com.mjctechguy.moortools.tileentitys.TileEntityMTChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;


/**
 * Created by mjctechguy on 12/07/16.
 */
public class ContainerMTChest extends Container {
    private TileEntityMTChest tileEntityMTChest;

    public ContainerMTChest(IInventory playerInventory, TileEntityMTChest tileEntityMTChest) {
        this.tileEntityMTChest = tileEntityMTChest;
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {

        //Player Inventory Main Slots
        for (int row = 0; row < 3; ++row) {
            for (int col = 0;col < 9; ++col) {
                int x = 10 + col * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(playerInventory,col + row * 9 + 10, x, y));

            }
        }

        //Player Inventory Hotbar Slots
        for (int row = 0; row < 9; ++row) {
            int x = 10 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(playerInventory, row,x,y));
        }
    }

    private void addOwnSlots() {
        IItemHandler iItemHandler = this.tileEntityMTChest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,null);
        int x = 10;
        int y = 6;

        //Own Slots

        int slotIndex = 0;

        for (int i = 0; i < iItemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotItemHandler(iItemHandler,slotIndex,x,y));
            slotIndex++;
            x += 18;
        }
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer,int Index) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(Index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (Index < TileEntityMTChest.SIZE) {
                if (!this.mergeItemStack(itemStack1,TileEntityMTChest.SIZE,this.inventorySlots.size(),true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemStack1,0,TileEntityMTChest.SIZE, false)) {
                return null;
            }

            if (itemStack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileEntityMTChest.canInteractWith(playerIn);
    }
}

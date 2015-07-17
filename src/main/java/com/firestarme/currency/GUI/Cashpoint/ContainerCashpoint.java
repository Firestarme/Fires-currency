package com.firestarme.currency.GUI.Cashpoint;

import com.firestarme.currency.GUI.CSlotPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Created by User on 16/07/2015.
 */
public class ContainerCashpoint extends Container {

    private IInventory iic = new IInventoryCashpoint();

    public ContainerCashpoint(EntityPlayer playerIn){

        int i = 0;

        for(CSlotPos csp:IInventoryCashpoint.getSlotPosArray()){

            addSlotToContainer(new Slot(iic,i,csp.getXpos(),csp.getYpos()));

        }

        bindPlayerInventory(new InventoryPlayer(playerIn));

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    protected void bindPlayerInventory(InventoryPlayer player_inventory) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(player_inventory, j + i * 9 + 9, 9 + j * 18, 64 + i * 16));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(player_inventory, i, 6 + i * 16, 142));
        }
    }

}
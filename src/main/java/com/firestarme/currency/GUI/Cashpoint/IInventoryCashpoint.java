package com.firestarme.currency.GUI.Cashpoint;

import com.firestarme.currency.GUI.CSlotPos;
import com.firestarme.currency.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;

/**
 * Created by Sam on 16/07/2015.
 */
public class IInventoryCashpoint implements IInventory{

    private final int size = 6;
    private ItemStack[] inv = new ItemStack[size];
    private static final CSlotPos[] slotval =
            {
                    new CSlotPos(Main.I1,31,63),
                    new CSlotPos(Main.I2,50,63),
                    new CSlotPos(Main.I5,69,63),
                    new CSlotPos(Main.I10,88,63),
                    new CSlotPos(Main.I20,102,63),
                    new CSlotPos(Main.I50,121,63)
            };

    private ItemStack takeStack(int i){

        if(inv[i] != null)
        {
            ItemStack itemstack = inv[i];
            inv[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }

    }

    public static CSlotPos[] getSlotPosArray(){

        return slotval;

    }


    @Override
    public int getSizeInventory() {
        return size;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inv[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int i1) {

        return takeStack(i);

    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return takeStack(i);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {

        inv[i] = itemStack;

    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {

    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return (itemStack.getItem().getUnlocalizedName() == slotval[i].getUnlocalizedName());
    }

    @Override
    public int getField(int i) {
        return 0;
    }

    @Override
    public void setField(int i, int i1) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for(int i = 0 ; i < inv.length ; i++){

            inv[i] = null;

        }
    }

    @Override
    public String getName() {
        return "CashpointOut";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }
}

package com.firestarme.currency.GUI;

import net.minecraft.item.Item;

/**
 * Created by Sam on 17/07/2015.
 */
public class CSlotPos {

    private int Xpos;
    private int Ypos;
    private String uln;

    public CSlotPos(Item it,int xpos,int ypos){

        Xpos = xpos;
        Ypos = ypos;
        this.uln = it.getUnlocalizedName();

    }

    public String getUnlocalizedName(){
        return this.uln;
    }

    public int getXpos(){
        return this.Xpos;
    }

    public int getYpos(){
        return this.Ypos;
    }


}

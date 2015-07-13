package com.firestarme.currency;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by User on 04/12/2014.
 */
public class CTab extends CreativeTabs{


    public CTab(String lab) {
        super(lab);
    }

    @Override
    public Item getTabIconItem() {
        System.out.println(Main.I2.getUnlocalizedName());
        return Main.I2;
    }

}

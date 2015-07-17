package com.firestarme.currency.GUI;

import com.firestarme.currency.GUI.Cashpoint.GuiCashpoint;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Sam on 14/07/2015.
 */
public class GuiHandler implements IGuiHandler {

    public GuiHandler(Object instance){

        NetworkRegistry.INSTANCE.registerGuiHandler(instance,this);

    }

    @Override
    public Object getServerGuiElement(int i, EntityPlayer entityPlayer, World world, int i1, int i2, int i3) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int i, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        switch(i){

            case 0: return new GuiCashpoint(entityPlayer,world,x,y,z);
            default: return null;

        }

    }
}

package com.firestarme.currency.GUI.Cashpoint;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Sam on 14/07/2015.
 */
public class GuiCashpoint extends GuiContainer {

    private int x,y,z;
    private World world;
    private EntityPlayer player;
    private int xSize,ySize;

    public GuiCashpoint(EntityPlayer player, World world,int x,int y,int z){
        super(new ContainerCashpoint(player));

        this.x=x;
        this.y=y;
        this.z=z;

        this.world=world;
        this.player=player;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float v, int i, int i1) {

    }
}

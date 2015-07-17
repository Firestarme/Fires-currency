package com.firestarme.currency;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sam on 17/07/2015.
 */
public class ItemBlockCashpoint extends ItemBlock {

    private String name;

    public ItemBlockCashpoint(Block block,String name) {
        super(block);
        this.name = name;
    }

    public void registerRenderer(RenderItem ri,int meta){

        ri.getItemModelMesher().register(this,meta,new ModelResourceLocation(Main.MODID+":"+name,"inventory"));
        System.out.println("[" + Main.MODID + "] Texture:" + name + " Registered");
        System.out.println(meta);


    }
}

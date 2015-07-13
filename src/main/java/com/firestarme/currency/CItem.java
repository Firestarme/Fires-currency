package com.firestarme.currency;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class CItem extends Item{

    private String name;

	public CItem(String name) {
		super();
        GameRegistry.registerItem(this, name);
        this.setUnlocalizedName(Main.MODID + "_" + name);
        this.setCreativeTab(Main.ctab);
        this.setMaxStackSize(64);
        this.name = name;
        System.out.println("["+Main.MODID+"] "+name+" Has been sucessfully loaded");

	}

    public String getName(){

        System.out.println("usage");
        return name;

    }

    public void registerRender(RenderItem ri){

        ri.getItemModelMesher().register(this,0,new ModelResourceLocation(Main.MODID+":"+name,"inventory"));
        System.out.println("["+Main.MODID+"] Texture:"+name+" Registered");

    }

    public static void addCrafting() {

        ItemStack is1 = new ItemStack(Main.I1);
        ItemStack is2 = new ItemStack(Main.I2);
        ItemStack is5 = new ItemStack(Main.I5);
        ItemStack is10 = new ItemStack(Main.I10);
        ItemStack is20 = new ItemStack(Main.I20);
        ItemStack is50 = new ItemStack(Main.I50);


        //1
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I1,5),is5);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I1,2),is2);

        //2
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I2),is1,is1);

        //5
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I5),is2,is2,is1);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I5),is1,is1,is1,is1,is1);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I5, 2), is10);

        //10
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I10),is5,is5);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I10,5),is50);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I10,2),is20);

        //20
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I20),is10,is10);

        //50
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I50),is10,is20,is20);
        GameRegistry.addShapelessRecipe(new ItemStack(Main.I50),is10,is10,is10,is10,is10);


    }

}



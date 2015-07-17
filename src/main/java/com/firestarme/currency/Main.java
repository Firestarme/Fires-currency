package com.firestarme.currency;


import com.firestarme.currency.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.common.config.Configuration;


@Mod(modid = Main.MODID , name = Main.name , version = Main.Version)

public class Main{

    public static final String name = "Fire's Currency";
    public static final String MODID = "firescurrency";
    public static final String Version = "A[1.7.10]";
    public static final String CLIENT_PROXY_CLASS ="com.firestarme.currency.proxies.ClientProxy";
    public static final String COMMON_PROXY_CLASS="com.firestarme.currency.proxies.CommonProxy";

	@Mod.Instance("currency")
	public static Main instance;
	
	@SidedProxy(clientSide=CLIENT_PROXY_CLASS, serverSide=COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

	public static CItem I1;
	public static CItem I2;
	public static CItem I5;
	public static CItem I10;
	public static CItem I20;
	public static CItem I50;

    public static Block cashpoint;

    public static CreativeTabs ctab;
    public static Boolean ccint;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

        ccint = config.getBoolean("Enable Trader",Configuration.CATEGORY_GENERAL,true,"set true to enable Computercraft Trader (Requires Computercraft)");

		config.save();

        ctab = new CTab(MODID);

        I1 = new CItem("currency1");
        I2 = new CItem("currency2");
        I5 = new CItem("currency5");
        I10 = new CItem("currency10");
        I20 = new CItem("currency20");
        I50 = new CItem("currency50");

        cashpoint = new BlockCashpoint("cashpoint");

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){

        if(event.getSide()== Side.CLIENT){

            RenderItem ri = Minecraft.getMinecraft().getRenderItem();

            I1.registerRender(ri);
            I2.registerRender(ri);
            I5.registerRender(ri);
            I10.registerRender(ri);
            I20.registerRender(ri);
            I50.registerRender(ri);

            ((BlockCashpoint)cashpoint).registerItemRenderer(ri);

        }

        CItem.addCrafting();

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

       // if (event.getSide() == Side.CLIENT)
       //     Minecraft.getMinecraft().refreshResources();

	}

	}




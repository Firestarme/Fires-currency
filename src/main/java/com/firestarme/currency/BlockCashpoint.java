package com.firestarme.currency;

import com.firestarme.currency.GUI.GUIs;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by User on 14/07/2015.
 */
public class BlockCashpoint extends Block{

    private String name;
    private ItemBlockCashpoint ib;
    public static final PropertyDirection FACING;

    public BlockCashpoint(String name){
        super(Material.iron);
        GameRegistry.registerBlock(this, name);
        setUnlocalizedName(Main.MODID + "_" + name);
        setCreativeTab(Main.ctab);
        this.name = name;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

        ib = new ItemBlockCashpoint(this,name);

        System.out.println("["+Main.MODID+"] "+name+" Has been sucessfully loaded");

    }

    public void registerItemRenderer(RenderItem ri){ib.registerRenderer(ri,this.getMetaFromState(this.getDefaultState()));}

    static {
        FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

        playerIn.openGui(Main.instance, GUIs.Cashpoint.ordinal(),worldIn,pos.getX(),pos.getY(),pos.getZ());
        return true;
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

        return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){

        this.setDefaultFacing(worldIn, pos, state);

    }

    private void setDefaultFacing(World p_setDefaultFacing_1_, BlockPos p_setDefaultFacing_2_, IBlockState p_setDefaultFacing_3_) {
        if(!p_setDefaultFacing_1_.isRemote) {
            Block var4 = p_setDefaultFacing_1_.getBlockState(p_setDefaultFacing_2_.north()).getBlock();
            Block var5 = p_setDefaultFacing_1_.getBlockState(p_setDefaultFacing_2_.south()).getBlock();
            Block var6 = p_setDefaultFacing_1_.getBlockState(p_setDefaultFacing_2_.west()).getBlock();
            Block var7 = p_setDefaultFacing_1_.getBlockState(p_setDefaultFacing_2_.east()).getBlock();
            EnumFacing var8 = (EnumFacing)p_setDefaultFacing_3_.getValue(FACING);
            if(var8 == EnumFacing.NORTH && var4.isFullBlock() && !var5.isFullBlock()) {
                var8 = EnumFacing.SOUTH;
            } else if(var8 == EnumFacing.SOUTH && var5.isFullBlock() && !var4.isFullBlock()) {
                var8 = EnumFacing.NORTH;
            } else if(var8 == EnumFacing.WEST && var6.isFullBlock() && !var7.isFullBlock()) {
                var8 = EnumFacing.EAST;
            } else if(var8 == EnumFacing.EAST && var7.isFullBlock() && !var6.isFullBlock()) {
                var8 = EnumFacing.WEST;
            }

            p_setDefaultFacing_1_.setBlockState(p_setDefaultFacing_2_, p_setDefaultFacing_3_.withProperty(FACING, var8), 2);
        }
    }

    @Override
    public IBlockState getStateFromMeta(int p_getStateFromMeta_1_) {
        EnumFacing var2 = EnumFacing.getFront(p_getStateFromMeta_1_);
        if(var2.getAxis() == EnumFacing.Axis.Y) {
            var2 = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, var2);
    }

    @Override
    protected BlockState createBlockState(){return new BlockState(this, new IProperty[] {FACING});}

    @Override
    public int getMetaFromState(IBlockState p_getMetaFromState_1_) {return ((EnumFacing)p_getMetaFromState_1_.getValue(FACING)).getIndex();}



}

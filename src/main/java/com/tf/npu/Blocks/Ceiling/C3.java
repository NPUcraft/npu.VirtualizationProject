package com.tf.npu.Blocks.Ceiling;

import com.tf.npu.Init.ModBlocks;
import com.tf.npu.Init.ModItems;
import com.tf.npu.NPU;
import com.tf.npu.interfaces.IHasModel;
import com.tf.npu.util.InitHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class C3 extends Block implements IHasModel {

    public static enum EnumMaterial implements IStringSerializable {
        IRON("iron");

        private String name;

        private EnumMaterial(String material) {
            this.name = material;
        }

        @Override
        public String getName() {
            return this.name;
        }

    }

    //x1,y1,z1,x2,y2,z2均为double类型
    public static final AxisAlignedBB C3_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return C3_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public void registryItemRender() {
        InitHelper.itemModelRegistry(Item.getItemFromBlock(this));
    }

    public C3() {
        super(Material.ROCK);
        this.setUnlocalizedName("c3");
        this.setRegistryName("npu:c3");
        this.setHardness(2.5F);
        this.setCreativeTab(NPU.MY_TAB1);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        ModBlocks.BLOCKS.add(this);


    }


}

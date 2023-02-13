package com.tf.npu.Blocks.SUPER2FH.Desk;

import com.tf.npu.Init.SUPER2FH.ModBlocks.DeskBlocks;
import com.tf.npu.NPU;
import com.tf.npu.Template.BlockFourSideFacingTemplate;
import net.minecraft.item.ItemBlock;


public class DeskFoldableCovid19PC extends BlockFourSideFacingTemplate {
    public DeskFoldableCovid19PC() {
        super();
        this.setUnlocalizedName("desk_foldable_covid19_pc");
        this.setRegistryName("npu:desk_foldable_covid19_pc");
        this.setCreativeTab(NPU.DESK);
        DeskBlocks.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        DeskBlocks.BLOCKS.add(this);
    }

}
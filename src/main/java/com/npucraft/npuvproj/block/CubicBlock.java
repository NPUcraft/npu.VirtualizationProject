package com.npucraft.npuvproj.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class CubicBlock extends BlockCollision {
	protected AxisAlignedBB bb_ = Block.FULL_BLOCK_AABB;

	public CubicBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
	}

	public CubicBlock(Material materialIn) {
		super(materialIn);
	}

	public CubicBlock withBoundingBox(AxisAlignedBB bb) {
		bb_ = bb;
		return this;
	}

	@Override
	public AxisAlignedBB getCurrentBB(IBlockState state, IBlockAccess source, BlockPos pos) {
		return bb_;
	}

	@Override
	public RayTraceResult rayTraceTest(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start,
			Vec3d end) {
		return rayTrace(pos, start, end, getCurrentBB(blockState, worldIn, pos));
	}
}

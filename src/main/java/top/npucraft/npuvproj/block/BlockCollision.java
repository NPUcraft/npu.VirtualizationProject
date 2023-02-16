package top.npucraft.npuvproj.block;

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

public abstract class BlockCollision extends Block implements IBlockCollision {
	public BlockCollision(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
	}

	public BlockCollision(Material materialIn) {
		super(materialIn);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return getCurrentBB(state, source, pos);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return getCollisionBB(state, source, pos);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World source, BlockPos pos) {
		return getSelectedBB(state, source, pos);
	}

	@Override
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start,
			Vec3d end) {
		return rayTraceTest(blockState, worldIn, pos, start, end);
	}
}

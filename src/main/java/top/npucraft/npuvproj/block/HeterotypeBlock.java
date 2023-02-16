package top.npucraft.npuvproj.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class HeterotypeBlock extends BlockCollision {
	public HeterotypeBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
	}

	public HeterotypeBlock(Material materialIn) {
		super(materialIn);
	}

	@Override
	public RayTraceResult rayTraceTest(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start,
			Vec3d end) {
		return rayTrace(pos, start, end, getCurrentBB(blockState, worldIn, pos));
	}
}

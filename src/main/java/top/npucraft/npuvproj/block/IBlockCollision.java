package top.npucraft.npuvproj.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public interface IBlockCollision {
	public AxisAlignedBB getCurrentBB(IBlockState state, IBlockAccess source, BlockPos pos);

	public RayTraceResult collisionTest(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start,
			Vec3d end);
}

package top.npucraft.npuvproj.block;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import top.npucraft.npuvproj.proxy.CommonProxy;

public interface IBlockWithDirectionProperty {
	public PropertyDirection getDirectionProperty();

	public default AxisAlignedBB getRedirecredBB(AxisAlignedBB bb, IBlockState state, IBlockAccess source,
			BlockPos pos) throws RuntimeException {
		boolean isSymmetrical = Math.abs(1.0 - (bb.minX + bb.maxX)) < 1e-6
				&& Math.abs(1.0 - (bb.minZ + bb.maxZ)) < 1e-6;
		if (isSymmetrical) {
			return bb;
		}

		EnumFacing facing = state.getValue(getDirectionProperty());
		if (facing == null) {
			String message = "Illegal PropertyDirection for IBlockState";
			CommonProxy.logger.error(message);
			throw new RuntimeException(message);
		}

		switch (facing.getHorizontalIndex()) {
			case 2: {
				return bb;
			}
			case 0: {
				return new AxisAlignedBB(bb.minX, bb.minY, 1.0 - bb.maxZ, bb.maxX, bb.maxY, 1.0 - bb.minZ);
			}
			case 1: {
				return new AxisAlignedBB(bb.minZ, bb.minY, bb.minX, bb.maxZ, bb.maxY, bb.maxX);
			}
			case 3: {
				return new AxisAlignedBB(1.0 - bb.minZ, bb.minY, 1.0 - bb.minX, 1.0 - bb.maxZ, bb.maxY, 1.0 - bb.maxX);
			}
		}

		return bb;
	}
}

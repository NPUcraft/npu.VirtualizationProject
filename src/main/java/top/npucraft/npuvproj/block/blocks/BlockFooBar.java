package top.npucraft.npuvproj.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class BlockFooBar extends Block {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockFooBar() {
		super(Material.ROCK);
	}

	@Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getHorizontal(meta & 3);
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}
}

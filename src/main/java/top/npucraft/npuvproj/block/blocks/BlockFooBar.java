package top.npucraft.npuvproj.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFooBar extends Block {
	public static PropertyDirection PROPERTY_FACING;

	static {
		PROPERTY_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	}

	public BlockFooBar() {
		super(Material.ROCK);
	}

	/**
	 * @note 碰撞检测是由射线追踪算法实现的，模型情形下，采取的检测模式是射线与单一碰撞箱相交测试。
	 */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		AxisAlignedBB northBB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.8);
		switch (state.getValue(PROPERTY_FACING).getHorizontalIndex()) {
			case 2: {
				return northBB;
			}
			case 0: {
				return new AxisAlignedBB(northBB.minX, 0.0, 1.0 - northBB.maxZ, northBB.maxX, 1.0, 1.0 - northBB.minZ);
			}
			case 1: {
				return new AxisAlignedBB(northBB.minZ, 0.0, northBB.minX, northBB.maxZ, 1.0, northBB.maxX);
			}
			case 3: {
				return new AxisAlignedBB(1.0 - northBB.minZ, 0.0, 1.0 - northBB.minX, 1.0 - northBB.maxZ, 1.0, 1.0 - northBB.maxX);
			}
		}
		return null;
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
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, PROPERTY_FACING);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(PROPERTY_FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(PROPERTY_FACING).getHorizontalIndex();
	}

	/**
	 * @note 放置方块动作会在 Remote 和 Non-Remote 分别响应一次
	 */
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		EnumFacing placerFacing = placer.getHorizontalFacing();
		if (placer.isSneaking()) {
			placerFacing = placerFacing.getOpposite();
		}
		return getStateFromMeta(meta).withProperty(PROPERTY_FACING, placerFacing);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		if (!worldIn.isRemote) {
			String message = "BlockFooBar was placed by " + placer.getName() + " with facing="
					+ state.getValue(PROPERTY_FACING).name();
			placer.sendMessage(new TextComponentString(message));
		}
	}
}

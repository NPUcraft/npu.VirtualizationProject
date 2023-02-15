package top.npucraft.npuvproj.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.npucraft.npuvproj.block.CubicBlock;

public class BlockTent extends CubicBlock {
	public static PropertyInteger PROPERTY_ANGLE;

	static {
		PROPERTY_ANGLE = PropertyInteger.create("angle", 0, 165);
	}

	public BlockTent(Material blockMaterialIn) {
		super(blockMaterialIn);
	}

	@Override
	public RayTraceResult collisionTest(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end) {
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return new AxisAlignedBB(-0.1, 0.0, -0.1, 0.1, 1.0, 0.1).offset(pos);
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
		return new BlockStateContainer(this, PROPERTY_ANGLE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(PROPERTY_ANGLE, meta * 15);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (int) (state.getValue(PROPERTY_ANGLE) / 15);
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		int angel = 0;
		EnumFacing opposite = placer.getHorizontalFacing().getOpposite();
		if (opposite == EnumFacing.WEST || opposite == EnumFacing.EAST) {
			angel = 90;
		}
		return getStateFromMeta(meta).withProperty(PROPERTY_ANGLE, angel);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int angle = state.getValue(PROPERTY_ANGLE);
		worldIn.setBlockState(pos, state.withProperty(PROPERTY_ANGLE, (angle + 15) % 180));
		return true;
	}
}

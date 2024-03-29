package com.npucraft.npuvproj.block.blocks;

import com.npucraft.npuvproj.block.CubicBlock;
import com.npucraft.npuvproj.block.IBlockWithDirectionProperty;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFooBar extends CubicBlock implements IBlockWithDirectionProperty {
	public static PropertyDirection PROPERTY_FACING;

	static {
		PROPERTY_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	}

	public BlockFooBar() {
		super(Material.ROCK);
		withBoundingBox(new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.8));
	}

	@Override
	public PropertyDirection getDirectionProperty() {
		return PROPERTY_FACING;
	}

	@Override
	public AxisAlignedBB getCurrentBB(IBlockState state, IBlockAccess source, BlockPos pos) {
		return getRedirecredBB(bb_, state, source, pos);
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

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// NOTE: 这个逼对主副手都会触发一次
		boolean activated = playerIn.getHeldItem(EnumHand.MAIN_HAND) == ItemStack.EMPTY;
		if (hand == EnumHand.MAIN_HAND && activated) {
			EnumFacing newFacing = EnumFacing.getHorizontal(state.getValue(PROPERTY_FACING).getHorizontalIndex() + 1);
			worldIn.setBlockState(pos, state.withProperty(PROPERTY_FACING, newFacing));
		}
		return activated;
	}
}

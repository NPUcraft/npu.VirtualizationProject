package com.npucraft.npuvproj.block;

import com.npucraft.npuvproj.item.ItemBus;
import com.npucraft.npuvproj.proxy.CommonProxy;
import com.npucraft.npuvproj.utils.Config;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockBus {
	public static void registerBlock(Block blockIn) {
		ForgeRegistries.BLOCKS.register(blockIn);
		ItemBus.registerItemBlock(blockIn);
	}

	public static Block getRegisteredBlock(String name) throws RuntimeException {
		Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.ModId, name));
		if (block == null) {
			String blockId = Config.ModId + ":" + name;
			String message = "Trying to get unregistered block: " + blockId;
			CommonProxy.logger.warn(message);
			throw new RuntimeException(message);
		}
		return block;
	}
}

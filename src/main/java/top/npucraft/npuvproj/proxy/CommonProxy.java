package top.npucraft.npuvproj.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.*;
import top.npucraft.npuvproj.item.ItemBuilder;
import top.npucraft.npuvproj.item.ItemBus;
import top.npucraft.npuvproj.block.BlockBuilder;
import top.npucraft.npuvproj.block.BlockBus;

import org.apache.logging.log4j.Logger;

public abstract class CommonProxy implements IProxy {
	public static Logger logger;

	public void onPreInitialize(FMLPreInitializationEvent e) {
		logger = e.getModLog();

		ItemBus.registerItem((new ItemBuilder(new Item()))
				.withRegistryName("ash")
				.withCreativeTab("sundries")
				.build());

		BlockBus.registerBlock((new BlockBuilder(new Block(Material.ROCK)))
				.withRegistryName("chair")
				.withCreativeTab("chairs")
				.build());
	}

	public void onInitialize(FMLInitializationEvent e) {
		// TODO: CommonProxy.onInitialize
	}

	public void onPostInitialize(FMLPostInitializationEvent e) {
		// TODO: CommonProxy.onPostInitialize
	}
}

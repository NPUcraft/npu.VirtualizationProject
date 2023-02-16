package com.npucraft.npuvproj.proxy;

import com.npucraft.npuvproj.block.BlockBuilder;
import com.npucraft.npuvproj.block.BlockBus;
import com.npucraft.npuvproj.block.blocks.BlockFooBar;
import com.npucraft.npuvproj.block.blocks.BlockTent;
import com.npucraft.npuvproj.creativetab.CreativeTabsEx;
import com.npucraft.npuvproj.item.ItemBuilder;
import com.npucraft.npuvproj.item.ItemBus;
import com.npucraft.npuvproj.item.items.ItemFooBar;
import com.npucraft.npuvproj.utils.Config;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

public abstract class CommonProxy implements IProxy {
	public static Logger logger;

	public void onPreInitialize(FMLPreInitializationEvent e) {
		logger = e.getModLog();

		OBJLoader.INSTANCE.addDomain(Config.ModId);

		if (Config.IncludeFooBarSamples) {
			ItemBus.registerItem((new ItemBuilder(new ItemFooBar()))
					.withRegistryName("item_foobar")
					.withCreativeTab("foobar")
					.build());

			BlockBus.registerBlock((new BlockBuilder(new BlockFooBar()))
					.withRegistryName("block_foobar")
					.withCreativeTab("foobar")
					.build());

			CreativeTabsEx.findFirstOfLocal("foobar")
					.withLabel(true, "#ff0000")
					.withIconItem(Items.EGG);
		}

		BlockBus.registerBlock((new BlockBuilder(new BlockTent(Material.ROCK)))
				.withRegistryName("common_tent")
				.withCreativeTab("common")
				.build());
	}

	public void onInitialize(FMLInitializationEvent e) {
		// TODO: CommonProxy.onInitialize
	}

	public void onPostInitialize(FMLPostInitializationEvent e) {
		// TODO: CommonProxy.onPostInitialize
	}
}

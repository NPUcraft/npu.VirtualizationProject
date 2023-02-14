package top.npucraft.npuvproj.proxy;

import net.minecraft.init.Items;
import net.minecraftforge.fml.common.event.*;
import top.npucraft.npuvproj.item.ItemBuilder;
import top.npucraft.npuvproj.item.ItemBus;
import top.npucraft.npuvproj.item.items.ItemFooBar;
import top.npucraft.npuvproj.utils.Config;
import top.npucraft.npuvproj.block.BlockBuilder;
import top.npucraft.npuvproj.block.BlockBus;
import top.npucraft.npuvproj.block.blocks.BlockFooBar;
import top.npucraft.npuvproj.creativetab.CreativeTabsEx;

import org.apache.logging.log4j.Logger;

public abstract class CommonProxy implements IProxy {
	public static Logger logger;

	public void onPreInitialize(FMLPreInitializationEvent e) {
		logger = e.getModLog();

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
	}

	public void onInitialize(FMLInitializationEvent e) {
		// TODO: CommonProxy.onInitialize
	}

	public void onPostInitialize(FMLPostInitializationEvent e) {
		// TODO: CommonProxy.onPostInitialize
	}
}

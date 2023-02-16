package com.npucraft.npuvproj.proxy;

import com.npucraft.npuvproj.item.ItemBus;
import com.npucraft.npuvproj.utils.Config;

import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void onPreInitialize(FMLPreInitializationEvent e) {
		super.onPreInitialize(e);

		if (Config.IncludeFooBarSamples) {
			String[] samples = { "item_foobar", "block_foobar" };
			for (int i = 0; i < samples.length; ++i) {
				ItemBus.registerItemModel(ItemBus.getRegisteredItem(samples[i]), 0);
			}
		}

		ItemBus.registerItemModel(ItemBus.getRegisteredItem("common_tent"), 0);
	}
}

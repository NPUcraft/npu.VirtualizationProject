package top.npucraft.npuvproj.proxy;

import net.minecraftforge.fml.common.event.*;
import top.npucraft.npuvproj.item.ItemBus;
import top.npucraft.npuvproj.utils.Config;

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
	}
}

package top.npucraft.npuvproj.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
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
				Item foobar = ItemBus.getRegisteredItem(samples[i]);
				ModelResourceLocation location = new ModelResourceLocation(foobar.getRegistryName(), "inventory");
				ModelLoader.setCustomModelResourceLocation(foobar, 0, location);
			}
		}
	}
}

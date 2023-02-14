package top.npucraft.npuvproj.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.*;
import top.npucraft.npuvproj.item.ItemBuilder;
import top.npucraft.npuvproj.item.ItemBus;
import top.npucraft.npuvproj.block.BlockBuilder;
import top.npucraft.npuvproj.block.BlockBus;

import org.apache.logging.log4j.Logger;

public abstract class CommonProxy {
	public static Logger logger;

	public abstract void onFingerprintViolation(FMLFingerprintViolationEvent e);

	public void onPreInitialize(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		ItemBus.registerItem((new ItemBuilder(new Item())).withRegistryName("ash").withCreativeTab("sundries").build());
	}

	public void onInitialize(FMLInitializationEvent e) {
		// TODO: CommonProxy.onInitialize
	}

	public void onPostInitialize(FMLPostInitializationEvent e) {
		// TODO: CommonProxy.onPostInitialize
	}

	public abstract void onServerAboutToStart(FMLServerAboutToStartEvent e);

	public abstract void onServerStarting(FMLServerStartingEvent e);

	public abstract void onServerStarted(FMLServerStartedEvent e);

	public abstract void onServerStopping(FMLServerStoppingEvent e);

	public abstract void onServerStopped(FMLServerStoppedEvent e);
}

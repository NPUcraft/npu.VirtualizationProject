package top.npucraft.npuvproj.proxy;

import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

public abstract class CommonProxy {
	public abstract void onFingerprintViolation(FMLFingerprintViolationEvent e);

	public void onPreInitialize(FMLPreInitializationEvent e) {
		// TODO: CommonProxy.onPreInitialize
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

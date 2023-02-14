package top.npucraft.npuvproj.proxy;

import net.minecraftforge.fml.common.event.*;

public interface IProxy {
	public default void onFingerprintViolation(FMLFingerprintViolationEvent e) {
		// IGNORE
	}

	public void onPreInitialize(FMLPreInitializationEvent e);

	public void onInitialize(FMLInitializationEvent e);

	public void onPostInitialize(FMLPostInitializationEvent e);

	public default void onServerAboutToStart(FMLServerAboutToStartEvent e) {
		// IGNORE
	}

	public default void onServerStarting(FMLServerStartingEvent e) {
		// IGNORE
	}

	public default void onServerStarted(FMLServerStartedEvent e) {
		// IGNORE
	}

	public default void onServerStopping(FMLServerStoppingEvent e) {
		// IGNORE
	}

	public default void onServerStopped(FMLServerStoppedEvent e) {
		// IGNORE
	}

}

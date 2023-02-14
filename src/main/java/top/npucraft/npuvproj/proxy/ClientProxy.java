package top.npucraft.npuvproj.proxy;

import net.minecraftforge.fml.common.event.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void onFingerprintViolation(FMLFingerprintViolationEvent e) {
		// IGNORE
	}

	@Override
	public void onServerAboutToStart(FMLServerAboutToStartEvent e) {
		// IGNORE
	}

	@Override
	public void onServerStarting(FMLServerStartingEvent e) {
		// IGNORE
	}

	@Override
	public void onServerStarted(FMLServerStartedEvent e) {
		// IGNORE
	}

	@Override
	public void onServerStopping(FMLServerStoppingEvent e) {
		// IGNORE
	}

	@Override
	public void onServerStopped(FMLServerStoppedEvent e) {
		// IGNORE
	}
}

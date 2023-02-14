package top.npucraft.npuvproj;

import top.npucraft.npuvproj.proxy.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.MODID, name = ModEntry.NAME, version = ModEntry.VERSION)
public class ModEntry {
    public static final String MODID = "npuvproj";
    public static final String NAME = "NPU Virtualization Project";
    public static final String VERSION = "3.0.6_beta";

    private static Logger logger;

    @Instance(ModEntry.MODID)
    public ModEntry instance;

    @SidedProxy(serverSide = "top.npucraft.npuvproj.proxy.ServerProxy", clientSide = "top.npucraft.npuvproj.proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent e) {
        proxy.onFingerprintViolation(e);
    }

    @EventHandler
	public void onPreInitialize(FMLPreInitializationEvent e) {
		proxy.onPreInitialize(e);
	}

    @EventHandler
	public void onInitialize(FMLInitializationEvent e) {
		proxy.onInitialize(e);
	}

    @EventHandler
	public void onPostInitialize(FMLPostInitializationEvent e) {
		proxy.onPostInitialize(e);
	}

    @EventHandler
	public void onServerAboutToStart(FMLServerAboutToStartEvent e) {
        proxy.onServerAboutToStart(e);
    }

    @EventHandler
	public void onServerStarting(FMLServerStartingEvent e) {
        proxy.onServerStarting(e);
    }

    @EventHandler
	public void onServerStarted(FMLServerStartedEvent e) {
        proxy.onServerStarted(e);
    }

    @EventHandler
	public void onServerStopping(FMLServerStoppingEvent e) {
        proxy.onServerStopping(e);
    }

    @EventHandler
	public void onServerStopped(FMLServerStoppedEvent e) {
        proxy.onServerStopped(e);
    }
}

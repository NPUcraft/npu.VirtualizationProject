package top.npucraft.npuvproj;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import top.npucraft.npuvproj.proxy.*;
import top.npucraft.npuvproj.utils.Config;

@Mod(modid = Config.ModId, name = Config.ModName, version = Config.ModVersion)
public class ModEntry {
    @Instance(Config.ModId)
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

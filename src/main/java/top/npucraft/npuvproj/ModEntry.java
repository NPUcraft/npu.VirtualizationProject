package top.npucraft.npuvproj;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModEntry.MODID, name = ModEntry.NAME, version = ModEntry.VERSION)
public class ModEntry
{
    public static final String MODID = "npuvproj";
    public static final String NAME = "NPU Virtualization Project";
    public static final String VERSION = "3.0.0_beta";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //! TODO: npu.VirtualizationProject 模组初始化
    }
}

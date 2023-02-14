package top.npucraft.npuvproj.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.npucraft.npuvproj.utils.Config;
import top.npucraft.npuvproj.proxy.CommonProxy;

public class ItemBus {
	public static void registerItem(Item itemIn) {
		ForgeRegistries.ITEMS.register(itemIn);
	}

	public static void registerItemBlock(Block blockIn) {
		registerItem((new ItemBlock(blockIn)).setRegistryName(blockIn.getRegistryName()));
	}

	public static Item getRegisteredItem(String name) throws RuntimeException {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.ModId, name));
		if (item == null) {
			String itemId = Config.ModId + ":" + name;
			String message = "Trying to get unregistered item: " + itemId;
			CommonProxy.logger.warn(message);
			throw new RuntimeException(message);
		}
		return item;
	}
}

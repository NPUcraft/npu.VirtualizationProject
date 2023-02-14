package top.npucraft.npuvproj.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemBus {
	public static void registerItem(Item itemIn) {
		ForgeRegistries.ITEMS.register(itemIn);
	}

	public static void registerItemBlock(Block blockIn) {
		registerItem((new ItemBlock(blockIn)).setRegistryName(blockIn.getRegistryName()));
	}
}

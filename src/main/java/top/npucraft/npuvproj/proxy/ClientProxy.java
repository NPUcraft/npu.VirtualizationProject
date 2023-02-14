package top.npucraft.npuvproj.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.npucraft.npuvproj.ModEntry;

public class ClientProxy extends CommonProxy {
	@Override
	public void onPreInitialize(FMLPreInitializationEvent e) {
		super.onPreInitialize(e);
		Item ash = ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModEntry.MODID, "ash"));
		Item chair = ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModEntry.MODID, "chair"));
		ModelLoader.setCustomModelResourceLocation(ash, 0, new ModelResourceLocation(ash.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(chair, 0, new ModelResourceLocation(chair.getRegistryName(), "inventory"));
	}
}

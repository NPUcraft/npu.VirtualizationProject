package top.npucraft.npuvproj.item;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import top.npucraft.npuvproj.ModEntry;
import top.npucraft.npuvproj.creativetab.CreativeTabsEx;

public class ItemBuilder {
	private Item item_;

	public ItemBuilder(Item item) {
		item_ = item;
	}

	public ItemBuilder withRegistryName(String name) {
		item_.setRegistryName(name);
		item_.setUnlocalizedName(ModEntry.MODID + "." + name);
		return this;
	}

	public ItemBuilder withCreativeTab(String name) {
		String label = ModEntry.MODID + "." + name;
		CreativeTabs tab = CreativeTabsEx.findFirstOf(label);
		if (tab == null) {
			tab = new CreativeTabsEx(label);
		}
		item_.setCreativeTab(tab);
		return this;
	}

	public Item build() {
		return item_;
	}
}

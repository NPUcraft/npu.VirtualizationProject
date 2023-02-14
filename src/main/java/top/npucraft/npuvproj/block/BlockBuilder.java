package top.npucraft.npuvproj.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import top.npucraft.npuvproj.ModEntry;
import top.npucraft.npuvproj.creativetab.CreativeTabsEx;

public class BlockBuilder {
	private Block block_;

	public BlockBuilder(Block block) {
		block_ = block;
	}

	public BlockBuilder withRegistryName(String name) {
		block_.setRegistryName(name);
		block_.setUnlocalizedName(ModEntry.MODID + "." + name);
		return this;
	}

	public BlockBuilder withCreativeTab(String name) {
		String label = ModEntry.MODID + "." + name;
		CreativeTabs tab = CreativeTabsEx.findFirstOf(label);
		if (tab == null) {
			tab = new CreativeTabsEx(label);
		}
		block_.setCreativeTab(tab);
		return this;
	}

	public Block build() {
		return block_;
	}
}

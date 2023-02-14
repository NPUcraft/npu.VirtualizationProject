package top.npucraft.npuvproj.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.npucraft.npuvproj.utils.Config;

public class CreativeTabsEx extends CreativeTabs {
	public static int DefaultLabelTextColor = 0x404040;
	public static int DefaultGuiCreativeLeftWidth = 82; // ref. GuiContainerCreative
	public static int DefaultSearchFieldWidth = 89; // ref. CreativeTabs

	private boolean hasSearchBar_ = false;
	private boolean hasLabel_ = true;
	private int labelTextColor_ = DefaultLabelTextColor;
	private Item iconItem_ = Items.AIR;

	public CreativeTabsEx(String label) {
		super(label);
	}

	public static CreativeTabs findFirstOf(String label) {
		for (int i = 0; i < CREATIVE_TAB_ARRAY.length; ++i) {
			if (CREATIVE_TAB_ARRAY[i].getTabLabel() == label) {
				return CREATIVE_TAB_ARRAY[i];
			}
		}
		return null;
	}

	public static CreativeTabsEx findFirstOfLocal(String label) {
		String actualLabel = Config.ModId + ":" + label;
		for (int i = 0; i < CREATIVE_TAB_ARRAY.length; ++i) {
			if (CREATIVE_TAB_ARRAY[i].getTabLabel() == actualLabel) {
				return (CreativeTabsEx)CREATIVE_TAB_ARRAY[i];
			}
		}
		return null;
	}

	public CreativeTabsEx withIconItem(Item itemIn) {
		iconItem_ = itemIn;
		return this;
	}

	public CreativeTabsEx withLabel(boolean enabled, String hexRGB) {
		hasLabel_ = enabled;
		if (hexRGB.isEmpty()) {
			labelTextColor_ = DefaultLabelTextColor;
		} else if (hexRGB.matches("#[0-9a-fA-F]{6}")) {
			labelTextColor_ = Integer.parseInt(hexRGB.substring(1), 16);
		} else {
			// IGNORE
		}
		return this;
	}

	public CreativeTabsEx withSearchBar(boolean enabled) {
		hasSearchBar_ = enabled;
		if (hasSearchBar_) {
			setBackgroundImageName("item_search.png");
		} else {
			setBackgroundImageName("items.png");
		}
		return this;
	}

	@Override
	public int getLabelColor() {
		return labelTextColor_;
	}

	@Override
	public boolean hasSearchBar() {
		return hasSearchBar_;
	}

	@Override
	public int getSearchbarWidth() {
		return DefaultSearchFieldWidth;
		// TODO: 重定位 GUI 布局并重制搜索框背景图
		// int width = DefaultSearchFieldWidth;
		// if (!hasLabel_) {
		// width += DefaultGuiCreativeLeftWidth;
		// }
		// return width;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean drawInForegroundOfTab() {
		return hasLabel_;
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(iconItem_);
	}
}

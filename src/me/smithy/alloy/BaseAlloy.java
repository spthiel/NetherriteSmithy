package me.smithy.alloy;

import me.smithy.framework.SmithyItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BaseAlloy {
	
	private final String displayName;
	private final ItemStack mixedItem;
	private final ItemStack ingot;
	private final NamespacedKey namespacedKey;
	
	public BaseAlloy(JavaPlugin plugin, String alloyName, ItemStack mixedItem) {
		this.displayName = alloyName;
		this.namespacedKey = new NamespacedKey(plugin, stripString(displayName));
		this.mixedItem = mixedItem.clone();
		this.ingot = createIngot();
	}
	
	public ItemStack getMixedItem() {
		return mixedItem.clone();
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public ItemStack getIngot() {
		return ingot.clone();
	}
	
	private ItemStack createIngot() {
		ItemStack ingot = new ItemStack(Material.NETHERITE_INGOT);
		ItemMeta meta = ingot.getItemMeta();
		meta.setDisplayName(displayName);
		ingot.setItemMeta(meta);
		return SmithyItems.makeSmithyItem(ingot, this);
	}
	
	public NamespacedKey getNamespacedKey() {
		return namespacedKey;
	}
	
	private static String stripString(String itemName) {
		return ChatColor.stripColor(itemName).toLowerCase().replace(" ", "_");
	}
	
	@Override
	public String toString() {
		return displayName;
	}
}

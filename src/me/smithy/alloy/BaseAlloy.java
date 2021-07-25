package me.smithy.alloy;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BaseAlloy {
	
	private final String displayName;
	private final ItemStack mixedItem;
	private final ItemStack ingot;
	
	public BaseAlloy(String alloyName, ItemStack mixedItem) {
		this.displayName = alloyName;
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
		return ingot;
	}
}

package me.smithy.alloy;

import org.bukkit.inventory.ItemStack;

public abstract class BaseAlloy {
	
	private final String alloyName;
	private final ItemStack mixedItem;
	
	public BaseAlloy(String alloyName, ItemStack mixedItem) {
		this.alloyName = alloyName;
		this.mixedItem = mixedItem.clone();
	}
	
	public ItemStack getMixedItem() {
		return mixedItem.clone();
	}
	
	public String getAlloyName() {
		return alloyName;
	}
	
	public ItemStack getAlloyItem() {
		return null;
	}
}

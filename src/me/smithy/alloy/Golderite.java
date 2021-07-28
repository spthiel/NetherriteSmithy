package me.smithy.alloy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Golderite extends BaseAlloy {
	
	public Golderite(JavaPlugin plugin) {
		super(plugin, ChatColor.GOLD + "Golderite", new ItemStack(Material.GOLD_INGOT, 5));
	}
}

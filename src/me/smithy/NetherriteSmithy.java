package me.smithy;

import me.smithy.alloy.BaseAlloy;
import me.smithy.alloy.Golderite;
import me.smithy.alloy.RecipeRegistry;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.smithy.main.MainListener;

import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.GRAY;

public class NetherriteSmithy extends JavaPlugin {
	
	public static NetherriteSmithy plugin;
	public static String PREFIX = GRAY + "[" + BLUE + "NSmithy" + GRAY + "] ";
	
	@Override
	public void onEnable() {
		
		plugin = this;
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new MainListener(), this);
		
		createAlloys();
	}
	
	@Override
	public void onDisable() {
	
	}
	
	private void createAlloys() {
//		RecipeRegistry.registerAlloy(new BaseAlloy(ChatColor.GOLD + "Golderite", new ItemStack(Material.GOLD_INGOT)), this);
		RecipeRegistry.registerAlloy(new Golderite(this));
	}
	
	public String getNamespace() {
		return plugin.getName().toLowerCase(Locale.ROOT);
	}
	
}

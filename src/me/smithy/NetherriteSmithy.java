package me.smithy;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
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
		
	}
	
	@Override
	public void onDisable() {
	
	
	}
	
}

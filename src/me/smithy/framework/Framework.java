package me.smithy.framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.smithy.NetherriteSmithy;
import me.smithy.alloy.BaseAlloy;

public class Framework {
	
	private static final Framework     instance = new Framework();
	
	public static Framework getInstance() {
		
		return instance;
	}
	
	private Framework() {
	
	}
	
	public void preventItemBreak(PlayerItemBreakEvent event) {
		
		ItemStack stack = event.getBrokenItem();
		
		if (!SmithyItems.isSmithyItem(stack)) {
			return;
		}
		
		stack.setAmount(1);
		SmithyItems.setBroken(stack, true);
		
	}
	
	public void processItemEquipmentChange(PlayerEvent event) {
	
	
	
	}
	
	public void processEquipmentEvent(Event event) {
	
	}
	
}

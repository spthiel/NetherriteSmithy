package me.smithy.framework;

import java.util.HashMap;
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
	private static final NamespacedKey BASE     = new NamespacedKey(NetherriteSmithy.plugin, "base");
	private static final NamespacedKey BROKEN   = new NamespacedKey(NetherriteSmithy.plugin, "broken");
	
	public static Framework getInstance() {
		
		return instance;
	}
	
	private Framework() {
	
	}
	
	public void preventItemBreak(PlayerItemBreakEvent event) {
		
		ItemStack stack = event.getBrokenItem();
		
		if (!isSmithyItem(stack)) {
			return;
		}
		
		stack.setAmount(1);
		ItemMeta meta = stack.getItemMeta();
		assert meta != null;
		
		var container = meta.getPersistentDataContainer();
		container.set(BROKEN, PersistentDataType.BYTE, (byte)1);
		stack.setItemMeta(meta);
		
		
		
	}
	
	public void processItemEquipmentChange(PlayerEvent event) {
	
	}
	
	public void processEquipmentEvent(Event event) {
	
	}
	
	public ItemStack makeSmithyItem(ItemStack stack, BaseAlloy alloy) {
		
		if (stack.getType()
				 .equals(Material.AIR)) {
			return stack.clone();
		}
		
		ItemStack cloned = stack.clone();
		ItemMeta  meta   = cloned.getItemMeta();
		assert meta != null;
		
		var container = meta.getPersistentDataContainer();
		container.set(BASE, PersistentDataType.BYTE, (byte) 1);
		container.set(alloy.getNamespacedKey(), PersistentDataType.SHORT, (short) 1);
		cloned.setItemMeta(meta);
		return cloned;
	}
	
	private Map<BaseAlloy, Integer> getAppliedAlloys(PersistentDataContainer container) {
		var keys = container.getKeys();
		var out = new HashMap<BaseAlloy, Integer>();
		String pluginNamespace = NetherriteSmithy.plugin.getNamespace();
		for (var key : keys) {
			if (key.getNamespace().equals(pluginNamespace)) {
			
			}
		}
		
		//TODO: Rename Smithy to Smithy
		
		return null;
	}
	
	private boolean isSmithyItem(ItemStack stack) {
		
		return stack != null && stack.getItemMeta() != null && stack.getItemMeta()
																	.getPersistentDataContainer()
																	.has(BASE, PersistentDataType.BYTE);
	}
	
}

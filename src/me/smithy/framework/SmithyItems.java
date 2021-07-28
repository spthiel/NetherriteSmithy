package me.smithy.framework;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.smithy.NetherriteSmithy;
import me.smithy.alloy.BaseAlloy;

public class SmithyItems {
	
	private static final NamespacedKey BASE   = new NamespacedKey(NetherriteSmithy.plugin, "base");
	private static final NamespacedKey BROKEN = new NamespacedKey(NetherriteSmithy.plugin, "broken");
	
	public static void setBroken(ItemStack stack, boolean broken) {
		
		ItemMeta meta = stack.getItemMeta();
		assert meta != null;
		
		var container = meta.getPersistentDataContainer();
		if (broken) {
			container.set(BROKEN, PersistentDataType.BYTE, (byte) 1);
		} else {
			container.remove(BROKEN);
		}
		stack.setItemMeta(meta);
	
	}
	
	public static boolean isBroken(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		assert meta != null;
		
		var container = meta.getPersistentDataContainer();
		return container.getOrDefault(BROKEN, PersistentDataType.BYTE, (byte)0) != 1;
	}
	
	public static ItemStack makeSmithyItem(ItemStack stack, BaseAlloy alloy) {
		
		if (stack.getType()
				 .equals(Material.AIR)) {
			return stack.clone();
		}
		
		ItemStack cloned = stack.clone();
		ItemMeta  meta   = cloned.getItemMeta();
		assert meta != null;
		
		var container = meta.getPersistentDataContainer();
		container.set(BASE, PersistentDataType.BYTE, (byte) 1);
		short count = container.getOrDefault(alloy.getNamespacedKey(), PersistentDataType.SHORT, (short)0);
		container.set(alloy.getNamespacedKey(), PersistentDataType.SHORT, (short)(count+1));
		cloned.setItemMeta(meta);
		return cloned;
	}
	
	public static boolean isSmithyItem(ItemStack stack) {
		
		return stack != null && stack.getItemMeta() != null && stack.getItemMeta()
																	.getPersistentDataContainer()
																	.has(BASE, PersistentDataType.BYTE);
	}
}

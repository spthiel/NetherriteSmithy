package me.smithy.framework;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ArmorListener {
	
	public final void inventoryClick(InventoryClickEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		System.out.println(event.getClick());
		return;
		
//		if (event.getAction().equals(InventoryAction.NOTHING)) {
//			return;
//		}
//
//		if (event.getClick().equals(ClickType.SHIFT_LEFT) || event.getClick().equals(ClickType.SHIFT_RIGHT)) {
//			processShiftClick(event);
//		} else if (event.getClick().equals(ClickType.NUMBER_KEY)) {
//
//		}
		
	}
	
	private void processShiftClick(InventoryClickEvent event) {
	
	}
	
	private void processNumberClick(InventoryClickEvent event) {
	
	}
	
	private void processClick(InventoryClickEvent event) {
	
	}
	
}

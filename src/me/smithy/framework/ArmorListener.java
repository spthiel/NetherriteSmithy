package me.smithy.framework;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.PlayerInventory;

public class ArmorListener {
	
	public final void inventoryClick(InventoryClickEvent event) {
		if (event.isCancelled()) {
			return;
		}
		
		if (event.getAction().equals(InventoryAction.NOTHING)) {
			return;
		}
		
		if (!(event.getInventory() instanceof PlayerInventory)) {
			return;
		}

		var clickType = event.getClick();
		
		switch (clickType) {
			case SHIFT_LEFT:
			case SHIFT_RIGHT:
				processShiftClick(event);
				break;
			case NUMBER_KEY:
			case SWAP_OFFHAND:
				processSlotClick(event);
				break;
			case DROP:
			case CONTROL_DROP:
				processDrop(event);
				break;
			case DOUBLE_CLICK:
			case LEFT:
			case RIGHT:
			case CREATIVE:
				processClick(event);
				break;
			case MIDDLE:
			case WINDOW_BORDER_LEFT:
			case WINDOW_BORDER_RIGHT:
			case UNKNOWN:
				return;
		}
		
	}
	
	private void processShiftClick(InventoryClickEvent event) {
	
	}
	
	private void processSlotClick(InventoryClickEvent event) {
	
	}
	
	private void processDrop(InventoryClickEvent event) {
	
	}
	
	private void processClick(InventoryClickEvent event) {
	
	}
	
}

package me.smithy.main;

import me.smithy.alloy.BaseAlloy;
import me.smithy.framework.SmithyItems;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;

import me.smithy.framework.ArmorListener;

public class MainListener implements Listener {
	
	@EventHandler
	public void onSmithing(PrepareSmithingEvent event) {

		if (null == event.getResult()) {
			return;
		}
		SmithingInventory inventory = event.getInventory();
		ItemStack baseItem = inventory.getItem(0);
		ItemStack ingot = inventory.getItem(1);
		ItemStack result = inventory.getItem(2);
		
//		Bukkit.broadcastMessage("" + SmithyItems.isSmithyItem(ingot));
		if (SmithyItems.isSmithyItem(ingot)) {
			var appliedAlloys = SmithyItems.getAppliedAlloys(ingot.getItemMeta().getPersistentDataContainer());
			
			for (BaseAlloy alloy : appliedAlloys.keySet()) {
//				Bukkit.broadcastMessage("apply " + alloy);
				SmithyItems.makeSmithyItem(result, alloy);
			}
		}
		event.setResult(result);
	}
	
	@EventHandler
	public void onEntityCombust(EntityCombustEvent event) {
	
	}
	
	@EventHandler
	public void onEntityAirChange(EntityAirChangeEvent event) {
	
	}
	
	@EventHandler
	public void onEntityPotionEffect(EntityPotionEffectEvent event) {
	
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
	
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
	
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
	
	}
	
	@EventHandler
	public void onEntityTeleport(EntityTeleportEvent event) {
	
	}
	
	@EventHandler
	public void onEntityDropItem(EntityDropItemEvent event) {
	
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
	
	}
	
	@EventHandler
	public void onPlayerHarvestBlock(PlayerHarvestBlockEvent event) {
	
	}
	
	@EventHandler
	public void onPigZombieAnger(PigZombieAngerEvent event) {
	
	}
	
	@EventHandler
	public void onPlayerExpChange(PlayerExpChangeEvent event) {
	
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
	
	}

	private static final ArmorListener armorListener = new ArmorListener();
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		armorListener.inventoryClick(event);
	}
	
	@EventHandler
	public void onInventoryDrag(InventoryDragEvent event) {
	
	}
	
	@EventHandler
	public void onPlayerItemBreak(PlayerItemBreakEvent event) {
	
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
	
	}
	
}

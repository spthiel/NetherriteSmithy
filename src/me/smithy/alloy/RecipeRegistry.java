package me.smithy.alloy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class RecipeRegistry {
	
	private RecipeRegistry() {}
	
	public static void registerAlloy(BaseAlloy alloy, JavaPlugin plugin) {
		Bukkit.addRecipe(createAlloyRecipe(alloy, plugin));
	}
	
	public static ShapelessRecipe createAlloyRecipe(BaseAlloy alloy, JavaPlugin plugin) {
		ShapelessRecipe recipe = new ShapelessRecipe(new NamespacedKey(plugin, stripName(alloy.getDisplayName())), alloy.getIngot());
		recipe.addIngredient(new RecipeChoice.ExactChoice(alloy.getMixedItem()));
		return recipe;
	}
	
	public static void createSmithingRecipes(BaseAlloy alloy) {
	
	}
	
	public static SmithingRecipe createSmithingRecipe(ItemStack toolItem, ItemStack alloyItem, ItemStack resultItem) {
		return null;
	}
	
	private static String stripName(String itemName) {
		return ChatColor.stripColor(itemName).toLowerCase().replace(" ", "_");
	}
}

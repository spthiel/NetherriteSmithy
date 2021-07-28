package me.smithy.alloy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.ArrayList;
import java.util.List;

public final class RecipeRegistry {
	
	public static List<BaseAlloy> REGISTERED_ALLOYS;
	
	private RecipeRegistry() {}
	
	public static void reset() {
		REGISTERED_ALLOYS = new ArrayList<>();
	}
	
	public static void registerAlloy(BaseAlloy alloy) {
		Bukkit.addRecipe(createAlloyRecipe(alloy));
		REGISTERED_ALLOYS.add(alloy);
	}
	
	public static ShapelessRecipe createAlloyRecipe(BaseAlloy alloy) {
		ShapelessRecipe recipe = new ShapelessRecipe(alloy.getNamespacedKey(), alloy.getIngot());
		recipe.addIngredient(1, Material.NETHERITE_INGOT);
		recipe.addIngredient(alloy.getMixedItem().getAmount(), alloy.getMixedItem().getType());
		return recipe;
	}
	
	public static void executeAlloySmithing(ItemStack item, ItemStack alloy, ItemStack result) {
	
	}
}

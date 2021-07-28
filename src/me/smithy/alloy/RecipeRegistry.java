package me.smithy.alloy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;

public final class RecipeRegistry {
	
	private RecipeRegistry() {}
	
	public static void registerAlloy(BaseAlloy alloy) {
		Bukkit.addRecipe(createAlloyRecipe(alloy));
	}
	
	public static ShapelessRecipe createAlloyRecipe(BaseAlloy alloy) {
		ShapelessRecipe recipe = new ShapelessRecipe(alloy.getNamespacedKey(), alloy.getIngot());

		recipe.addIngredient(1, Material.NETHERITE_INGOT);
		recipe.addIngredient(alloy.getMixedItem().getAmount(), alloy.getMixedItem().getType());
		return recipe;
	}
	
	public static void createSmithingRecipes(BaseAlloy alloy) {
	
	}
	
	public static SmithingRecipe createSmithingRecipe(ItemStack toolItem, ItemStack alloyItem, ItemStack resultItem) {
		return null;
	}
}

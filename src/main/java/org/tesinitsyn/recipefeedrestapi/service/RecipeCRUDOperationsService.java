package org.tesinitsyn.recipefeedrestapi.service;

import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeCRUDOperationsService {
    private final RecipeRepository recipeRepository;

    public RecipeCRUDOperationsService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Integer id) {
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Integer id, Recipe recipe) {
        Optional<Recipe> recipeOptional = getRecipeById(id);
        if (recipeOptional.isPresent()) {
            Recipe existingRecipe = recipeOptional.get();
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setDescription(recipe.getDescription());
            existingRecipe.setTimeToCook(recipe.getTimeToCook());
            existingRecipe.setRecipeRating(recipe.getRecipeRating());
            existingRecipe.setRecipeName(recipe.getRecipeName());
            return recipeRepository.save(existingRecipe);
        } else {
            return null;
        }
    }

    public void deleteRecipe(Integer id) {
        recipeRepository.deleteById(id);
    }

    public void deleteAllRecipes() {
        recipeRepository.deleteAll();
    }
}

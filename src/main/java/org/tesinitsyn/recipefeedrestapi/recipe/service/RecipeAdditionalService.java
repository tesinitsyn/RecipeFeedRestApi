package org.tesinitsyn.recipefeedrestapi.recipe.service;


import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.auth.utils.JWTUtils;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.FavouriteRecipesRepository;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RecipeAdditionalService {
    RecipeRepository recipeRepository;
    JWTUtils jwtUtils;

    public RecipeAdditionalService(RecipeRepository recipeRepository, JWTUtils jwtUtils, FavouriteRecipesRepository favouriteRecipesRepository) {
        this.recipeRepository = recipeRepository;
        this.jwtUtils = jwtUtils;
    }


    public Recipe getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        Random rand = new Random();
        return recipes.get(rand.nextInt(recipes.size()));
    }

    public Optional<List<Recipe>> getUserRecipes(String authorisationHeader) {
        return recipeRepository.findRecipesByAuthor(jwtUtils.extractUsername(authorisationHeader.substring(7)));
    }
}

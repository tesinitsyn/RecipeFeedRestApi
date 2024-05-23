package org.tesinitsyn.recipefeedrestapi.recipe.service;


import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.RecipeRepository;

import java.util.List;
import java.util.Random;

@Service
public class RecipeAdditionalService {
    RecipeRepository recipeRepository;

    public RecipeAdditionalService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public Recipe getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        Random rand = new Random();
        return recipes.get(rand.nextInt(recipes.size()));
    }
}

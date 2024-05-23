package org.tesinitsyn.recipefeedrestapi.recipe.service;


import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.auth.utils.JWTUtils;
import org.tesinitsyn.recipefeedrestapi.recipe.model.FavouriteRecipes;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.FavouriteRecipesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavouritesRecipesService {
    JWTUtils jwtUtils;
    FavouriteRecipesRepository favouriteRecipesRepository;

    public FavouritesRecipesService(JWTUtils jwtUtils, FavouriteRecipesRepository favouriteRecipesRepository) {
        this.jwtUtils = jwtUtils;
        this.favouriteRecipesRepository = favouriteRecipesRepository;
    }

    public FavouriteRecipes setFavouriteRecipes(String authorizationHeader, Recipe recipe) {
        String author = jwtUtils.extractUsername(authorizationHeader.substring(7));
        return favouriteRecipesRepository.save(FavouriteRecipes.builder()
                .username(author)
                .recipe(recipe)
                .build());
    }

    public Optional<List<FavouriteRecipes>> getFavouritesRecipe(String authorizationHeader) {
        return favouriteRecipesRepository.findByUsername(jwtUtils.extractUsername(authorizationHeader.substring(7)));
    }
}

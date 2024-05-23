package org.tesinitsyn.recipefeedrestapi.recipe.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesinitsyn.recipefeedrestapi.recipe.model.FavouriteRecipes;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.service.FavouritesRecipesService;
import org.tesinitsyn.recipefeedrestapi.recipe.service.RecipeAdditionalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeAdditionalController {
    private final FavouritesRecipesService favouritesRecipesService;
    RecipeAdditionalService recipeAdditionalService;

    public RecipeAdditionalController(RecipeAdditionalService recipeAdditionalService, FavouritesRecipesService favouriteRecipes, FavouritesRecipesService favouritesRecipesService) {
        this.recipeAdditionalService = recipeAdditionalService;
        this.favouritesRecipesService = favouritesRecipesService;
    }

    @GetMapping("/getRandom")
    public ResponseEntity<Recipe> getRandom() {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeAdditionalService.getRandomRecipe());
    }

    @GetMapping("/getUsersRecipes")
    public ResponseEntity<List<Recipe>> getUsersRecipes(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        Optional<List<Recipe>> recipeList = recipeAdditionalService.getUserRecipes(authorizationHeader);
        return recipeList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addToFavourites")
    public ResponseEntity<FavouriteRecipes> addToFavourites(@RequestHeader(value = "Authorization", required = false) String authorizationHeader,
                                                            @RequestBody Recipe recipe) {
        FavouriteRecipes favouriteRecipes = favouritesRecipesService.setFavouriteRecipes(authorizationHeader, recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(favouriteRecipes);
    }

    @GetMapping("/getFavouritesRecipes")
    public Optional<List<FavouriteRecipes>> getFavouritesRecipes(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        return favouritesRecipesService.getFavouritesRecipe(authorizationHeader);
    }
}

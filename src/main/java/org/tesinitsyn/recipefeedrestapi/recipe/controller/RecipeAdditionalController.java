package org.tesinitsyn.recipefeedrestapi.recipe.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.service.RecipeAdditionalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeAdditionalController {
    RecipeAdditionalService recipeAdditionalService;

    public RecipeAdditionalController(RecipeAdditionalService recipeAdditionalService) {
        this.recipeAdditionalService = recipeAdditionalService;
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

}

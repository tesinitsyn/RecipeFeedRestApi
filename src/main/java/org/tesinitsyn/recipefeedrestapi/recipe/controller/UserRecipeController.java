package org.tesinitsyn.recipefeedrestapi.recipe.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.service.UserRecipesService;

import java.util.List;

@RestController
@RequestMapping("/api/userRecipes/")
public class UserRecipeController {


    private final UserRecipesService userRecipesService;

    public UserRecipeController(UserRecipesService userRecipesService) {
        this.userRecipesService = userRecipesService;
    }

    @GetMapping("/getById/{id}")
    public List<Recipe> getUserRecipes(@PathVariable Long id) {
        return userRecipesService.getUserRecipes(id);
    }

}

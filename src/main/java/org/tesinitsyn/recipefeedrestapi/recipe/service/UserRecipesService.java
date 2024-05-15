package org.tesinitsyn.recipefeedrestapi.recipe.service;


import org.springframework.stereotype.Service;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.model.UserRecipes;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.UserRecipesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRecipesService {

    private UserRecipesRepository userRecipesRepository;

    public UserRecipesService(UserRecipesRepository userRecipesRepository) {
        this.userRecipesRepository = userRecipesRepository;
    }

    public List<Recipe> getUserRecipes(Long userId) {

        List<UserRecipes> userRecipes = userRecipesRepository.findByUserId(userId).orElse(null);
        List<Recipe> newList = new ArrayList<>();
        assert userRecipes != null;
        for (UserRecipes userRecipe : userRecipes) {
            newList.add(userRecipe.getRecipe());
        }
        return newList;
    }
}

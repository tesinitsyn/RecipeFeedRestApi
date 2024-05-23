package org.tesinitsyn.recipefeedrestapi.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
    Optional<List<Recipe>> findRecipesByRecipeName(String name);

    Optional<List<Recipe>> findRecipesByRecipeNameLikeIgnoreCase(String name);
    Optional<List<Recipe>> findRecipesByAuthor(String author);

}

package org.tesinitsyn.recipefeedrestapi.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}

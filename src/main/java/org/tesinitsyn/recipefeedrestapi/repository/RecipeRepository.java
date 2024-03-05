package org.tesinitsyn.recipefeedrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}

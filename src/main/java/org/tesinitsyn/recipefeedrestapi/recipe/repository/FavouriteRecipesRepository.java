package org.tesinitsyn.recipefeedrestapi.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.recipe.model.FavouriteRecipes;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteRecipesRepository extends JpaRepository<FavouriteRecipes, Long> {
    Optional<List<FavouriteRecipes>> findByUsername(String username);
}

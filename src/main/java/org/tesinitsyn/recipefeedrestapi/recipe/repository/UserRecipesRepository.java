package org.tesinitsyn.recipefeedrestapi.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesinitsyn.recipefeedrestapi.recipe.model.UserRecipes;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRecipesRepository extends JpaRepository<UserRecipes, Long> {

    Optional<List<UserRecipes>> findByUserId(Long userId);
}

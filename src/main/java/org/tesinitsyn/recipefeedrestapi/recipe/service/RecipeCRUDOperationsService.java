package org.tesinitsyn.recipefeedrestapi.recipe.service;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.repository.RecipeRepository;
import org.tesinitsyn.recipefeedrestapi.recipe.utils.ImageUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeCRUDOperationsService {
    private final RecipeRepository recipeRepository;

    public RecipeCRUDOperationsService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Integer id) {
        return recipeRepository.findById(id);
    }

    @SneakyThrows
    public Recipe createRecipe(Recipe recipe, MultipartFile image) {
        Recipe newRecipe = recipeRepository.save(Recipe.builder()
                .recipeName(recipe.getRecipeName())
                .ingredients(recipe.getIngredients())
                .description(recipe.getDescription())
                .timeToCook(recipe.getTimeToCook())
                .recipeLikes(recipe.getRecipeLikes())
                .imageData(ImageUtils.newCompressor(image.getBytes())).build());
        return recipeRepository.save(newRecipe);
    }

    public Recipe updateRecipe(Integer id, Recipe recipe) {
        Optional<Recipe> recipeOptional = getRecipeById(id);
        if (recipeOptional.isPresent()) {
            Recipe existingRecipe = recipeOptional.get();
            existingRecipe.setIngredients(recipe.getIngredients());
            existingRecipe.setDescription(recipe.getDescription());
            existingRecipe.setTimeToCook(recipe.getTimeToCook());
            existingRecipe.setRecipeLikes(recipe.getRecipeLikes());
            existingRecipe.setRecipeName(recipe.getRecipeName());
            return recipeRepository.save(existingRecipe);
        } else {
            return null;
        }
    }

    public void deleteRecipe(Integer id) {
        recipeRepository.deleteById(id);
    }

    public void deleteAllRecipes() {
        recipeRepository.deleteAll();
    }

    public void add100Recipe() throws IOException {
        List<Recipe> recipes = new ArrayList<>();
        File newFile = new File("src/main/resources/image/gettyimages-73319224-1024x1024.jpg");
        Faker faker = new Faker();
        for (int i = 1; i < 100; i++) {
            String timeToCook =  new RandomDataGenerator().nextInt(1, 200) + "min";
            Integer likes = new RandomDataGenerator().nextInt(1, 1000);
            Recipe newRecipe = Recipe.builder()
                    .recipeName(faker.food().dish())
                    .ingredients(faker.food().ingredient())
                    .description( "Amazing " + faker.food().dish())
                    .timeToCook(timeToCook)
                    .recipeLikes(likes)
                    .imageData(ImageUtils.newCompressor(Files.readAllBytes(newFile.toPath()))).build();

            recipes.add(newRecipe);
        }
        recipeRepository.saveAll(recipes);
        recipeRepository.findAll();
    }
}

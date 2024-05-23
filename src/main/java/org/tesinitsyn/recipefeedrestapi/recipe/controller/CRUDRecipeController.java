package org.tesinitsyn.recipefeedrestapi.recipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tesinitsyn.recipefeedrestapi.recipe.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.recipe.service.RecipeCRUDOperationsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class CRUDRecipeController {

    private final RecipeCRUDOperationsService recipeCRUDOperationsService;

    public CRUDRecipeController(RecipeCRUDOperationsService recipeCRUDOperationsService) {
        this.recipeCRUDOperationsService = recipeCRUDOperationsService;
    }

    @GetMapping("/add100")
    public List<Recipe> addRecipe() throws IOException {
        recipeCRUDOperationsService.add100Recipe();
        return recipeCRUDOperationsService.getAllRecipe();
    }


    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<Recipe>> getRecipesByName(@PathVariable String name){
        Optional<List<Recipe>> recipeList = recipeCRUDOperationsService.getRecipesByName(name);
        return recipeList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getByNameLike/{name}")
    public ResponseEntity<List<Recipe>> getRecipesByNameLike(@PathVariable String name){
        Optional<List<Recipe>> recipeList = recipeCRUDOperationsService.getRecipesByNameLike(name);
        return recipeList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        System.out.println(authorizationHeader);
        return recipeCRUDOperationsService.getAllRecipe();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
        Optional<Recipe> recipeOptional = recipeCRUDOperationsService.getRecipeById(id);
        return recipeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestPart("data") Recipe recipe, @RequestPart("image") MultipartFile image,
                                               @RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        Recipe createRecipe = recipeCRUDOperationsService.createRecipe(recipe, image, authorizationHeader);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRecipe);
    }


    @PutMapping("/updateRecipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeCRUDOperationsService.updateRecipe(id, recipe);
        if (updatedRecipe != null) {
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("deleteRecipe/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        recipeCRUDOperationsService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllRecipes")
    public ResponseEntity<Void> deleteAllRecipe() {
        recipeCRUDOperationsService.deleteAllRecipes();
        return ResponseEntity.noContent().build();
    }
}

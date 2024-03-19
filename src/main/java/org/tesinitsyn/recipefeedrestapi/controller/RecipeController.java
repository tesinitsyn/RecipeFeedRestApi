package org.tesinitsyn.recipefeedrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tesinitsyn.recipefeedrestapi.model.Recipe;
import org.tesinitsyn.recipefeedrestapi.service.RecipeCRUDOperationsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeCRUDOperationsService recipeCRUDOperationsService;

    public RecipeController(RecipeCRUDOperationsService recipeCRUDOperationsService) {
        this.recipeCRUDOperationsService = recipeCRUDOperationsService;
    }

    //TO-DO: change return type
//    @GetMapping("/add100")
//    public List<Recipe> addRecipe(){
//        recipeCRUDOperationsService.add100Recipe();
//        return recipeCRUDOperationsService.getAllRecipe();
//    }


    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        return recipeCRUDOperationsService.getAllRecipe();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
        Optional<Recipe> recipeOptional = recipeCRUDOperationsService.getRecipeById(id);
        return recipeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addRecipe")
    public ResponseEntity<Recipe> createRecipe(@RequestPart("data") Recipe recipe, @RequestPart("image") MultipartFile image ) {

        Recipe createRecipe = recipeCRUDOperationsService.createRecipe(recipe, image);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRecipe);
    }

//    @PostMapping("/addRecipe")
//    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
//        Recipe createRecipe = recipeCRUDOperationsService.createRecipe(recipe);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createRecipe);
//    }


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

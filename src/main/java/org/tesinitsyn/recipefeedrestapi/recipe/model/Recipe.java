package org.tesinitsyn.recipefeedrestapi.recipe.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Objects;

@Entity
@Table(name = "recipes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "description")
    private String description;

    @Column(name = "time_to_cook")
    private String timeToCook;

    @Column(name = "recipe_likes")
    private Integer recipeLikes;

    @Column(name = "image_data")
    @Nullable
    private String imageData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) && Objects.equals(recipeName, recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeName);
    }


    @Override
    public String toString() {
        return "Recipe{" + "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", description='" + description + '\'' +
                ", timeToCook='" + timeToCook + '\'' +
                ", recipeLikes=" + recipeLikes +
                '}'; 
    }
}

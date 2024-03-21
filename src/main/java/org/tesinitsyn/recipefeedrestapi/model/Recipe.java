package org.tesinitsyn.recipefeedrestapi.model;

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
        final StringBuilder sb = new StringBuilder("Recipe{");
        sb.append("id=").append(id);
        sb.append(", recipeName='").append(recipeName).append('\'');
        sb.append(", ingredients='").append(ingredients).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", timeToCook='").append(timeToCook).append('\'');
        sb.append(", recipeRating=").append(recipeLikes);
        sb.append('}');
        return sb.toString();
    }
}

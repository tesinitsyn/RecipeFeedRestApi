package org.tesinitsyn.recipefeedrestapi.recipe.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favourite_recipes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author")
    private Recipe author;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}


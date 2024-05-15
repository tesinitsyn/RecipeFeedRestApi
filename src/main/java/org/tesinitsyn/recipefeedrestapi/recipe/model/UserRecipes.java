package org.tesinitsyn.recipefeedrestapi.recipe.model;


import jakarta.persistence.*;
import lombok.*;
import org.tesinitsyn.recipefeedrestapi.auth.entity.MyUser;

@Entity
@Table(name = "user_recipes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRecipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}

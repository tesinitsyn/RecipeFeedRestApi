CREATE TABLE IF NOT EXISTS recipes
(
    id    BIGSERIAL PRIMARY KEY,
    recipe_name VARCHAR(254) NOT NULL,
    ingredients  VARCHAR(200) NOT NULL,
    description VARCHAR(254) NOT NULL,
    time_to_cook VARCHAR(20)  NOT NULL,
    recipe_rating numeric(254) NOT NULL
);
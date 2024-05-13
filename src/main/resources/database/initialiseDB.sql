CREATE TABLE IF NOT EXISTS recipes
(
    id           BIGSERIAL PRIMARY KEY,
    recipe_name  VARCHAR(254) NOT NULL,
    ingredients  VARCHAR(200) NOT NULL,
    description  VARCHAR(254) NOT NULL,
    time_to_cook VARCHAR(20)  NOT NULL,
    recipe_likes BIGSERIAL,
    image_data   text
);


CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    role     VARCHAR(255)        NOT NULL
);
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


CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    role     VARCHAR(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS user_recipes
(
    id BIGINT,
    user_id   BIGINT REFERENCES users (id),
    recipe_id BIGINT REFERENCES recipes (id),
    PRIMARY KEY (id, user_id, recipe_id)
);

CREATE TABLE IF NOT EXISTS favourite_recipes
(
    user_id   BIGINT REFERENCES users (id),
    recipe_id BIGINT REFERENCES recipes (id),
    PRIMARY KEY (user_id, recipe_id)
);

CREATE TABLE IF NOT EXISTS expanses
(
    id                  BIGINT PRIMARY KEY,
    expanse_name        VARCHAR(255),
    expanse_description TEXT,
    expanse_type        VARCHAR(255),
    expanse_value       INTEGER
);


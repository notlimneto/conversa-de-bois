CREATE TABLE author(
    author_id SERIAL PRIMARY KEY,
    author_name TEXT NOT NULL,
    author_birth_year INTEGER,
    author_death_year INTEGER,
    author_image TEXT,
    city_id INTEGER,
    state_id INTEGER,
    country_id INTEGER,
    CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES city ON DELETE RESTRICT,
    CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES state ON DELETE RESTRICT,
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country ON DELETE RESTRICT
);
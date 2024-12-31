CREATE TABLE cities(
    city_id SERIAL PRIMARY KEY,
    city_name TEXT NOT NULL,
    state_id INTEGER NOT NULL,
    country_id INTEGER NOT NULL,
    CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES states ON DELETE RESTRICT,
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES countries ON DELETE RESTRICT
);
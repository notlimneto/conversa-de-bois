CREATE TABLE state(
    state_id SERIAL PRIMARY KEY,
    state_name TEXT NOT NULL,
    country_id INTEGER NOT NULL,
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES country ON DELETE RESTRICT
);
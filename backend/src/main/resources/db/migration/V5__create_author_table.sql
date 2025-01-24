CREATE TABLE author(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    birth_year INTEGER NOT NULL,
    bio TEXT,
    country_code VARCHAR(2) NOT NULL,
    state_id INTEGER,
    CONSTRAINT fk_country FOREIGN KEY (country_code) REFERENCES country(code),
    CONSTRAINT fk_state FOREIGN KEY (state_id) REFERENCES state(id)
);
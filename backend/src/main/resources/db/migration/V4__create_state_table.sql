CREATE TABLE state(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    code VARCHAR(2),
    country_code VARCHAR(2) NOT NULL,
    CONSTRAINT fk_country FOREIGN KEY (country_code) REFERENCES country(code)
);
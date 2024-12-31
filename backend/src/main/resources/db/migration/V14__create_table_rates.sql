CREATE TABLE rates(
    rate_value FLOAT NOT NULL,
    edition_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, edition_id),
    CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES editions ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE
);
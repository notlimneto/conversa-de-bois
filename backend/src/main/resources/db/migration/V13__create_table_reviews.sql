CREATE TABLE reviews(
    review_description TEXT NOT NULL,
    review_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    edition_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, edition_id),
    CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES editions ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE
);
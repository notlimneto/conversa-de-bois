CREATE TABLE review(
    review_description TEXT NOT NULL,
    review_date DATE NOT NULL,
    edition_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES edition ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user" ON DELETE CASCADE
);
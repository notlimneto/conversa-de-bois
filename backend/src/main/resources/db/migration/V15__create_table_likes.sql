CREATE TABLE likes(
    author_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY (author_id, user_id),
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE
);
CREATE TABLE authors_books(
    author_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    PRIMARY KEY (author_id, book_id),
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors ON DELETE CASCADE,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books ON DELETE CASCADE
);

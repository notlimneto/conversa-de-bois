CREATE TABLE editions(
    edition_id SERIAL PRIMARY KEY,
    edition_number INTEGER NOT NULL,
    edition_image TEXT,
    publisher_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publishers ON DELETE RESTRICT,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books ON DELETE RESTRICT
);
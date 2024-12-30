CREATE TABLE book(
    book_id SERIAL PRIMARY KEY,
    book_name TEXT NOT NULL,
    book_description TEXT,
    book_year INTEGER,
    book_image TEXT
);
CREATE TABLE book(
    id BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    description TEXT,
    year INTEGER NOT NULL,
    style TEXT
);
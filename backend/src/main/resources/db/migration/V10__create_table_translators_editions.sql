CREATE TABLE translator_edition(
    translator_id INTEGER NOT NULL,
    edition_id INTEGER NOT NULL,
    PRIMARY KEY (translator_id, edition_id),
    CONSTRAINT fk_translator FOREIGN KEY (translator_id) REFERENCES translators ON DELETE CASCADE,
    CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES editions ON DELETE CASCADE

);
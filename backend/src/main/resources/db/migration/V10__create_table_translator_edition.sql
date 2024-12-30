CREATE TABLE translator_edition(
    translator_id INTEGER NOT NULL,
    edition_id INTEGER NOT NULL,
    CONSTRAINT fk_translator FOREIGN KEY (translator_id) REFERENCES translator ON DELETE CASCADE,
    CONSTRAINT fk_edition FOREIGN KEY (edition_id) REFERENCES edition ON DELETE CASCADE

);
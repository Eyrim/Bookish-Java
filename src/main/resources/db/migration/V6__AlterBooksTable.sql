ALTER TABLE book
    ADD COLUMN author_id INT,
        ADD CONSTRAINT fk_author_id
            FOREIGN KEY (author_id)
                REFERENCES author(author_id);
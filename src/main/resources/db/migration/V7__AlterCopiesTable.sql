ALTER TABLE copies
    ADD COLUMN book_id INT,
    ADD CONSTRAINT fk_book_id
        FOREIGN KEY (book_id)
            REFERENCES book(book_id);
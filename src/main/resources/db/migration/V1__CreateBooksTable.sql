CREATE TABLE book (
    book_id SERIAL PRIMARY KEY NOT NULL,
    book_name VARCHAR(255) NOT NULL,
    isbn CHAR(13),
    genre VARCHAR(255)
);
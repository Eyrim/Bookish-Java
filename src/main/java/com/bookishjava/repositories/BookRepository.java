package com.bookishjava.repositories;

import com.bookishjava.models.database.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookName(String bookName);
}

package com.bookishjava.repositories;

import com.bookishjava.models.database.Author;
import com.bookishjava.models.database.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    Optional<Author> findById(@NonNull Long id);

    default boolean isValidAuthorId(Long id) {
        return this.findById(id).isPresent();
    }
}

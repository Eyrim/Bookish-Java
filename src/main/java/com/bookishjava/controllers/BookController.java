package com.bookishjava.controllers;

import java.util.List;

import com.bookishjava.repositories.AuthorRepository;
import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.bookishjava.models.database.Book;
import com.bookishjava.repositories.BookRepository;

@RestController
public class BookController {
    private final Logger log = LogManager.getLogger();
    @Autowired
    private final BookRepository repository;

    BookController(BookRepository repository){
        this.repository = repository;
    }

//    @GetMapping(value = "/books", produces = "application/json; charset=UTF-8")
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:5173/")
    @ResponseBody
    List<Book> getBooks(){
        return repository.findAll();
    }

    @GetMapping(value = "/books/{id}")
    @CrossOrigin(origins = "http://localhost:5173/")
    @ResponseBody
    Book getBookById(@PathVariable Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> {
                    this.log.error("Book with ID: " + id + " not found");

                    return new EntityNotFoundException(
                            "Book with ID: " +
                                    id +
                                    " not found");
                }
                );
    }

    @GetMapping(value = "/books/search/{bookName}")
    @CrossOrigin(origins = "http://localhost:5173/")
    @ResponseBody
    List<Book> getBooksByName(@PathVariable String bookName) {
        return Book.getCloseMatches(this.repository.findAll(), bookName);
    }

    @PostMapping("/books")
    @CrossOrigin(origins = "http://localhost:5173/")
    HttpStatus postBook(@RequestBody Book book) {
        try {
            this.repository.save(book);

            return HttpStatus.OK;
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}

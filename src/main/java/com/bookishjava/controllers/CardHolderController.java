package com.bookishjava.controllers;

import com.bookishjava.models.database.Book;
import com.bookishjava.models.database.CardHolder;
import com.bookishjava.repositories.CardHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardHolderController {
    @Autowired
    private CardHolderRepository repository;

    @PostMapping("/member/new/{memberName}")
    @CrossOrigin(origins = "http://localhost:5173/")
    HttpStatus postCardHolder(@PathVariable String memberName) {
        try {
            CardHolder cardHolder = new CardHolder();
            cardHolder.setName(memberName);

            this.repository.save(cardHolder);

            return HttpStatus.OK;
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}

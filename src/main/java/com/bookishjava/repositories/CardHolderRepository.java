package com.bookishjava.repositories;

import com.bookishjava.models.database.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {
    @Override
    Optional<CardHolder> findById(@NonNull Long id);
}

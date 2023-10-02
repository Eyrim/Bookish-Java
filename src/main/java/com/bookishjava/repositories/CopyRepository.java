package com.bookishjava.repositories;

import com.bookishjava.models.database.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CopyRepository extends JpaRepository<Copy, Long> {
    @Override
    Optional<Copy> findById(@NonNull Long id);
}

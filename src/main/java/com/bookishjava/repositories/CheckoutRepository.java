package com.bookishjava.repositories;

import com.bookishjava.models.database.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    @Override
    Optional<Checkout> findById(@NonNull Long id);
}

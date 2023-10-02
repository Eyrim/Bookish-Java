package com.bookishjava.models.database;

import jakarta.persistence.*;

@Entity
@Table(name = "copy")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

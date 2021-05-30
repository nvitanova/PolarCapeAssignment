package com.example.assignment.demo.service;

import com.example.assignment.demo.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(String first_name, String last_name, Integer birth_year);

}

package com.example.assignment.demo.service.impl;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.repository.jpa.JpaAuthorRepository;
import com.example.assignment.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final JpaAuthorRepository authorRepository;

    public AuthorServiceImpl(JpaAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String first_name, String last_name, Integer birth_year) {
        Author author = new Author(first_name, last_name, birth_year);
        this.authorRepository.save(author);
        return Optional.of(author);
    }
}

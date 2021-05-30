package com.example.assignment.demo.service.impl;

import com.example.assignment.demo.model.*;
import com.example.assignment.demo.model.exceptions.AuthorNotFoundException;
import com.example.assignment.demo.model.exceptions.InvalidBookException;
import com.example.assignment.demo.repository.jpa.JpaAuthorRepository;
import com.example.assignment.demo.repository.jpa.JpaBookRepository;
import com.example.assignment.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final JpaBookRepository bookRepository;
    private final JpaAuthorRepository authorRepository;

    public BookServiceImpl(JpaBookRepository bookRepository, JpaAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void deleteById(Integer isbn) {
        this.bookRepository.deleteById(isbn);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

}

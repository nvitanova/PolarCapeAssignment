package com.example.assignment.demo.service;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.PrintCopy;

import java.util.Optional;

public interface PrintCopyService {
    Optional<PrintCopy> save(Integer isbn, String title, Integer year_published, BookType book_type,
                             Author author, Integer pages, Double weight);

    Optional<PrintCopy> editBook(Integer isbn, String title, Integer year_published, BookType book_type,
                       Author author, Integer pages, Double weight);
}

package com.example.assignment.demo.service;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.EBook;

import java.util.Optional;

public interface EBookService {
    Optional<EBook> save(Integer isbn, String title, Integer year_published, BookType book_type,
                         Author author, String format, Integer size_mb);

    Optional<EBook> editBook(Integer isbn, String title, Integer year_published, BookType book_type,
                   Author author, String format, Integer size_mb);
}

package com.example.assignment.demo.service.impl;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.PrintCopy;
import com.example.assignment.demo.model.exceptions.AuthorNotFoundException;
import com.example.assignment.demo.model.exceptions.InvalidBookException;
import com.example.assignment.demo.repository.jpa.JpaAuthorRepository;
import com.example.assignment.demo.repository.jpa.JpaPrintCopyRepository;
import com.example.assignment.demo.service.PrintCopyService;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class PrintCopyServiceImpl implements PrintCopyService {

    private final JpaAuthorRepository authorRepository;
    private final JpaPrintCopyRepository pcRepository;

    public PrintCopyServiceImpl(JpaAuthorRepository authorRepository, JpaPrintCopyRepository pcRepository) {
        this.authorRepository = authorRepository;
        this.pcRepository = pcRepository;
    }

    @Override
    public Optional<PrintCopy> save(Integer isbn, String title, Integer year_published, BookType book_type, Author author, Integer pages, Double weight) {
        Author a1 = this.authorRepository.findById(author.getId())
                .orElseThrow(() -> new AuthorNotFoundException(author.getId()));

        PrintCopy book = new PrintCopy(isbn, title, year_published, a1, pages, weight);
        this.pcRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<PrintCopy> editBook(Integer isbn, String title, Integer year_published, BookType book_type, Author author, Integer pages, Double weight) {
        PrintCopy book = (PrintCopy) this.pcRepository.findById(isbn).orElseThrow(() -> new InvalidBookException(isbn));
        Author a1 = this.authorRepository.getById(author.getId());
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setYear_published(year_published);
        book.setBook_type(book_type);
        book.setAuthor(a1);
        book.setPages(pages);
        book.setWeight(weight);
        return Optional.of(this.pcRepository.save(book));
    }
}

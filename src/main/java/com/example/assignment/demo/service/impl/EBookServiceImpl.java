package com.example.assignment.demo.service.impl;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.EBook;
import com.example.assignment.demo.model.exceptions.AuthorNotFoundException;
import com.example.assignment.demo.model.exceptions.InvalidBookException;
import com.example.assignment.demo.repository.jpa.JpaAuthorRepository;
import com.example.assignment.demo.repository.jpa.JpaEBookRepository;
import com.example.assignment.demo.service.EBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EBookServiceImpl implements EBookService {
    private final JpaAuthorRepository authorRepository;
    private final JpaEBookRepository eBookRepository;

    public EBookServiceImpl(JpaAuthorRepository authorRepository, JpaEBookRepository eBookRepository) {
        this.authorRepository = authorRepository;
        this.eBookRepository = eBookRepository;
    }


    @Override
    public Optional<EBook> save(Integer isbn, String title, Integer year_published, BookType book_type, Author author, String format, Integer size_mb) {
        Author a1 = this.authorRepository.findById(author.getId())
                .orElseThrow(() -> new AuthorNotFoundException(author.getId()));

        EBook book = new EBook(isbn, title, year_published, a1, format, size_mb);
        this.eBookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<EBook> editBook(Integer isbn, String title, Integer year_published, BookType book_type, Author author, String format, Integer size_mb) {
        EBook ebook = (EBook) this.eBookRepository.findById(isbn).orElseThrow(() -> new InvalidBookException(isbn));
        Author a1 = this.authorRepository.getById(author.getId());
        ebook.setIsbn(isbn);
        ebook.setTitle(title);
        ebook.setYear_published(year_published);
        ebook.setBook_type(book_type);
        ebook.setAuthor(a1);
        ebook.setFormat(format);
        ebook.setSize_mb(size_mb);
        return Optional.of(this.eBookRepository.save(ebook));
    }
}

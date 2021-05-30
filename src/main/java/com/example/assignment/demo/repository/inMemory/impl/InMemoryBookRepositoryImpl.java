package com.example.assignment.demo.repository.inMemory.impl;

import com.example.assignment.demo.dataHolder.*;
import com.example.assignment.demo.model.Book;
import com.example.assignment.demo.repository.inMemory.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepositoryImpl implements BookRepository {
    @Override
    public Optional<Book> findById(Integer isbn) {
        return DataHolder.books.stream()
                .filter(s -> s.getIsbn() == isbn)
                .findFirst();

    }

    @Override
    public Book save(Book book) {
        this.findById(book.getIsbn()).ifPresent(DataHolder.books::remove);
        DataHolder.books.add(book);
        return book;

    }

    @Override
    public List<Book> findAll() {

        return DataHolder.books;
    }

    @Override
    public List<Book> findAllChronological() {
        DataHolder.books.sort(Book.year_published_comparator);
        return new ArrayList<>(DataHolder.books);
    }

    @Override
    public List<Book> findAllAuthorStartsWIth(String letter) {
        return DataHolder.books.stream()
                .filter(s -> s.getAuthor().getLast_name().startsWith(letter))
                .collect(Collectors.toList());
    }


    @Override
    public void oldestNewest() {
        DataHolder.books.sort(Book.year_published_comparator);
        Book oldest = DataHolder.books.get(0);
        Book newest = DataHolder.books.get(DataHolder.books.size() - 1);
        System.out.println("Oldest: " + oldest.getTitle() + " , published " + oldest.getYear_published());
        System.out.println("Newest: " + newest.getTitle() + " , published " + newest.getYear_published());
    }

}

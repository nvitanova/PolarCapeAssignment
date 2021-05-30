package com.example.assignment.demo.repository.inMemory;

import com.example.assignment.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Integer id);
    Book save (Book book);
    List<Book> findAll();
    List<Book> findAllChronological();
    List<Book> findAllAuthorStartsWIth(String letter);
    void oldestNewest();
}

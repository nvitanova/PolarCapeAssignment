package com.example.assignment.demo.repository.jpa;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.EBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaEBookRepository extends JpaRepository<EBook, Integer> {
//    Optional<EBook> save(Integer isbn, String title, Integer year_published, BookType book_type,
//                         Author author, String format, Integer size_mb);
}

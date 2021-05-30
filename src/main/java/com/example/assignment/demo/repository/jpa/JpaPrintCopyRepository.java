package com.example.assignment.demo.repository.jpa;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.BookType;
import com.example.assignment.demo.model.PrintCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface JpaPrintCopyRepository extends JpaRepository<PrintCopy, Integer> {
//    Optional<PrintCopy> save(Integer isbn, String title, Integer year_published, BookType book_type,
//                             Author author, Integer pages, Double weight);
}

package com.example.assignment.demo.repository.inMemory;

import com.example.assignment.demo.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save (Author author);
    List<Author> findAll();
    List<Author> moreThanThreeBooks();
    List<Author> booksPrintedInBirthDecade();

}

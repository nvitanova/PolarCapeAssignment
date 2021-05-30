package com.example.assignment.demo.service;

import com.example.assignment.demo.model.*;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();


    void deleteById(Integer isbn);
}

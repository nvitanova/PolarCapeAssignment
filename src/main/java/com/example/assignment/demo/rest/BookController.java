package com.example.assignment.demo.rest;

import com.example.assignment.demo.model.Book;
import com.example.assignment.demo.model.EBook;
import com.example.assignment.demo.model.PrintCopy;
import com.example.assignment.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }


    @DeleteMapping("/delete/{isbn}")
    public void deleteById( @PathVariable Integer isbn) {
        this.bookService.deleteById(isbn);
    }
}

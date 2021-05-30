package com.example.assignment.demo;

import com.example.assignment.demo.dataHolder.DataHolder;
import com.example.assignment.demo.repository.inMemory.BookRepository;
import com.example.assignment.demo.repository.inMemory.impl.InMemoryAuthorRepositoryImpl;
import com.example.assignment.demo.repository.inMemory.impl.InMemoryBookRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        InMemoryBookRepositoryImpl imBook = new InMemoryBookRepositoryImpl();
        InMemoryAuthorRepositoryImpl imAuthor = new InMemoryAuthorRepositoryImpl();
        System.out.println("Books in chronological order (by year published): " + imBook.findAllChronological());
        System.out.println("Books whose author starts with given letter: " + imBook.findAllAuthorStartsWIth("A"));
        System.out.println("Authors with books printed in same decade the author was born: " +
                imAuthor.booksPrintedInBirthDecade());
        System.out.println("Authors with more than three books: " + imAuthor.moreThanThreeBooks());
        imBook.oldestNewest();
    }

}

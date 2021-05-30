package com.example.assignment.demo.dataHolder;

import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.Book;
import com.example.assignment.demo.model.EBook;
import com.example.assignment.demo.model.PrintCopy;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static final List<Author> authors = new ArrayList<>();
    public static final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init(){
        Author a1 = new Author("Jane", "Austen", 1522);
        Author a2 = new Author("John", "Bishop", 2002);
        Author a3 = new Author("Tim", "Timson", 1976);
        Author a4 = new Author("Andre", "Anderson", 1991);


        Book b1 = new EBook(234455, "Pride", 1556, a1, "pdf", 45);
        Book b2 = new EBook(234115, "Prejudice", 2008, a4, "epub", 20);
        Book b3 = new PrintCopy(11114455, "New Book", 1996, a4, 566, 1.00);
        Book b4 = new PrintCopy(11455, "New Book", 2001, a1, 566, 1.23);
        Book b5 = new PrintCopy(100000, "New Book", 2000, a1, 566, 2.03);


        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);
    }
}

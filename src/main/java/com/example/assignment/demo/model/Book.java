package com.example.assignment.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Comparator;

@Data
@Entity
public class Book {
    @Id
    private Integer isbn;
    private String title;
    private Integer year_published;
    @Enumerated(EnumType.STRING)
    private BookType book_type;

    @ManyToOne
    private Author author;

    public Book() {}

    public Book(Integer isbn, String title, Integer year_published, BookType book_type, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.year_published = year_published;
        this.book_type = book_type;
        this.author = author;
        author.getBooks().add(this);
    }

    public static Comparator<Book> year_published_comparator = new Comparator<Book>() {

        public int compare(Book s1, Book s2) {

            int year1 = s1.getYear_published();
            int year2 = s2.getYear_published();

            return year1-year2;
        }
    };


}

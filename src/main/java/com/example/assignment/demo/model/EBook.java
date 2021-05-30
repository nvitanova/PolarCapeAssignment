package com.example.assignment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.lang.annotation.Inherited;

@Data
@Entity
public class EBook extends Book {
    private String format;
    private Integer size_mb;

    public EBook(Integer isbn, String title, Integer year_published, Author author, String format, Integer size_mb){
        super(isbn, title, year_published, BookType.EBOOK, author);
        this.format = format;
        this.size_mb = size_mb;
    }

    public EBook () {}

    @Override
    public String toString() {
        return "EBook{" +
                "isbn=" + this.getIsbn() +
                ", title='" + this.getTitle() + '\'' +
                ", year_published=" + this.getYear_published() +
                ", book_type=" + this.getBook_type() +
                ", author=" + this.getAuthor().getFirst_name() + " " + this.getAuthor().getLast_name() +
                ", format='" + format + '\'' +
                ", size_mb=" + size_mb +
                '}';
    }
}

package com.example.assignment.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Data
@Entity
public class PrintCopy extends Book {

    private Integer pages;
    private Double weight;


    public PrintCopy(Integer isbn, String title, Integer year_published, Author author, Integer pages, Double weight){
        super(isbn, title, year_published, BookType.PRINT_COPY, author);
        this.pages = pages;
        this.weight = weight;
    }

    public PrintCopy(){}

    @Override
    public String toString() {
        return "PrintCopy{" +
                "isbn=" + this.getIsbn() +
                ", title='" + this.getTitle() + '\'' +
                ", year_published=" + this.getYear_published() +
                ", book_type=" + this.getBook_type() +
                ", author=" + this.getAuthor().getFirst_name() + " " + this.getAuthor().getLast_name() +
                ", pages=" + pages +
                ", weight=" + weight +
                '}';
    }
}

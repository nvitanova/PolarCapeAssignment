package com.example.assignment.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private Integer birth_year;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Book> books = new HashSet<>();


    public Author(String first_name, String last_name, Integer birth_year) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_year = birth_year;
    }

    public Author() {}
}

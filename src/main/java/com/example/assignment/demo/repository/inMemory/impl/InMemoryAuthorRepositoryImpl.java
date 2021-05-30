package com.example.assignment.demo.repository.inMemory.impl;

import com.example.assignment.demo.dataHolder.DataHolder;
import com.example.assignment.demo.model.Author;
import com.example.assignment.demo.model.Book;
import com.example.assignment.demo.repository.inMemory.AuthorRepository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryAuthorRepositoryImpl implements AuthorRepository {

    @Override
    public Author save(Author author) {
        DataHolder.authors.add(author);
        return author;
    }


    @Override
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    @Override
    public List<Author> moreThanThreeBooks() {
        return DataHolder.authors.stream()
                .filter(s -> s.getBooks().size() >= 3)
                .collect(Collectors.toList());
    }

    @Override
    public List<Author> booksPrintedInBirthDecade() {
        List<Author> authors_to_display = new ArrayList<>();
        for (int i=0; i<DataHolder.authors.size(); i++){
            Integer birthYear = DataHolder.authors.get(i).getBirth_year();
            Integer decade = birthYear/10 * 10;
            List<Book> bookList = DataHolder.books.stream()
                    .filter(s -> s.getYear_published() >= decade && s.getYear_published() <= decade + 10)
                    .collect(Collectors.toList());
            if(!bookList.isEmpty()){
                authors_to_display.add(DataHolder.authors.get(i));
            }
        }
        return authors_to_display;
    }

}

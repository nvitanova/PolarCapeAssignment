package com.example.assignment.demo.repository.jpa;

import com.example.assignment.demo.model.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaAuthorRepository extends JpaRepository<Author, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"books"})
    @Query("select a from Author a")
    List<Author> findAll();
}

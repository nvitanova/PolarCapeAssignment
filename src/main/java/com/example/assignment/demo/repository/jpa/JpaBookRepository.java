package com.example.assignment.demo.repository.jpa;

import com.example.assignment.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, Integer> {
        List<Book> findAll();
        void deleteById(Integer isbn);

}

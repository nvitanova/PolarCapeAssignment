package com.example.assignment.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidBookException extends RuntimeException {
    public InvalidBookException(Integer id) {
        super(String.format("Book with isbn: %d is not found", id));
    }
}

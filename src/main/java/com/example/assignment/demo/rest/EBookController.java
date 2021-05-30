package com.example.assignment.demo.rest;

import com.example.assignment.demo.model.EBook;
import com.example.assignment.demo.service.EBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ebook")
public class EBookController {

    private final EBookService eBookService;

    public EBookController(EBookService eBookService) {
        this.eBookService = eBookService;
    }


    @PostMapping("/add")
    public ResponseEntity<EBook> save(@RequestBody EBook ebook){
        return this.eBookService.save(ebook.getIsbn(), ebook.getTitle(), ebook.getYear_published(), ebook.getBook_type(), ebook.getAuthor(), ebook.getFormat(), ebook.getSize_mb())
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{isbn}")
    public ResponseEntity<EBook> editEBook(@PathVariable Integer isbn, @RequestBody EBook ebook) {
        return this.eBookService.editBook(isbn, ebook.getTitle(), ebook.getYear_published(), ebook.getBook_type(), ebook.getAuthor(), ebook.getFormat(), ebook.getSize_mb())
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

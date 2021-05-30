package com.example.assignment.demo.rest;


import com.example.assignment.demo.model.EBook;
import com.example.assignment.demo.model.PrintCopy;
import com.example.assignment.demo.service.PrintCopyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/printbook")
public class PrintCopyController {
    private final PrintCopyService pcService;

    public PrintCopyController(PrintCopyService pcService) {
        this.pcService = pcService;
    }


    @PostMapping("/add")
    public ResponseEntity<PrintCopy> save(@RequestBody PrintCopy pc){
        return this.pcService.save(pc.getIsbn(), pc.getTitle(), pc.getYear_published(), pc.getBook_type(), pc.getAuthor(), pc.getPages(), pc.getWeight())
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{isbn}")
    public ResponseEntity<PrintCopy> editPrintCopy( @PathVariable Integer isbn, @RequestBody PrintCopy pc){
        return this.pcService.editBook(pc.getIsbn(), pc.getTitle(), pc.getYear_published(), pc.getBook_type(), pc.getAuthor(), pc.getPages(), pc.getWeight())
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

package com.bookstore.jpa.Controller;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;

import com.bookstore.jpa.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServices bookService;

    @PostMapping("/criar-livro")
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto) {
        BookModel savedBook = bookService.saveBook(bookRecordDto);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/ListarBooks")
    public List<BookModel> listarBooks(){
        return bookService.findBookAll();
    }

    @GetMapping("/buscarporID{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable UUID id) {
        Optional<BookModel> book = bookService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscartitle/{title}")
    public ResponseEntity<BookModel> buscarBookByTitle(@PathVariable String title) {
        Optional<BookModel> book = bookService.findBookByTitle(title);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

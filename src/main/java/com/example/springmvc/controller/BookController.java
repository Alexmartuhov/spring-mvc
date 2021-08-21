package com.example.springmvc.controller;


import com.example.springmvc.controller.dto.AuthorDto;
import com.example.springmvc.controller.dto.BookDto;
import com.example.springmvc.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    private BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> creatBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.creatBook(bookDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

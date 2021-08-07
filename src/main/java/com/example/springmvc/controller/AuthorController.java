package com.example.springmvc.controller;

import com.example.springmvc.controller.dto.AuthorDto;
import com.example.springmvc.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    private AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> creatAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.creatAuthor(authorDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }
}

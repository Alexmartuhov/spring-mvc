package com.example.springmvc.service;

import com.example.springmvc.controller.dto.BookDto;

public interface BookService {
    BookDto creatBook (BookDto bookDto);
    BookDto getBook (Integer id);
    void deleteBook (Integer id);
    BookDto editBook (Integer id);
}

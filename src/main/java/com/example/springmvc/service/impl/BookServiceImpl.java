package com.example.springmvc.service.impl;

import com.example.springmvc.controller.dto.AuthorDto;
import com.example.springmvc.controller.dto.BookDto;
import com.example.springmvc.dao.AuthorDao;
import com.example.springmvc.dao.BookDao;
import com.example.springmvc.dao.entities.AuthorEntity;
import com.example.springmvc.dao.entities.BookEntity;
import com.example.springmvc.service.BookService;

import java.util.Objects;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private AuthorDao authorDao;

    private BookServiceImpl(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public BookDto creatBook(BookDto bookDto) {
        BookEntity book = new BookEntity();
        AuthorEntity author = new AuthorEntity();
        author.setFirstName(bookDto.getAuthor().getFirstName());
        author.setSecondName(bookDto.getAuthor().getSecondName());
        authorDao.save(author);
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setDateCreated(bookDto.getDateCreated());
        book.setAuthor(author);
        bookDao.save(book);

        BookEntity result = bookDao.findByTitle(bookDto.getTitle());
        BookDto bookdto = null;
        AuthorDto authordto = null;
        if (Objects.nonNull(result)) {
            bookdto.setId(result.getId());
            bookdto.setTitle(result.getTitle());
            bookdto.setGenre(result.getGenre());
            bookdto.setDateCreated(result.getDateCreated());
            authordto.setFirstName(result.getAuthor().getFirstName());
            authordto.setSecondName(result.getAuthor().getSecondName());
            bookdto.setAuthor(authordto);
        }

        return bookdto;
    }

    @Override
    public BookDto getBook(Integer id) {
        BookEntity bookEntity = bookDao.findById(id).orElse(null);
        AuthorEntity authorEntity = bookEntity.getAuthor();
        AuthorDto authorDto = null;
        BookDto bookDto = null;
        if (Objects.nonNull(bookEntity)) {
            bookDto.setDateCreated(bookEntity.getDateCreated());
            bookDto.setGenre(bookEntity.getGenre());
            bookDto.setTitle(bookEntity.getTitle());
            bookDto.setId(bookEntity.getId());
            authorDto.setFirstName(authorEntity.getFirstName());
            authorDto.setSecondName(authorEntity.getSecondName());
            bookDto.setAuthor(authorDto);
        }
        return bookDto;
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public BookDto editBook(Integer id) {
        return null;
    }
}

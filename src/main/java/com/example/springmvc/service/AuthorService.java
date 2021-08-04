package com.example.springmvc.service;

import com.example.springmvc.controller.dto.AuthorDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    AuthorDto creatAuthor (AuthorDto authorDto);
    AuthorDto getAuthor (Integer id);
}

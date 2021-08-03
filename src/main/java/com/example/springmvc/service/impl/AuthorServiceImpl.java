package com.example.springmvc.service.impl;

import com.example.springmvc.controller.dto.AuthorDto;
import com.example.springmvc.dao.AuthorDao;
import com.example.springmvc.dao.entities.AuthorEntity;
import com.example.springmvc.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    private AuthorServiceImpl(AuthorDao author) {
        this.authorDao = authorDao;
    }

    @Override
    public AuthorDto creatAuthor(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName(authorDto.getFirstName());
        authorEntity.setSecondName(authorDto.getSecondName());
        authorDao.save(authorEntity);

        
        return authorDto;
    }
}

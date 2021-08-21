package com.example.springmvc.service.impl;

import com.example.springmvc.controller.dto.AuthorDto;
import com.example.springmvc.dao.AuthorDao;
import com.example.springmvc.dao.entities.AuthorEntity;
import com.example.springmvc.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
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


        AuthorEntity result = authorDao.findByFirstNameAndSecondName(authorDto.getFirstName(), authorDto.getSecondName());
        AuthorDto dto = null;
        if (Objects.nonNull(result)) {
            dto = new AuthorDto();
            dto.setFirstName(result.getFirstName());
            dto.setSecondName(result.getSecondName());
            dto.setId(result.getId());
        }
        return dto;
    }

    @Override
    public AuthorDto getAuthor(Integer id) {
        AuthorEntity authorEntity = authorDao.findById(id).orElse(null);
        AuthorDto authorDto = null;
        if (Objects.nonNull(authorEntity)) {
            authorDto.setId(authorEntity.getId());
            authorDto.setFirstName(authorEntity.getFirstName());
            authorDto.setSecondName(authorEntity.getSecondName());
        }
        return authorDto;
    }
}

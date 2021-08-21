package com.example.springmvc.service.impl;

import com.example.springmvc.controller.dto.UserDto;
import com.example.springmvc.dao.UserDao;
import com.example.springmvc.dao.entities.UserEntity;
import com.example.springmvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto creatUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setSecondName(userDto.getSecondName());
        userEntity.setAge(userDto.getAge());
        userEntity.setCompany(userDto.getCompany());
        userDao.save(userEntity);

        UserEntity result = userDao.findByFirstNameAndSecondName(userEntity.getFirstName(), userEntity.getSecondName());
        UserDto user = null;
        if (Objects.nonNull(result)) {
            user=new UserDto();
            user.setFirstName(result.getFirstName());
            user.setSecondName(result.getSecondName());
            user.setAge(result.getAge());
            user.setCompany(result.getCompany());
            user.setId(result.getId());
        }
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
}

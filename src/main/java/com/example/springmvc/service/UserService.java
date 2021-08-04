package com.example.springmvc.service;

import com.example.springmvc.controller.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto creatUser (UserDto userDto);
    void deleteUser (Integer id);
}

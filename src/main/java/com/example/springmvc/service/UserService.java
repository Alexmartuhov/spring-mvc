package com.example.springmvc.service;

import com.example.springmvc.controller.dto.UserDto;

public interface UserService {
    UserDto creatUser (UserDto userDto);
    void deleteUser (Integer id);
}

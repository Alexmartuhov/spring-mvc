package com.example.springmvc.controller;

import com.example.springmvc.controller.dto.UserDto;
import com.example.springmvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class UserController {
    private UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private ResponseEntity<UserDto> creatUser (@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.creatUser(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUser (@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

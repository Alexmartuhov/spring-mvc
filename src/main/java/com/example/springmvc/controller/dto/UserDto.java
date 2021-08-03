package com.example.springmvc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Integer id;
    private String firstName;
    private String secondName;
    private Integer age;
    private String company;
}

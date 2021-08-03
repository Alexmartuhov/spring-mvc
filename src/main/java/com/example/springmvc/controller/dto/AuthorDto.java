package com.example.springmvc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDto {
    private int id;
    private String firstName;
    private String secondName;
}

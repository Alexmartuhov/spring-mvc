package com.example.springmvc.controller.dto;

import com.example.springmvc.util.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private Genre genre;
    private LocalDate dateCreated;
    private AuthorDto author;
}

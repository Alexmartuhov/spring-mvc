package com.example.springmvc.dao.entities;

import com.example.springmvc.util.Genre;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Genre genre;
    private LocalDate dateCreated;
    @OneToOne
    private AuthorEntity author;
}

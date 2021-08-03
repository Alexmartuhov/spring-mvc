package com.example.springmvc.dao.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String secondName;
}

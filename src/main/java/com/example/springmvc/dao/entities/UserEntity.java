package com.example.springmvc.dao.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UserLibrary")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String secondName;
    private Integer age;
    private String company;
}

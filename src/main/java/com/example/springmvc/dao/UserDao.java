package com.example.springmvc.dao;

import com.example.springmvc.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    UserEntity findByFirstNameAndSecondName(String firstName, String secondName);
}

package com.example.springmvc.dao;

import com.example.springmvc.dao.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity,Integer> {
}

package com.yi_college.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi_college.bookmanager.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

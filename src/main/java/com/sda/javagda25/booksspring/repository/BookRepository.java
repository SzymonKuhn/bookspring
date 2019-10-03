package com.sda.javagda25.booksspring.repository;

import com.sda.javagda25.booksspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}

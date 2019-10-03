package com.sda.javagda25.booksspring.service;

import com.sda.javagda25.booksspring.model.Book;
import com.sda.javagda25.booksspring.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById (Long id) {
        return bookRepository.findById(id);
    }

    public void delete (Book book) {
        bookRepository.delete(book);
    }
}

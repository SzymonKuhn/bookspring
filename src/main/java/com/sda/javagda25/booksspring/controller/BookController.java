package com.sda.javagda25.booksspring.controller;

import com.sda.javagda25.booksspring.model.Book;
import com.sda.javagda25.booksspring.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/book/")
public class BookController {
    private final BookService bookService;

    @GetMapping("/add")
    public String add(Model model, Book book) {
        model.addAttribute("book", book);
        return "book-add";
    }

    @PostMapping("/add")
    public String add(Book book) {
        bookService.addBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String list (Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/edit/{id}")
    public String edit (Model model,
                        @PathVariable(name = "id") Long id) {
        Optional<Book> bookOptional = bookService.getById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "book-add";
        } else {
            return "redirect:book/list";
        }
    }

    @GetMapping("delete/{id}")
    public String delete (Model model,
                          @PathVariable(name = "id") Long id) {
        Optional<Book> bookOptional = bookService.getById(id);
        bookService.delete(bookOptional.get());
        return "book-list";
    }


}

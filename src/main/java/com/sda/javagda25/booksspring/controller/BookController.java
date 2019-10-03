package com.sda.javagda25.booksspring.controller;

import com.sda.javagda25.booksspring.model.Book;
import com.sda.javagda25.booksspring.model.PublishingHouse;
import com.sda.javagda25.booksspring.service.BookService;
import com.sda.javagda25.booksspring.service.PublishingHouseService;
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
    private final PublishingHouseService publishingHouseService;

    @GetMapping("/add")
    public String add(Model model, Book book) {
        List<PublishingHouse> publishingHouses = publishingHouseService.getAll();
        model.addAttribute("book", book);
        model.addAttribute("publishingHouses", publishingHouses);
        return "book-add";
    }

    @PostMapping("/add")
    public String add(Book book, Long phId) {
        Optional<PublishingHouse> optionalPublishingHouse = publishingHouseService.getById(phId);
        if (optionalPublishingHouse.isPresent()) {
            book.setPublishingHouse(optionalPublishingHouse.get());
            bookService.addBook(book);
        }
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,
                       @PathVariable(name = "id") Long id) {
        Optional<Book> bookOptional = bookService.getById(id);
        List<PublishingHouse> publishingHouses = publishingHouseService.getAll();
        if (bookOptional.isPresent()) {
            model.addAttribute("publishingHouses", publishingHouses);
            model.addAttribute("book", bookOptional.get());
            return "book-add";
        } else {
            return "redirect:/book/list";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(Model model,
                         @PathVariable(name = "id") Long id) {

        Optional<Book> bookOptional = bookService.getById(id);

        bookService.delete(bookOptional.get());
        return "redirect:/book/list";

    }

    @GetMapping ("/details/{id}")
    public String details (Model model,
                           @PathVariable("id") Long id) {
        Optional<Book> optionalBook = bookService.getById(id);
        if (optionalBook.isPresent()){
            model.addAttribute("book", optionalBook.get());
            return "book-details";
        }
        return "redirect:/book/list";
    }


}

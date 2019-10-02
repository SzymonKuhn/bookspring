package com.sda.javagda25.booksspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller ("/") //domyślnie request mapping "/"
public class IndexController {

    @GetMapping("/")//domyślnie request mapping "/"
    public String index() {
        return "index";
    }

}

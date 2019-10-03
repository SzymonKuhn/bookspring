package com.sda.javagda25.booksspring.controller;

import com.sda.javagda25.booksspring.model.PublishingHouse;
import com.sda.javagda25.booksspring.service.PublishingHouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping ("/ph/")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @GetMapping ("/add")
    public String add (Model model, PublishingHouse publishingHouse) {
        model.addAttribute("ph", publishingHouse);
        return "ph-add";
    }

    @PostMapping ("/add")
    public String add (PublishingHouse publishingHouse){
        publishingHouseService.addPublishingHouse(publishingHouse);
        return "redirect:/book/list";
    }

    @GetMapping ("/list")
    public String listAll(Model model) {
        List<PublishingHouse> phList = publishingHouseService.getAll();
        model.addAttribute("phList", phList);
        return "ph-list";
    }

//TODO edit and delete
}

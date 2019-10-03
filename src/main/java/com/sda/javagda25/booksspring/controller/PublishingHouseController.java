package com.sda.javagda25.booksspring.controller;

import com.sda.javagda25.booksspring.model.PublishingHouse;
import com.sda.javagda25.booksspring.service.PublishingHouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping ("edit/{id}")
    public String edit (Model model,
                        @PathVariable (name = "id") Long id) {
        Optional<PublishingHouse> optional = publishingHouseService.getById(id);
        if (optional.isPresent()) {
            model.addAttribute("ph", optional.get());
            return "ph-add";
        }
        return "redirect:/book/list";
    }

    @GetMapping ("delete/{id}")
    public String delete (@PathVariable ("id") Long id) {
        Optional<PublishingHouse> optional = publishingHouseService.getById(id);
        if (optional.isPresent()){
            if (optional.get().getBooks().size() == 0) {
                publishingHouseService.delete(optional.get());
            }
        }

        return "redirect:/book/list";


    }

//TODO edit and delete
}

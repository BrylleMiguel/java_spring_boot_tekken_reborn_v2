package com.cpan252.tekkenreborn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.tekkenreborn.repository.FighterRepository;

@Controller
@RequestMapping("/fighter_list")
public class FighterListController {

    /*
     * CODE BELOW with @Autowired is the same as this!
     * 
     * private FighterRepository fighterRepository
     * 
     * FighterListController(FighterRepository fighterRepository) {
     * this.fighterRepository = fighterRepository
     * }
     * 
     * 
     */

    @Autowired
    private FighterRepository fighterRepository;

    @GetMapping
    public String getFighterList() {
        return "fighter_list";
    }

    @ModelAttribute
    public void getFighterList(Model model) {
        model.addAttribute("fighters", fighterRepository.findAll());
    }
}

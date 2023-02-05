package com.cpan252.tekkenreborn.controller;
import com.cpan252.tekkenreborn.repository.impl.JdbcFighterRepository;


import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequestMapping("/design")
public class FighterDesignController {

    @Autowired
    private JdbcFighterRepository fighterRepository;

    @GetMapping
    public String design() {
        return "design";
    }

     @PostMapping
    public String processFighterAddition(@Valid Fighter fighter, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }
        log.info("Processing fighter: {}", fighter);
        // !!!THIS IS GIVING ME ERROR
        var id = fighterRepository.save(fighter);
        log.info("Saved fighter with id: {}", id);
        return "redirect:/design";
    }
}

package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.repository.FighterRepository;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private FighterRepository fighterRepository;

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
        fighterRepository.save(fighter);
        return "redirect:/fighter_list";
    }

    @ModelAttribute("animes")
    public EnumSet<Anime> animes() {
        var animes = EnumSet.allOf(Anime.class);
        log.info("animes converted to string:  {}", animes);
        return animes;
    }

    @ModelAttribute
    public Fighter fighter() {
        return Fighter
                .builder()
                .build();
    }
}

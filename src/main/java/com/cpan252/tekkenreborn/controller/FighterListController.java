package com.cpan252.tekkenreborn.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.dto.FighterSearchByDateDTO;
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

    @ModelAttribute()
    public void fighterSearchByDateDTO(Model model) {
        model.addAttribute("fighterSearchByDateDTO", new FighterSearchByDateDTO());
    }

    @ModelAttribute("fighters")
    public Iterable<Fighter> fighters() {
        return fighterRepository.findAll();
    }

    @GetMapping
    public String getFighterList() {
        return "fighter_list";
    }

    @PostMapping
    public String searchFighterNameStartsWithAndCreatedAtBetween(
            @ModelAttribute FighterSearchByDateDTO fighterSearchByDateDTO, Model model) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("fighters",
                fighterRepository.findByNameStartsWithAndCreatedAtBetween(fighterSearchByDateDTO.getName(),
                        LocalDate.parse(fighterSearchByDateDTO.getStartDate(), dateFormatter),
                        LocalDate.parse(fighterSearchByDateDTO.getEndDate(), dateFormatter)));

        return "fighter_list";
    }

}

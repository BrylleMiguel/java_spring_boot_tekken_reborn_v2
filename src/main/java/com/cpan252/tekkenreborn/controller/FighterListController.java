package com.cpan252.tekkenreborn.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.dto.FighterSearchByDateDTO;
import com.cpan252.tekkenreborn.repository.FighterRepository;
import com.cpan252.tekkenreborn.repository.FighterRepositoryPaginated;

@Controller
@RequestMapping("/fighter_list")
public class FighterListController {

    private static final int PAGE_SIZE = 3;

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

    @Autowired
    private FighterRepositoryPaginated fighterRepositoryPaginated;

    @ModelAttribute()
    public void fighterSearchByDateDTO(Model model) {
        model.addAttribute("fighterSearchByDateDTO", new FighterSearchByDateDTO());
    }

    @ModelAttribute
    public void fightersPage(Model model) {
        Page<Fighter> fightersPage = fighterRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("fighters", fightersPage);
        model.addAttribute("currentPage", fightersPage.getNumber());
        model.addAttribute("totalPages", fightersPage.getTotalPages());
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

    @GetMapping("/switchPage")
    public String switchPage(Model model,
            @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "fighter_list";
        }
        var fighterPage = fighterRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("fighters", fighterPage.getContent());
        model.addAttribute("currentPage", fighterPage.getNumber());
        return "fighter_list";
    }

}

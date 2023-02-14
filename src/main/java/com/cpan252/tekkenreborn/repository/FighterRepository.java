package com.cpan252.tekkenreborn.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpan252.tekkenreborn.model.Fighter;

public interface FighterRepository extends CrudRepository<Fighter, Double> {
    // don't need this anymore.
    // Iterable<Fighter> findAll();
    // Optional<Fighter> findById(Long id);
    // void save(Fighter fighter);
}
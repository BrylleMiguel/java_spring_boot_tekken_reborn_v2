package com.cpan252.tekkenreborn;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.repository.FighterRepository;

@SpringBootApplication
public class TekkenrebornApplication {

	public static void main(String[] args) {
		SpringApplication.run(TekkenrebornApplication.class, args);

	}

	@Bean
	CommandLineRunner dataLoader(FighterRepository fighterRepository) {
		return args -> {
			fighterRepository.save(Fighter.builder()
					.name("Monkey D. Luffy")
					.animeFrom(Anime.ONE_PIECE)
					.damagePerHit(57)
					.health(1500)
					.resistance(BigDecimal.valueOf(9.9)).build());

			fighterRepository.save(Fighter.builder()
					.name("Naruto Uzumaki")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(61)
					.health(1750)
					.resistance(BigDecimal.valueOf(9.8)).build());

			fighterRepository.save(Fighter.builder()
					.name("Roronoa Zoro")
					.animeFrom(Anime.ONE_PIECE)
					.damagePerHit(57)
					.health(1500)
					.resistance(BigDecimal.valueOf(9.9)).build());

			fighterRepository.save(Fighter.builder()
					.name("Sasuke Uchiha")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(61)
					.health(1750)
					.resistance(BigDecimal.valueOf(9.8)).build());

			fighterRepository.save(Fighter.builder()
					.name("Vinsmoke Sanji")
					.animeFrom(Anime.ONE_PIECE)
					.damagePerHit(57)
					.health(1500)
					.resistance(BigDecimal.valueOf(9.9)).build());

			fighterRepository.save(Fighter.builder()
					.name("Sakura Haruno")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(61)
					.health(1750)
					.resistance(BigDecimal.valueOf(9.8)).build());

			fighterRepository.save(Fighter.builder()
					.name("Nami Bellmere")
					.animeFrom(Anime.ONE_PIECE)
					.damagePerHit(57)
					.health(1500)
					.resistance(BigDecimal.valueOf(9.9)).build());

			fighterRepository.save(Fighter.builder()
					.name("Kakashi Hatake")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(61)
					.health(1750)
					.resistance(BigDecimal.valueOf(9.8)).build());

			fighterRepository.save(Fighter.builder()
					.name("God Ussop")
					.animeFrom(Anime.ONE_PIECE)
					.damagePerHit(57)
					.health(1500)
					.resistance(BigDecimal.valueOf(9.9)).build());

			fighterRepository.save(Fighter.builder()
					.name("Jiraiya of the Sannin")
					.animeFrom(Anime.NARUTO)
					.damagePerHit(61)
					.health(1750)
					.resistance(BigDecimal.valueOf(9.8)).build());
		};
	}
}

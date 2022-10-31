package archunit.kata.layered.controllers;

import archunit.kata.layered.domain.SuperHero;
import archunit.kata.layered.repositories.SuperHeroRepository;
import archunit.kata.layered.services.SuperHeroService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperHeroController {
    private final SuperHeroService superHeroService;
    private final SuperHeroRepository superHeroRepository;

    private void violateDomain() {
        var agg = new SuperHero();
        agg.behave();
    }
}
package archunit.kata.layered.controllers;

import archunit.kata.layered.repositories.SuperHeroRepository;
import archunit.kata.layered.services.SuperHeroService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperHeroController {
    private final SuperHeroService superHeroService;
    private final SuperHeroRepository superHeroRepository;
}
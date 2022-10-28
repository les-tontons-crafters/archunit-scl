package layered.controllers;

import layered.repositories.SuperHeroRepository;
import layered.services.SuperHeroService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperHeroController {
    private final SuperHeroService superHeroService;
    private final SuperHeroRepository superHeroRepository;
}
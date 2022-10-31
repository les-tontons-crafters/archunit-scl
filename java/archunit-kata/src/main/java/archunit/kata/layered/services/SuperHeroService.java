package archunit.kata.layered.services;

import archunit.kata.layered.repositories.SuperHeroRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperHeroService {
    private final SuperHeroRepository repository;
}

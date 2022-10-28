package layered.services;

import layered.repositories.SuperHeroRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperHeroService {
    private final SuperHeroRepository repository;
}

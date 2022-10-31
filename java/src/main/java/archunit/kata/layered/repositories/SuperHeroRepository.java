package archunit.kata.layered.repositories;

import archunit.kata.layered.domain.SuperHero;

import java.util.concurrent.CompletableFuture;

public interface SuperHeroRepository {
    CompletableFuture<SuperHero> save(SuperHero superHero);
}

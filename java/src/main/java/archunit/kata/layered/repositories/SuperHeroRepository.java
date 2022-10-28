package archunit.kata.layered.repositories;

import java.util.concurrent.CompletableFuture;

public interface SuperHeroRepository {
    CompletableFuture<SuperHeroEntity> save(SuperHeroEntity superHero);
}

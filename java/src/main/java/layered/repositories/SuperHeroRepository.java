package layered.repositories;

import java.util.concurrent.CompletableFuture;

public interface SuperHeroRepository {
    CompletableFuture<SuperHeroEntity> Save(SuperHeroEntity superHero);
}

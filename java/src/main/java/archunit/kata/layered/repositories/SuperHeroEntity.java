package archunit.kata.layered.repositories;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
public class SuperHeroEntity {
    private final UUID id;
    private final String name;
    private final ArrayList<String> powers;
}

package archunit.kata.layered.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
@Data
public class SuperHero {
    private final UUID id;
    private final String name;
    private final ArrayList<String> powers;
}

package main;

import main.animals.Animal;
import main.enclosures.Enclosure;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Enclosure<? extends Animal>> enclosures = new ArrayList<>();

    public int getCountOfAnimals() {
        int count = 0;
        for (Enclosure<? extends Animal> enclosure : enclosures) {
            count += enclosure.getOccupiedSpaces();
        }
        return count;
    }

    public void addEnclosure(Enclosure<? extends Animal> enclosure) {
        enclosures.add(enclosure);
    }
}

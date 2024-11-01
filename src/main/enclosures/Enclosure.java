package main.enclosures;

import main.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclosure<T extends Animal> {
    private final int capacity;
    private final List<T> animals = new ArrayList<>();

    public Enclosure(int capacity) {
        this.capacity = capacity;
    }

    public int getMaxCapacity() {
        return capacity;
    }

    public int getOccupiedSpaces() {
        return animals.size();
    }

    public void addAnimal(T animal) {
        if (this.getOccupiedSpaces() >= this.getMaxCapacity()) {
            throw new IllegalStateException("All places in the enclosure are occupied!");
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        if (!animals.remove(animal)) {
            throw new IllegalStateException("Specified animal is not in the enclosure!");
        }
    }
}

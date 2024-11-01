package main.enclosures;

import main.animals.Bird;

public class BirdEnclosure<T extends Bird> extends Enclosure<T> {
    public BirdEnclosure(int capacity) {
        super(capacity);
    }
}

package main.enclosures;

import main.animals.Mammal;

public abstract class MammalEnclosure<T extends Mammal> extends Enclosure<T> {
    public MammalEnclosure(int capacity) {
        super(capacity);
    }
}

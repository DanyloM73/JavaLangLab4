package main.enclosures;

import main.animals.Lion;

public class LionEnclosure<T extends Lion> extends MammalEnclosure<T> {
    public LionEnclosure(int capacity) {
        super(capacity);
    }
}

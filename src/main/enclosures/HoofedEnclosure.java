package main.enclosures;

import main.animals.Hoofed;

public class HoofedEnclosure<T extends Hoofed> extends MammalEnclosure<T> {
    public HoofedEnclosure(int capacity) {
        super(capacity);
    }
}

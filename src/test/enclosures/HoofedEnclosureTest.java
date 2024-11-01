package test.enclosures;

import main.animals.*;
import main.enclosures.HoofedEnclosure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HoofedEnclosureTest {
    private HoofedEnclosure<Hoofed> hoofedEnclosure;

    @BeforeEach
    void setUp() {
        hoofedEnclosure = new HoofedEnclosure<>(3);
    }

    @Test
    void testAddHoofedAnimalSuccessfully() {
        hoofedEnclosure.addAnimal(new Zebra());
        hoofedEnclosure.addAnimal(new Giraffe());
        assertEquals(2, hoofedEnclosure.getOccupiedSpaces(), "Hoofed enclosure should have 2 animals.");
    }

    @Test
    void testAddHoofedAnimalExceedsCapacity() {
        hoofedEnclosure.addAnimal(new Zebra());
        hoofedEnclosure.addAnimal(new Giraffe());
        hoofedEnclosure.addAnimal(new Zebra());
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            hoofedEnclosure.addAnimal(new Giraffe());
        });
        assertEquals("All places in the enclosure are occupied!", exception.getMessage());
    }

    @Test
    void testOnlyHoofedCanBeAdded() {
        assertDoesNotThrow(() -> hoofedEnclosure.addAnimal(new Zebra()), "Should allow Hoofed instances.");
        assertDoesNotThrow(() -> hoofedEnclosure.addAnimal(new Giraffe()), "Should allow Hoofed instances.");

//        assertDoesNotThrow(() -> hoofedEnclosure.addAnimal(new Eagle()), "Should not allow non-Hoofed instances.");
//        assertDoesNotThrow(() -> hoofedEnclosure.addAnimal(new Lion()), "Should not allow non-Hoofed instances.");
    }

    @Test
    void testRemoveHoofedSuccessfully() {
        Giraffe giraffe = new Giraffe();
        Zebra zebra = new Zebra();
        hoofedEnclosure.addAnimal(giraffe);
        hoofedEnclosure.addAnimal(zebra);
        hoofedEnclosure.removeAnimal(giraffe);
        hoofedEnclosure.removeAnimal(zebra);
        assertEquals(0, hoofedEnclosure.getOccupiedSpaces(), "Hoofed enclosure should be empty.");
    }

    @Test
    void testRemoveHoofedMissingSpecified() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            hoofedEnclosure.removeAnimal(new Zebra());
        });
        assertEquals("Specified animal is not in the enclosure!", exception.getMessage());
    }

    @Test
    void testOnlyHoofedCanBeRemoved() {
        Giraffe giraffe = new Giraffe();
        Zebra zebra = new Zebra();
        hoofedEnclosure.addAnimal(giraffe);
        hoofedEnclosure.addAnimal(zebra);
        assertDoesNotThrow(() -> hoofedEnclosure.removeAnimal(giraffe), "Should allow Hoofed instances.");
        assertDoesNotThrow(() -> hoofedEnclosure.removeAnimal(zebra), "Should allow Hoofed instances.");

//        assertDoesNotThrow(() -> hoofedEnclosure.removeAnimal(new Lion()), "Should not allow non-Hoofed instances.");
//        assertDoesNotThrow(() -> hoofedEnclosure.removeAnimal(new Eagle()), "Should not allow non-Hoofed instances.");
    }
}

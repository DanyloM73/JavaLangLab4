package test.enclosures;

import main.animals.*;
import main.enclosures.BirdEnclosure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BirdEnclosureTest {
    private BirdEnclosure<Bird> birdEnclosure;

    @BeforeEach
    void setUp() {
        birdEnclosure = new BirdEnclosure<>(1);
    }

    @Test
    void testAddBirdSuccessfully() {
        birdEnclosure.addAnimal(new Eagle());
        assertEquals(1, birdEnclosure.getOccupiedSpaces(), "Bird enclosure should have 1 eagle.");
    }

    @Test
    void testAddBirdExceedsCapacity() {
        birdEnclosure.addAnimal(new Eagle());
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            birdEnclosure.addAnimal(new Eagle());
        });
        assertEquals("All places in the enclosure are occupied!", exception.getMessage());
    }

    @Test
    void testOnlyBirdsCanBeAdded() {
        assertDoesNotThrow(() -> birdEnclosure.addAnimal(new Eagle()), "Should allow Bird instances.");

//        assertDoesNotThrow(() -> birdEnclosure.addAnimal(new Giraffe()), "Should not allow non-Bird instances.");
//        assertDoesNotThrow(() -> birdEnclosure.addAnimal(new Lion()), "Should not allow non-Bird instances.");
//        assertDoesNotThrow(() -> birdEnclosure.addAnimal(new Zebra()), "Should not allow non-Bird instances.");
    }

    @Test
    void testRemoveBirdSuccessfully() {
        Eagle eagle = new Eagle();
        birdEnclosure.addAnimal(eagle);
        birdEnclosure.removeAnimal(eagle);
        assertEquals(0, birdEnclosure.getOccupiedSpaces(), "Bird enclosure should be empty.");
    }

    @Test
    void testRemoveBirdMissingSpecified() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            birdEnclosure.removeAnimal(new Eagle());
        });
        assertEquals("Specified animal is not in the enclosure!", exception.getMessage());
    }

    @Test
    void testOnlyBirdsCanBeRemoved() {
        Eagle eagle = new Eagle();
        birdEnclosure.addAnimal(eagle);
        assertDoesNotThrow(() -> birdEnclosure.removeAnimal(eagle), "Should allow Bird instances.");

//        assertDoesNotThrow(() -> birdEnclosure.removeAnimal(new Giraffe()), "Should not allow non-Bird instances.");
//        assertDoesNotThrow(() -> birdEnclosure.removeAnimal(new Lion()), "Should not allow non-Bird instances.");
//        assertDoesNotThrow(() -> birdEnclosure.removeAnimal(new Zebra()), "Should not allow non-Bird instances.");
    }
}

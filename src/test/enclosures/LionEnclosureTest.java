package test.enclosures;

import main.animals.*;
import main.enclosures.LionEnclosure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LionEnclosureTest {

    private LionEnclosure<Lion> lionEnclosure;

    @BeforeEach
    void setUp() {
        lionEnclosure = new LionEnclosure<>(2);
    }

    @Test
    void testAddLionSuccessfully() {
        lionEnclosure.addAnimal(new Lion());
        lionEnclosure.addAnimal(new Lion());
        assertEquals(2, lionEnclosure.getOccupiedSpaces(), "Lion enclosure should have 2 lions.");
    }

    @Test
    void testAddLionExceedsCapacity() {
        lionEnclosure.addAnimal(new Lion());
        lionEnclosure.addAnimal(new Lion());
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            lionEnclosure.addAnimal(new Lion());
        });
        assertEquals("All places in the enclosure are occupied!", exception.getMessage());
    }

    @Test
    void testOnlyLionsCanBeAdded() {
        assertDoesNotThrow(() -> lionEnclosure.addAnimal(new Lion()), "Should allow Lion instances.");

//        assertDoesNotThrow(() -> lionEnclosure.addAnimal(new Giraffe()), "Should not allow non-Lion instances.");
//        assertDoesNotThrow(() -> lionEnclosure.addAnimal(new Eagle()), "Should not allow non-Lion instances.");
//        assertDoesNotThrow(() -> lionEnclosure.addAnimal(new Zebra()), "Should not allow non-Lion instances.");
    }

    @Test
    void testRemoveLionSuccessfully() {
        Lion lion = new Lion();
        lionEnclosure.addAnimal(lion);
        lionEnclosure.removeAnimal(lion);
        assertEquals(0, lionEnclosure.getOccupiedSpaces(), "Lion enclosure should be empty.");
    }

    @Test
    void testRemoveLionMissingSpecified() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            lionEnclosure.removeAnimal(new Lion());
        });
        assertEquals("Specified animal is not in the enclosure!", exception.getMessage());
    }

    @Test
    void testOnlyLionsCanBeRemoved() {
        Lion lion = new Lion();
        lionEnclosure.addAnimal(lion);
        assertDoesNotThrow(() -> lionEnclosure.removeAnimal(lion), "Should allow Lion instances.");

//        assertDoesNotThrow(() -> lionEnclosure.removeAnimal(new Giraffe()), "Should not allow non-Lion instances.");
//        assertDoesNotThrow(() -> lionEnclosure.removeAnimal(new Eagle()), "Should not allow non-Lion instances.");
//        assertDoesNotThrow(() -> lionEnclosure.removeAnimal(new Zebra()), "Should not allow non-Lion instances.");
    }
}

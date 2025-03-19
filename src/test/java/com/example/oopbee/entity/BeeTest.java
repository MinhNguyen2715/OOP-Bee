package test.java.com.example.oopbee.entity;

import com.example.oopbee.entity.Bee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeeTest {
    private TestBee bee;

    // A concrete subclass of Bee for testing
    private static class TestBee extends Bee {
        TestBee(String type) {
            this.setType(type);
        }
    }

    @BeforeEach
    void setUp() {
        bee = new TestBee("Worker");
    }

    @Test
    void testInitialValues() {
        assertEquals(100, bee.getHealth(), "Bee should start with 100 health.");
        assertTrue(bee.isAlive(), "Bee should start as alive.");
    }

    @Test
    void testSetHealthDoesNotExceedThreshold() {
        bee.setHealth(50);
        assertEquals(50, bee.getHealth(), "Health should update correctly.");
        assertTrue(bee.isAlive(), "Worker should be alive above 70 health.");
    }

    @Test
    void testWorkerBeeDiesBelowThreshold() {
        bee.setHealth(69);  // Just above the threshold
        assertTrue(bee.isAlive(), "Worker should still be alive at 69 health.");

        bee.setHealth(70);  // At the threshold
        assertTrue(bee.isAlive(), "Worker should still be alive at 70 health.");

        bee.setHealth(10);  // Below the threshold
        assertFalse(bee.isAlive(), "Worker should die when health < 70.");
    }

    @Test
    void testDamageReducesHealth() {
        int initialHealth = bee.getHealth();
        bee.damage();
        assertTrue(bee.getHealth() < initialHealth, "Health should decrease after damage.");
    }

    @Test
    void testDamageDoesNotGoBelowZero() {
        bee.setHealth(1);
        bee.damage();
        assertEquals(0, bee.getHealth(), "Health should not go below 0.");
        assertFalse(bee.isAlive(), "Bee should be dead when health reaches 0.");
    }

    @Test
    void testToStringMethod() {
        bee.setHealth(80);
        assertEquals("Worker\t80\talive", bee.toString(), "toString() should match expected format.");
        bee.setHealth(60);
        assertEquals("Worker\t60\tdead", bee.toString(), "toString() should reflect status change.");
    }
}


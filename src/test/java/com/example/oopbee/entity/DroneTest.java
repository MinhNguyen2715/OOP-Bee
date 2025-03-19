package test.java.com.example.oopbee.entity;

import com.example.oopbee.entity.Drone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DroneTest {
    private Drone drone;

    @BeforeEach
    void setUp() {
        drone = new Drone();
    }

    @Test
    void testDroneInitialization() {
        assertEquals("Drone", drone.getType(), "Drone should have type 'Drone'.");
        assertEquals(100, drone.getHealth(), "Drone should start with 100 health.");
        assertTrue(drone.isAlive(), "Drone should start alive.");
    }

    @Test
    void testDroneTakesDamage() {
        int initialHealth = drone.getHealth();
        drone.damage();
        assertTrue(drone.getHealth() < initialHealth, "Drone health should decrease after taking damage.");
    }

    @Test
    void testDroneDiesWhenHealthBelow50() {
        drone.setHealth(49);
        assertFalse(drone.isAlive(), "Drone should die if health drops below 50.");
    }

    @Test
    void testDeadDroneRemainsDead() {
        drone.setHealth(0);
        assertFalse(drone.isAlive(), "Drone should be dead when health is 0.");
        drone.damage();  // Attack again
        assertEquals(0, drone.getHealth(), "Dead Drone should remain at 0 health.");
    }
}


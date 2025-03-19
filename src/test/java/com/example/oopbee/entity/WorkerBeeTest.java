package test.java.com.example.oopbee.entity;

import com.example.oopbee.entity.WorkerBee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerBeeTest {
    private WorkerBee workerBee;

    @BeforeEach
    void setUp() {
        workerBee = new WorkerBee();
    }

    @Test
    void testWorkerBeeInitialization() {
        assertEquals("Worker", workerBee.getType(), "WorkerBee should have type 'Worker'.");
        assertEquals(100, workerBee.getHealth(), "WorkerBee should start with 100 health.");
        assertTrue(workerBee.isAlive(), "WorkerBee should start alive.");
    }

    @Test
    void testWorkerBeeTakesDamage() {
        int initialHealth = workerBee.getHealth();
        workerBee.damage();
        assertTrue(workerBee.getHealth() < initialHealth, "WorkerBee health should decrease after taking damage.");
    }

    @Test
    void testWorkerBeeDiesWhenHealthBelow70() {
        workerBee.setHealth(69);
        assertFalse(workerBee.isAlive(), "WorkerBee should die if health drops below 70.");
    }

    @Test
    void testDeadWorkerBeeRemainsDead() {
        workerBee.setHealth(0);
        assertFalse(workerBee.isAlive(), "WorkerBee should be dead when health is 0.");
        workerBee.damage();  // Attack again
        assertEquals(0, workerBee.getHealth(), "Dead WorkerBee should remain at 0 health.");
    }
}

package test.java.com.example.oopbee.business;

import com.example.oopbee.business.BeeHive;
import com.example.oopbee.entity.Bee;
import com.example.oopbee.entity.Drone;
import com.example.oopbee.entity.QueenBee;
import com.example.oopbee.entity.WorkerBee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BeeHiveTest {
    private BeeHive beeHive;

    @BeforeEach
    void setUp() {
        beeHive = new BeeHive();
        beeHive.init();
    }

    @Test
    void testBeeHiveInitialization() {
        List<Bee> bees = beeHive.getAllBees();
        assertNotNull(bees, "Bee list should not be null.");
        assertEquals(10, bees.size(), "Bee list should contain 10 bees.");
    }

    @Test
    void testBeeHiveContainsValidBeeTypes() {
        for (Bee bee : beeHive.getAllBees()) {
            assertTrue(bee instanceof QueenBee || bee instanceof WorkerBee || bee instanceof Drone,
                    "Bee list should contain only QueenBee, WorkerBee, or Drone.");
        }
    }

    @Test
    void testAttackBeesReducesHealth() {
        List<Bee> bees = beeHive.getAllBees();
        int[] initialHealth = bees.stream().mapToInt(Bee::getHealth).toArray();

        beeHive.attackBees();

        for (int i = 0; i < bees.size(); i++) {
            assertTrue(bees.get(i).getHealth() < initialHealth[i],
                    "Bee's health should decrease after attack.");
        }
    }

    @Test
    void testDeadBeesStayDead() {
        List<Bee> bees = beeHive.getAllBees();

        // Reduce all bees' health to 0
        for (Bee bee : bees) {
            bee.setHealth(0);
        }

        beeHive.attackBees();

        for (Bee bee : bees) {
            assertEquals(0, bee.getHealth(), "Dead bees should have 0 health.");
            assertFalse(bee.isAlive(), "Dead bees should stay dead.");
        }
    }
}



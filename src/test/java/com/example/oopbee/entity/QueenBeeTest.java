package test.java.com.example.oopbee.entity;

import com.example.oopbee.entity.QueenBee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueenBeeTest {
    private QueenBee queenBee;

    @BeforeEach
    void setUp() {
        queenBee = new QueenBee();
    }

    @Test
    void testQueenBeeInitialization() {
        assertEquals("Queen", queenBee.getType(), "QueenBee should have type 'Queen'.");
        assertEquals(100, queenBee.getHealth(), "QueenBee should start with 100 health.");
        assertTrue(queenBee.isAlive(), "QueenBee should start alive.");
    }

    @Test
    void testQueenBeeTakesDamage() {
        int initialHealth = queenBee.getHealth();
        queenBee.damage();
        assertTrue(queenBee.getHealth() < initialHealth, "QueenBee health should decrease after taking damage.");
    }

    @Test
    void testQueenBeeDiesWhenHealthBelow20() {
        queenBee.setHealth(19);
        assertFalse(queenBee.isAlive(), "QueenBee should die if health drops below 20.");
    }

    @Test
    void testDeadQueenBeeRemainsDead() {
        queenBee.setHealth(0);
        assertFalse(queenBee.isAlive(), "QueenBee should be dead when health is 0.");
        queenBee.damage();  // Attack again
        assertEquals(0, queenBee.getHealth(), "Dead QueenBee should remain at 0 health.");
    }
}


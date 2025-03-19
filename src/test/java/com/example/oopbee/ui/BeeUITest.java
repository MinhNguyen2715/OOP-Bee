package test.java.com.example.oopbee.ui;


import com.example.oopbee.entity.Bee;
import com.example.oopbee.entity.QueenBee;
import com.example.oopbee.entity.WorkerBee;
import com.example.oopbee.entity.Drone;

import com.example.oopbee.ui.BeeUI;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeeUITest {

    @Test
    void testShowBees() {
        // Redirect system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create a mock bee list
        List<Bee> bees = Arrays.asList(new QueenBee(), new WorkerBee(), new Drone());

        // Call showBees
        BeeUI.showBees(bees);

        // Restore system output
        System.setOut(System.out);

        // Verify output
        String output = outputStream.toString();
        assertTrue(output.contains("Queen\t100\talive"), "Output should contain QueenBee details.");
        assertTrue(output.contains("Worker\t100\talive"), "Output should contain WorkerBee details.");
        assertTrue(output.contains("Drone\t100\talive"), "Output should contain DroneBee details.");
    }
}

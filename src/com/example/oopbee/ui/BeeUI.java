package com.example.oopbee.ui;

import com.example.oopbee.business.BeeHive;
import com.example.oopbee.entity.Bee;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * UI Class
 */
public class BeeUI {
    private static final Logger LOGGER = Logger.getLogger(BeeUI.class.getName());

    public static void main(String[] args) {
        BeeHive bh = null;
        boolean keepRunning = true;
        Scanner s = new Scanner(System.in);
        int choice;

        while (keepRunning) {
            // Menu
            LOGGER.info("--------------Bee hive--------------");
            LOGGER.info("\t1 – Create bee list");
            LOGGER.info("\t2 – Attack bees");
            LOGGER.info("\t3 - Exit");
            LOGGER.info("Enter your choice (1, 2 or 3): ");

            if (s.hasNextInt()) {
                choice = s.nextInt();
            } else {
                LOGGER.warning("Invalid input. Please enter a number.");
                s.next(); // Consume invalid input
                continue;
            }

            List<Bee> bees;
            switch (choice) {
                case 1:
                    bh = new BeeHive();
                    bh.init();
                    bees = bh.getAllBees();
                    LOGGER.info("Bees details at the beginning:");
                    showBees(bees);
                    break;
                case 2:
                    if (bh == null) {
                        LOGGER.warning("No bee!");
                    } else {
                        bh.attackBees();
                        bees = bh.getAllBees();
                        LOGGER.info("Bees details at the moment:");
                        showBees(bees);
                    }
                    break;
                case 3:
                    keepRunning = false;
                    LOGGER.info("Exiting application.");
                    break;
                default:
                    LOGGER.warning("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        s.close();
    }

    public static void showBees(List<Bee> bees) {
        for (Bee bee : bees) {
            LOGGER.info(bee.toString());
        }
    }
}

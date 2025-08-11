package org.algorithm.KB과제.Array.주차3.Q3;

import java.util.Scanner;

public class ReservationSystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(10);
        printMenu();
        int choice = 0;
        while (choice != 4) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    restaurant.reserveTable();
                    break;
                case 2:
                    restaurant.cancelReservation();
                    break;
                case 3:
                    System.out.println("Current tables available: " + restaurant.getAvailableTables());
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    System.exit(0);
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println(
            "1. Reserve a table\n"
                + "2. Cancel a reservation\n"
                + "3. Show current status\n"
                + "4. Exit\n"
                + "Enter your choice: "
        );

    }
}

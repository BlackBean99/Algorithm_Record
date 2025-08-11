package org.algorithm.KB과제.Array.주차3.Q3;

public class Restaurant {

    private int availableTables;

    public Restaurant(int availableTables) {
        this.availableTables = availableTables;
    }

    public boolean reserveTable() {
        availableTables--;
        System.out.println("Table reserved, Tables left: " + availableTables);
        return true;
    }
    public boolean cancelReservation() {
        availableTables++;
        System.out.println("Reservation canceled, Tables abailable: " + availableTables);
        return true;
    }
    public int getAvailableTables() {
        return this.availableTables;
    }

}

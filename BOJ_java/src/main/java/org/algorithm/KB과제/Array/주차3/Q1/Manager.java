package org.algorithm.KB과제.Array.주차3.Q1;

public class Manager extends Employee{

    public static void main(String[] args) {
        Manager manager = new Manager(5000);
        System.out.println(manager.toString());
        manager.test();
    }

    public Manager(int bonus) {
        super("123 Main st", "John Doe", 123456789,50000);
        this.bonus = bonus;
    }

    private int bonus;
    public void test() {
        System.out.println("This is a test method in the Manager class.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Manager [" +
            "bonus=" + bonus +
            ']';
    }
}

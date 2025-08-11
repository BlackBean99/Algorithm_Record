package org.algorithm.KB과제.Array.주차3.Q1;

public class Employee{
    private String name;
    private String address;
    private int salary;
    private int rrn;

    public Employee(String address, String name, int rrn, int salary) {
        this.address = address;
        this.name = name;
        this.rrn = rrn;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee [" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", salary=" + salary +
            ", rrn=" + rrn +
            ']';
    }
}
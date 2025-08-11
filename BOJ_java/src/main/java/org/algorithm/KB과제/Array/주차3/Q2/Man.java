package org.algorithm.KB과제.Array.주차3.Q2;

public class Man extends Person{

    public Man(int age, String name, int power) {
        super(age, name);
        this.power = power;
    }

    int power;

    public void run() {
        super.eat();
        System.out.println(super.name + "이(가) 빠르게 달립니다");
    }

    @Override
    public String toString() {
        return super.toString() +
            ", power=" + power;
    }
}

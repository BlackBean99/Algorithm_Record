package org.algorithm.KB과제.Array.주차3.Q2;

public class Person {
    String name;
    int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void eat(){
        System.out.println(name + "이(가) 밥을 먹습니다.");
    }

    @Override
    public String toString() {
        return "[" +
            "name='" + name + '\'' +
            ", age=" + age;
    }
}
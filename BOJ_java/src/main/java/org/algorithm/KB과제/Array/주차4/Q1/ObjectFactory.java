package org.algorithm.KB과제.Array.주차4.Q1;

public class ObjectFactory {
    public static Fruit getFruit(String fruitName) {
        if (fruitName.equals("apple")) {
            return new AppleClass();
        } else if (fruitName.equals("banana")) {
            return new BananaClass();
        } else if (fruitName.equals("ice")) {
            return new IceClass();
        } else {
            return null;
        }
    }

}

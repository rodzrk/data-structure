package com.array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++)
            array.addLast(i);
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.add(5, 500);
        System.out.println(array);
    }
}

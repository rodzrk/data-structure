package com.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for (int i = 0; i < 10; i++)
            array.addLast(i);
        System.out.println(array);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        array.add(1, 100);
        System.out.println(array);
        // [0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        array.addFirst(-1);
        System.out.println(array);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        array.remove(2);
        System.out.println(array);
        // [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        array.removeElement(3);
        System.out.println(array);
        // [-1, 0, 1, 2, 4, 5, 6, 7, 8, 9]

        array.removeFirst();
        System.out.println(array);
        // [0, 1, 2, 4, 5, 6, 7, 8, 9]
    }
}

package com.set;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        FileReader.readFile("D:\\develop\\git\\study\\data-structure\\Set\\src\\main\\resources\\a-tale-of-two-cities.txt", words);
        System.out.println("Total words: " + words.size());

        BSTSet<String> bstSet = new BSTSet<>();
        words.forEach(s -> {
            bstSet.add(s);
        });
        System.out.println("Total different words: " + bstSet.getSize());

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        words.forEach(s -> {
            linkedListSet.add(s);
        });
        System.out.println("Total different words: " + linkedListSet.getSize());

    }
}

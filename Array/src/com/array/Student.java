package com.array;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return String.format("Student(name: %s, age: %d)", name, age);
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("Alice", 18));
        studentArray.addLast(new Student("Bob", 28));
        studentArray.addLast(new Student("Cor", 68));
        System.out.println(studentArray);
    }
}

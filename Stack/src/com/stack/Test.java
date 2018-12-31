package com.stack;

import java.util.Random;

public class Test {
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random r = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(r.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;

        // 对于以下两种栈的实现,其时间复杂度是同一个数量级的,但是由于数组栈有resize操作,同时链表栈有new的操作,因而其执行时间比较相对比较复杂

        double time1 = testStack(new ArrayStack<>(), opCount);
        System.out.println("ArrayStack: time = " + time1 + "s.");

        double time2 = testStack(new LinkedListStack<>(), opCount);
        System.out.println("LinkedListStack: time = " + time2 + "s.");
    }
}

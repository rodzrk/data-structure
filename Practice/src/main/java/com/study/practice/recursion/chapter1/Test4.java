package com.study.practice.recursion.chapter1;

/**
 * 编写非递归函数计算n!
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n--;
        }
        return result;
    }
}

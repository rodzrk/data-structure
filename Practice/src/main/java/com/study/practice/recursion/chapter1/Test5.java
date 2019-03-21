package com.study.practice.recursion.chapter1;

/**
 * 1. 编写计算斐波那契数列Fn的递归函数
 * 2. 说明对于任意n>2的整数,调用Fn时,同一个Fi会被处理至少一次
 * 3. 使用非递归实现斐波那契数列
 * 0、1、1、2、3、5、8、13、21、34、……
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(recursion(9));
        System.out.println(F(9));
    }

    /**
     * 非递归求解斐波那切数列
     *
     * @param n
     * @return
     */
    private static int F(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 递归求解斐波那契数列
     *
     * @param n
     * @return
     */
    private static int recursion(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }
}

package com.study.practice.recursion.chapter1;

import java.util.Scanner;

/**
 * 编写模板函数Input,要求用户输入一个非负数,验证这个数是否大于或等于0,如果不是提示非法,需要重新输入一个数
 * 在函数非成功退出之前,应给用户三次机会,如果输入成功,返回true并将输入的数作为引用参数返回,反之返回false
 */
public class Test2 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(Input());
    }

    private static boolean Input() {
        System.out.println("请输入一个整数:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num >= 0) {
            return true;
        } else {
            if (count == 2)
                return false;
            count++;
            return Input();
        }
    }
}

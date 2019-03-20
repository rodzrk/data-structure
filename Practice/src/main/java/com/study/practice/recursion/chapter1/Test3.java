package com.study.practice.recursion.chapter1;

/**
 * 测试数组a中的元素是否是按升序排列(即a[i]<=a[i+1],其中0<=i<n-1)
 * 是返回true,反之返回false
 */
public class Test3 {
    public static void main(String[] args) {
//        int[] array = {1};
//        int[] array = {1, 2, 3};
//        int[] array = {1, 4, 3};
//        int[] array = {3, 2, 3};
        int[] array = {11, 12, 13, 1};
        System.out.println(isRise(array, 0));
    }

    private static boolean isRise(int[] array, int i) {
        if (i == array.length - 1) {
            return true;
        }
        if (array[i] > array[i + 1]) {
            return false;
        } else {
            return isRise(array, i + 1);
        }
    }
}

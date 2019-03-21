package com.study.practice.recursion.chapter1;

/**
 * 使用递归确定元素x是否属于数组a[0:n-1]
 * 其中0:n-1表示索引范围
 */
public class Test7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(containEle(array, 4, 3));
    }

    private static boolean containEle(int[] array, int n, int x) {
        if (n > array.length || n <= 0)
            throw new UnsupportedOperationException();
        if (array[n-1] == x) {
            return true;
        }
        if (n == 1) {
            return false;
        } else {
            return containEle(array, --n, x);
        }
    }
}

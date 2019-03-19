package com.study.practice.recursion.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构第一章
 * C++程序设计基础
 * 递归练习
 */

public class Test1 {
    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Perm<Integer> perm = new Perm<>();
        perm.perm(list,0,3);
    }


}

/**
 * 使用递归函数生成全排列
 */
class Perm<T> {

    // 生成list集合中索引k到m间所有元素的全排列,默认k与m范围为[0,list.size()-1]
    public void perm(List<T> list, int k, int m) {
        if (k == m) {
            for (int i = 0; i <= m; i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, k, i);
            }
        }
    }

    /**
     * 交换list集合中k索引和m索引处的值
     *
     * @param list
     * @param k
     * @param m
     */
    private void swap(List<T> list, int k, int m) {
        T temp = list.get(k);
        list.set(k, list.get(m));
        list.set(m, temp);
    }
}
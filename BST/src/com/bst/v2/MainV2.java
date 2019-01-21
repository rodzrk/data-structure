package com.bst.v2;

public class MainV2 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 7, 2, 4, 6, 8};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////////////
        //                     //
        //          5          //
        //        /   \        //
        //       3     7       //
        //      / \   / \      //
        //     2  4  6   8     //
        //                     //
        /////////////////////////

//        System.out.println("<========================>");
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println("<========================>");
//        bst.inOrder();
//        System.out.println();
//        bst.inOrderNR();
//        System.out.println("<========================>");
//        bst.postOrder();

//        System.out.println("<========================>");
//        bst.levelOrder();

//        System.out.println("<========================>");
//        System.out.println(bst);

        System.out.println("<============获取二分搜索树的最小值============>");
        System.out.println(bst.minimum());
        System.out.println("<============获取二分搜索树的最大值============>");
        System.out.println(bst.maximum());
        System.out.println("<============删除二分搜索树的最小值============>");
        System.out.println(bst.removeMin());
        System.out.println(bst);
        System.out.println("<============删除二分搜索树的最大值============>");
        System.out.println(bst.removeMax());
        System.out.println(bst);
    }
}

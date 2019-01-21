package com.bst.v1;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树(Binary-Search-Tree)插入新元素
     * 1. root为空,添加root
     * 2. root非空,向以root为根的树下插入元素
     *
     * @param e
     */
    public void add(E e) {
        if (null == root) {
            root.e = e;
            size++;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以node节点为根节点的二分搜索树下插入元素
     * 1. 递归的本质是拆分逻辑为一个最小单位
     * 2. 递归逻辑操作的主要实现一般是从逻辑的最后(最小单位)起,慢慢执行到逻辑最开始,如弹栈的场景
     * 3. 书写递归第一步,首先写最小单位的逻辑(终止条件)
     * 4. 书写递归第二步,写如何进入到最小单位
     *
     * @param node
     * @param e
     */
    public void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }
}

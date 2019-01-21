package com.bst.v2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 优化添加操作相对于v1版本
 *
 * @param <E>
 */
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
        root = add(root, e);
    }

    /**
     * 向以node节点为根节点的二分搜索树下插入元素
     * 以节点为单位的思想
     *
     * @param node
     * @param e
     */
    public Node add(Node node, E e) {
        // 1. 首先对最小单位进行操作(即终止条件),"让元素挂到null上"
        if (null == node) {
            size++;
            return new Node(e);
        }

        // 2. 想方设法进入最小条件,即分解逻辑,要么添加插到left,要么插到right,相等时不操作
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * 查看是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 查看以node为根节点的子树是否包含元素e
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (null == node)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else //e.compareTo(node.e)>0
            return contains(node.right, e);
    }

    /**
     * 二叉搜索树的前序遍历,递归实现
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根节点的二叉搜索树,递归实现
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (null == node)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历,非递归实现
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (null != node.right)
                stack.push(node.right);
            if (null != node.left)
                stack.push(node.left);
        }
    }

    /**
     * 中序遍历,递归实现
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根节点的二叉搜索树,递归实现
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (null == node)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //todo
    public void inOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        Node nod = root;
        while (!stack.isEmpty() || nod != null) {
            while (nod != null) {
                stack.push(nod);
                nod = nod.left;
            }
            Node sNode = stack.pop();
            System.out.print(sNode.e + " ");
            nod = sNode.right;
        }
    }

    /**
     * 后序遍历二叉搜索树,递归实现
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根节点的二叉搜索树,递归实现
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (null == node)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return minimum(root).e;
    }

    /**
     * 返回以node为根节点的二分搜索树的最小元素所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (null == node.left)
            return node;
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return maximum(root).e;
    }

    /**
     * 返回以node为根节点的二分搜索树的最大元素所在节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (null == node.right)
            return node;

        return maximum(node.right);
    }

    /**
     * 删除二分搜索树的最小值
     *
     * @return
     */
    public E removeMin() {
        E res = minimum();
        root = this.removeMin(root);
        return res;
    }

    /**
     * 删除以node为根节点的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树的最大值
     *
     * @return
     */
    public E removeMax() {
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    /**
     * 删除以node为根节点的二分搜索树的最大节点,
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (null == node.right) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根节点的二叉搜索树中元素为e的节点
     * 返回删除节点后新的二叉搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (null == node)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e)==0
            // 待删除节点左子树为空
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return node;
            }
            // 待删除节点的右子树为空
            if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return node;
            }
            // 待删除节点(暂时命名为n)左右子树均不为空
            // 找出n的右子树中的最小节点即后继节点(在该右子树中删除该节点),该节点的右节点为n的原右子树
            // 后继节点的左子树为n的原左子树
            // 删除n
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
//            size++;// 新增了successor节点
            successor.left = node.left;
            node.left = node.right = null;
//            size--;// 删除了原节点
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点,深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * 生成表示深度的字符串,--对应一个单位深度
     *
     * @param depth
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}

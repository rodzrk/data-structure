package com.linkedlist;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定'索引'处添加元素e
     * 练习使用,替换为采用虚拟头节点dummyHead的添加方式add
     * 逻辑不适用于当前
     *
     * @param index
     * @param e
     * @see LinkedList#add(int, Object)
     */
    @Deprecated
    private void oldAdd(int index, E e) {
//        if (index < 0 || index > size)
//            throw new IllegalArgumentException("Add failed. Index illegal. ");
//
//        if (index == 0) {
//            addFirst(e);
//        } else {
//            Node prev = head;
//            for (int i = 0; i < index-1; i++)
//                prev = prev.next;
//
//            prev.next = new Node(e, prev.next);
//            size++;
//        }
    }

    /**
     * 向指定索引处添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Index is illegal. ");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表末尾添加元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取某个索引下的元素e
     * 练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 指定索引处修改e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    /**
     * 判断链表中是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定索引的元素,并返回指定元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除链表中等于给定值 e 的所有节点。
     *
     * @param e
     * @return
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (e.equals(prev.next.e))
                break;
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: ");
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}

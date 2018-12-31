package com.stack;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    /**
     * 获取栈大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return data.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("top ");
        sb.append(data.toString());
        return sb.toString();

    }
}

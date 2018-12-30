package com.queue;

public interface Queue<E> {
    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return
     */
    E getFront();

    /**
     * 获取队列大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}

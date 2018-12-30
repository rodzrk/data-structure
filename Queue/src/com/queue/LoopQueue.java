package com.queue;

/**
 * 循环队列实现
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;// 容器
    private int front;// 头元素索引
    private int tail;// 尾元素索引
    private int size;// 队列大小

    /**
     * 循环队列中需要额外的一个空间来区分队列为空与队列满
     *
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return res;
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return data[front];
    }

    /**
     * 获取数组大小
     * TODO 后续不设置size实现循环队列,命名为MyLoopQueque
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 获取队列容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * front==tail时,表示队列为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 自动扩容,扩容后重置front为0
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(front + i) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}

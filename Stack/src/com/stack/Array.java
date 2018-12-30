package com.stack;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 初始化一个数组
     *
     * @param capacity 初始容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造,默认容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素的最后添加新元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素之前添加新元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定index位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size. ");

        if (size == data.length)
            resize(data.length * 2);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    /**
     * 获取指定索引下的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("Get failed. Index is illegal. ");

        return data[index];
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 更新某个索引下的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("Set failed. Index is illegal. ");

        data[index] = e;
    }

    /**
     * 判断数组中是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 正向查找数组中是否包含指定元素,包含则返回索引,不包含则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除某个索引的元素,并返回删除元素的值
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E res = data[index];
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        size = size - 1;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    /**
     * 删除第一个元素,返回元素值
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素,返回元素值
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 正向遍历删除遇到的第一个e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = this.find(e);
        if (-1 != index)
            remove(index);
    }

    /**
     * 重新设置数组容量大小
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i < size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}

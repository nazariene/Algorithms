package ru.nazariene.stack;

import java.lang.reflect.Array;

public class ArrayStack implements Stack {

    private static int DEFAULT_CAPACITY = 5;
    private int[] arr;
    private int size;

    public ArrayStack() {
        this.arr = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void push(int value) {
        ensureCapacity();
        arr[size++] = value;
    }

    @Override
    public int pop() {
        if (size == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }

        int value = arr[--size];
        ensureCapacity();

        return value;
    }

    @Override
    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return arr[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        int newSize;
        if (size < arr.length/2 && size > DEFAULT_CAPACITY) {
            newSize = arr.length/2;
        } else if (size == arr.length) {
            newSize = arr.length*2;
        } else {
            return;
        }

        int[] newArray = new int[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }

        //Well, could've used Array copy, but meh
        arr = newArray;
    }
}

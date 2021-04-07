package ru.nazariene.stack;

public class LinkedListStack implements Stack {

    private Node head;

    public LinkedListStack() {
        this.head = null;
    }

    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.link = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }

        int result = head.value;
        head = head.link;

        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }

        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        public Node link;
        public int value;
    }
}

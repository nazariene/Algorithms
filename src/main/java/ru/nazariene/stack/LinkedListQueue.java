package ru.nazariene.stack;

public class LinkedListQueue implements Queue {

    private Node head;
    private Node tail;

    @Override
    public void enqueue(int value) {
        Node newNode = new Node();
        newNode.value = value;

        if (tail == null) {
            this.tail = this.head = newNode;
            return;
        }

        tail.link = newNode;
        tail = newNode;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        int result = head.value;
        head = head.link;

        if (head == null) {
            this.tail = null;
        }
        return result;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!");
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    private class Node {
        public Node link;
        public int value;
    }
}

package ru.nazariene.search;

public class RBTTestImpl<KEY extends Comparable<KEY>, VALUE> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    Node root;

    class Node {
        Node left;
        Node right;
        KEY key;
        VALUE value;
        int size;
        boolean color;

        Node(KEY key, VALUE value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public void put(KEY key, VALUE value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, KEY key, VALUE value) {
        if (node == null) {
            return new Node(key, value, RED);
        }

        int compareKeyResult = key.compareTo(node.key);

        if (compareKeyResult > 0) {
            node.right = put(node.right, key, value);
        } else if (compareKeyResult < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        } else if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        } else if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        node.size = 1 + size(node.left) + size(node.right);

        return node;
    }

    public void delete(KEY key) {
        root = delete(root, key);
    }

    private Node delete(Node node, KEY key) {
        if (node == null) {
            return null;
        }

        int compareKeyResult = key.compareTo(node.key);

        if (compareKeyResult > 0) {
            node.right = delete(node.right, key);
        } else if (compareKeyResult < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    private int size(Node node) {
        return node != null ? node.size : 0;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;

        return left;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }
}

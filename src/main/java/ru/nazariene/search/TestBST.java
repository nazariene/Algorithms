package ru.nazariene.search;

public class TestBST<KEY extends Comparable<KEY>, VALUE> {

    Node root;

    class Node {
        Node left;
        Node right;
        KEY key;
        VALUE value;
        int size;

        Node(KEY key, VALUE value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(KEY key, VALUE value) {
        root = put(root, key, value);
    }

    public VALUE get(KEY key) {
        return get(root, key);
    }

    public void delete(KEY key) {
        delete(root, key);
    }

    private void delete(Node node, KEY key) {
        
    }

    private VALUE get(Node node, KEY key) {
        if (node == null) {
            return null;
        }

        int compareResult = key.compareTo(node.key);

        if (compareResult == 0) {
            return node.value;
        }
        else if (compareResult > 0) {
            return get(node.right, key);
        }
        else {
            return get(node.left, key);
        }
    }

    private Node put(Node node, KEY key, VALUE value) {
        if (node == null) {
            return new Node(key, value);
        }


        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = put(node.right, key, value);
        }
        else if (compareResult < 0) {
            node.left = put(node.left, key, value);
        }
        else {
            node.value = value;

        }

        node.size = 1 + size(node.left) + size(node.right);

        return node;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.size;
    }

}

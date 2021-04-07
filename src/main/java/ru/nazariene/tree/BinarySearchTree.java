package ru.nazariene.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    private class Node {
        public Node left;
        public Node right;
        public int value;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            Node newNode = new Node();
            newNode.value = value;
            return newNode;
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value < current.value) {
            return containsRecursive(current.left, value);
        } else if (value > current.value) {
            return containsRecursive(current.right, value);
        } else {
            return true;
        }
    }

    public void delete(int value) {
        root = deleteResursive(root, value);
    }

    private Node deleteResursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteResursive(current.left, value);
            return current;
        } else if (value > current.value) {
            current.right = deleteResursive(current.right, value);
            return current;
        }

        //We must delete current node
        //Check if it has children
        if (current.left == null) {
            return current.right;
        }

        if (current.right == null) {
            return current.left;
        }

        //Now, we have both left and right child nodes.
        int smallestValueOnRightSide = findSmallestValue(current.right);
        current.value = smallestValueOnRightSide;
        current.right = deleteResursive(current.right, smallestValueOnRightSide);
        return current;

    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }

    public int[] traverseBFS() {
        int[] result = new int[1000]; //should calculate proper size, but too lazy ATM :)
        int k = 0;
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            //"visit" node - add its value to resulting array to verify correctness later
            result[k++] = current.value;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }

    public int[] traverseDFS() {
        int[] result = new int[1000]; //should calculate proper size, but too lazy ATM :)
        int k = 0;
        if (root == null) {
            return result;
        }
        Stack<Node> queue = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.pop();
            //"visit" node - add its value to resulting array to verify correctness later
            result[k++] = current.value;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }
}

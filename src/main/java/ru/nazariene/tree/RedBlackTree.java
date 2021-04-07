package ru.nazariene.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RedBlackTree {

    private static boolean BLACK = false;
    private static boolean RED = true;

    private Node root;

    private class Node {
        public Node left;
        public Node right;
        public int value;
        public boolean color = BLACK;
    }

    public void add(int value) {
        root = addRecursive(root, value);
        root.color = BLACK;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.color = RED;
            return newNode;
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        current = balance(current);

        return current;
    }

    private Node balance(Node node) {
        //Do not allow tree to lean right (it makes it easier to stick to RBT rules, without having to have a pointer to parent)
        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node);
        }
        //Check 2 consecutive RED nodes.
        //We're only checking left cause we maintain invariant "tree is not leaning right" by previous rule
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        //If both children are red - flip colors
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    //Return "left" child to maintain same position in the tree.
    //I.e. after rotation "left" child assumes same hierarchical position as "node" previously was in.
    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    //Return "right" child to maintain same position in the tree.
    //I.e. after rotation "right" child assumes same hierarchical position as "node" previously was in.
    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private void flipColors(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
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

    //TODO Balance tree when deleting a node
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
            System.out.println(current.color);
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

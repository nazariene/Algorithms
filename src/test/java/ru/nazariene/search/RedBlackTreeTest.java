package ru.nazariene.search;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void test3RightElements() {
        RBTTestImpl<Integer, Integer> bst = new RBTTestImpl<Integer, Integer>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(9, 9);

        RBTTestImpl.Node node = bst.root;
        Assert.assertEquals(4, node.value);
        Assert.assertNotNull(node.left);
        Assert.assertNotNull(node.right);

        RBTTestImpl.Node right = node.right;
        Assert.assertEquals(8, right.value);
        Assert.assertNotNull(right.left);
        Assert.assertNotNull(right.right);

        node = node.left;
        Assert.assertEquals(2, node.value);
        Assert.assertNotNull(node.left);
        Assert.assertNotNull(node.right);
    }

    @Test
    public void testLeftAndRightElements() {
        RBTTestImpl<Integer, Integer> bst = new RBTTestImpl<Integer, Integer>();
        bst.put(2, 1);
        bst.put(1, 2);
        bst.put(3, 3);

        RBTTestImpl.Node node = bst.root;
        Assert.assertEquals(1, node.value);
        Assert.assertNotNull(node.left);
        Assert.assertNotNull(node.right);

        RBTTestImpl.Node leftNode = node.left;
        Assert.assertEquals(2, leftNode.value);
        Assert.assertNull(leftNode.left);
        Assert.assertNull(leftNode.right);

        node = node.right;
        Assert.assertEquals(3, node.value);
        Assert.assertNull(node.left);
        Assert.assertNull(node.right);
    }

    @Test
    public void testDelete() {
        RedBlackTree<Integer, Integer> bst = new RedBlackTree<Integer, Integer>();
        bst.put(2, 2);
        bst.put(1, 1);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);

        bst.delete(4);

        RedBlackTree.Node node = bst.root;
        Assert.assertEquals(5, node.value);
        Assert.assertNotNull(node.left);
        Assert.assertNotNull(node.right);

        RedBlackTree.Node leftNode = node.left;
        Assert.assertEquals(2, leftNode.value);

        Assert.assertNotNull(leftNode.left);
        Assert.assertEquals(1, leftNode.left.value);
        Assert.assertNotNull(leftNode.right);
        Assert.assertEquals(3, leftNode.right.value);

        node = node.right;
        Assert.assertEquals(6, node.value);

        Assert.assertNotNull(node.right);
        Assert.assertEquals(8, node.right.value);
    }
}

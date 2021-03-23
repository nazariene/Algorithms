package ru.nazariene.search;

import org.junit.Assert;
import org.junit.Test;

public class BSTTest {

    @Test
    public void test3RightElements() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);

        BST.Node node = bst.root;
        Assert.assertEquals(1, node.value);
        Assert.assertNull(node.left);
        Assert.assertNotNull(node.right);

        node = node.right;
        Assert.assertEquals(2, node.value);
        Assert.assertNull(node.left);
        Assert.assertNotNull(node.right);

        node = node.right;
        Assert.assertEquals(3, node.value);
        Assert.assertNull(node.left);
        Assert.assertNull(node.right);
    }

    @Test
    public void testLeftAndRightElements() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.put(2, 1);
        bst.put(1, 2);
        bst.put(3, 3);

        BST.Node node = bst.root;
        Assert.assertEquals(1, node.value);
        Assert.assertNotNull(node.left);
        Assert.assertNotNull(node.right);

        BST.Node leftNode = node.left;
        Assert.assertEquals(2, leftNode.value);
        Assert.assertNull(leftNode.left);
        Assert.assertNull(leftNode.right);

        node = node.right;
        Assert.assertEquals(3, node.value);
        Assert.assertNull(node.left);
        Assert.assertNull(node.right);
    }
}

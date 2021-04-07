package ru.nazariene;

import org.junit.Assert;
import org.junit.Test;

import ru.nazariene.tree.BinarySearchTree;

public class BinarySearchTreeTest {

    @Test
    public void testAddAndContains_5Elements() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(10);

        Assert.assertTrue(bst.contains(1));
        Assert.assertTrue(bst.contains(2));
        Assert.assertTrue(bst.contains(3));
        Assert.assertTrue(bst.contains(4));
        Assert.assertTrue(bst.contains(10));
        Assert.assertFalse(bst.contains(5));
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(10);

        bst.delete(3);
        bst.delete(10);

        Assert.assertTrue(bst.contains(1));
        Assert.assertTrue(bst.contains(2));
        Assert.assertFalse(bst.contains(3));
        Assert.assertTrue(bst.contains(4));
        Assert.assertFalse(bst.contains(10));
    }

    @Test
    public void testBFS() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);
        bst.add(7);
        bst.add(11);
        bst.add(10);
        bst.add(12);

        int[] result = bst.traverseBFS();

        Assert.assertEquals(5, result[0]);
        Assert.assertEquals(3, result[1]);
        Assert.assertEquals(6, result[2]);
        Assert.assertEquals(2, result[3]);
        Assert.assertEquals(4, result[4]);
        Assert.assertEquals(8, result[5]);
        Assert.assertEquals(7, result[6]);
        Assert.assertEquals(11, result[7]);
        Assert.assertEquals(10, result[8]);
        Assert.assertEquals(12, result[9]);
    }

    @Test
    public void testDFS() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
        bst.add(8);
        bst.add(7);
        bst.add(11);
        bst.add(10);
        bst.add(12);

        int[] result = bst.traverseDFS();

        for (int i = 0; i < 10; i++) {
            System.out.println(result[i]);
        }
        Assert.assertEquals(5, result[0]);
        Assert.assertEquals(6, result[1]);
        Assert.assertEquals(8, result[2]);
        Assert.assertEquals(11, result[3]);
        Assert.assertEquals(12, result[4]);
        Assert.assertEquals(10, result[5]);
        Assert.assertEquals(7, result[6]);
        Assert.assertEquals(3, result[7]);
        Assert.assertEquals(4, result[8]);
        Assert.assertEquals(2, result[9]);
    }
}

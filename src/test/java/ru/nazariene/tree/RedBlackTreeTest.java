package ru.nazariene.tree;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

    @Test
    public void testAddAndBalance_9Elements() {
        RedBlackTree rbt = new RedBlackTree();
        rbt.add(1);
        rbt.add(2);
        rbt.add(3);
        rbt.add(4);
        rbt.add(5);
        rbt.add(6);
        rbt.add(7);
        rbt.add(8);
        rbt.add(9);

        int[] result = rbt.traverseBFS();

        //Expected tree:
        //        4
        //    2      8
        //  1  3   6   9
        //        5 7
        Assert.assertEquals(4, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(8, result[2]);
        Assert.assertEquals(1, result[3]);
        Assert.assertEquals(3, result[4]);
        Assert.assertEquals(6, result[5]);
        Assert.assertEquals(9, result[6]);
        Assert.assertEquals(5, result[7]);
        Assert.assertEquals(7, result[8]);
    }
}

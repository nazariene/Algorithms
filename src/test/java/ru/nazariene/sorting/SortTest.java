package ru.nazariene.sorting;

import org.junit.Assert;

abstract public class SortTest {

    protected void runTests(ISort sort) {
        testSort(sort);
        testSortWithSameElements(sort);
        testSortWithNegatives(sort);
        testLargeEvenData(sort);
        testLargeUnEvenData(sort);
    }

    protected void testSort(ISort sort) {
        int[] array = {3,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be 1", 1, array[0]);
        Assert.assertEquals("Should be 2", 2, array[1]);
        Assert.assertEquals("Should be 3", 3, array[2]);
    }

    protected void testSortWithSameElements(ISort sort) {
        int[] array = {3,2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be 1", 1, array[0]);
        Assert.assertEquals("Should be 2", 2, array[1]);
        Assert.assertEquals("Should be 2", 2, array[2]);
        Assert.assertEquals("Should be 3", 3, array[3]);
    }

    protected void testSortWithNegatives(ISort sort) {
        int[] array = {3,-2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be -2", -2, array[0]);
        Assert.assertEquals("Should be 1", 1, array[1]);
        Assert.assertEquals("Should be 2", 2, array[2]);
        Assert.assertEquals("Should be 3", 3, array[3]);
    }


    protected void testLargeEvenData(ISort sort) {
        int[] array = {3,2,1,5,7,9,10,15,11,4};
        sort.sort(array);
        Assert.assertEquals("Should be 1", 1, array[0]);
        Assert.assertEquals("Should be 2", 2, array[1]);
        Assert.assertEquals("Should be 3", 3, array[2]);
        Assert.assertEquals("Should be 4", 4, array[3]);
        Assert.assertEquals("Should be 5", 5, array[4]);
        Assert.assertEquals("Should be 7", 7, array[5]);
        Assert.assertEquals("Should be 9", 9, array[6]);
        Assert.assertEquals("Should be 10", 10, array[7]);
        Assert.assertEquals("Should be 11", 11, array[8]);
        Assert.assertEquals("Should be 15", 15, array[9]);

    }

    protected void testLargeUnEvenData(ISort sort) {
        int[] array = {3,2,1,5,7,9,10,15,4};
        sort.sort(array);
        Assert.assertEquals("Should be 1", 1, array[0]);
        Assert.assertEquals("Should be 2", 2, array[1]);
        Assert.assertEquals("Should be 3", 3, array[2]);
        Assert.assertEquals("Should be 4", 4, array[3]);
        Assert.assertEquals("Should be 5", 5, array[4]);
        Assert.assertEquals("Should be 7", 7, array[5]);
        Assert.assertEquals("Should be 9", 9, array[6]);
        Assert.assertEquals("Should be 10", 10, array[7]);
        Assert.assertEquals("Should be 15", 15, array[8]);

    }

}

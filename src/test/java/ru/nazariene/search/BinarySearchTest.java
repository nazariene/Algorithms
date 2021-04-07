package ru.nazariene.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    private Search binarySearch = new BinarySearch();

    @Test
    public void testSearchForMiddleElementInOddArray() {
        int[] array = {1,2,3};
        int result = binarySearch.search(array, 2);
        Assert.assertEquals("Should be 1", 1, result);
    }

    @Test
    public void testSearchForMiddleElementInEvenArray() {
        int[] array = {1,2,3,4};
        int result = binarySearch.search(array, 2);
        Assert.assertEquals("Should be 1", 1, result);
    }

    @Test
    public void testSearchResursion() {
        int[] array = {1,2,3,4,5};
        int result = binarySearch.search(array, 2);
        Assert.assertEquals("Should be 1", 1, result);
    }

    @Test
    public void testSearchResursionInEvenArray() {
        int[] array = {1,2,3,4,5,6};
        int result = binarySearch.search(array, 6);
        Assert.assertEquals("Should be 5", 5, result);
    }

    @Test
    public void testSearchForNonExistentElem() {
        int[] array = {1,2,4,5,6};
        int result = binarySearch.search(array, 3);
        Assert.assertEquals("Should be -1", -1, result);
    }

    @Test
    public void testSearchForNonExistentElemHigher() {
        int[] array = {1,2,3,4,5,6};
        int result = binarySearch.search(array, 7);
        Assert.assertEquals("Should be -1", -1, result);
    }

    @Test
    public void testSearchForNonExistentElemLower() {
        int[] array = {2,4,5,6};
        int result = binarySearch.search(array, 1);
        Assert.assertEquals("Should be -1", -1, result);
    }
}

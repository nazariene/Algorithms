package ru.nazariene.sorting;

import org.junit.Test;

public class MergeSortTest extends SortTest{

    @Test
    public void testMergeSort() {
        runTests(new MergeSort());
    }

    @Test
    public void testImprovedMergeSort() {
        runTests(new ImprovedMergeSort());
    }

    @Test
    public void testBottomUpMergeSort() {
        runTests(new BottomUpMergeSort());
    }
}

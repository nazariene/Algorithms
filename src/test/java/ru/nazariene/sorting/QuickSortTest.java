package ru.nazariene.sorting;

import org.junit.Test;

public class QuickSortTest extends SortTest {

    @Test
    public void testQuickSort() {
        runTests(new QuickSort());
    }

    @Test
    public void testThreeWayQuickSort() {
        runTests(new ThreeWayQuickSort());
    }
}

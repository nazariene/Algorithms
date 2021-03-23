package ru.nazariene.sorting;

import org.junit.Test;

public class HeapSortTest extends SortTest {

    @Test
    public void testHeapSort() {
        runTests(new HeapSort());
    }
}

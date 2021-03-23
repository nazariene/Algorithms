package ru.nazariene.sorting;

import org.junit.Test;

public class InsertionSortTest extends SortTest {

    @Test
    public void testInsertionSort() {
        runTests(new InsertionSort());
    }
}

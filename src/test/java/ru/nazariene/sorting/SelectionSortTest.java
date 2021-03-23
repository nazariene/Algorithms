package ru.nazariene.sorting;

import org.junit.Test;

public class SelectionSortTest extends SortTest {

    @Test
    public void testSelectionSort() {
        runTests(new SelectionSort());
    }
}

package ru.nazariene.sorting;

import org.junit.Test;

public class ShellSortTest extends SortTest {

    @Test
    public void testShellSort() {
        runTests(new ShellSort());
    }
}

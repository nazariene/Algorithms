package ru.nazariene.sorting;

/**
 * N^2/2 array accesses
 * N comparisons
 * Overall N^2 performance
 *
 *
 * Average: N^2
 * Stable: no
 * In place: yes
 * Extra space: 1
 */
public class SelectionSort implements ISort {

    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int curMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[curMin]) {
                    curMin = j;
                }
            }

            exchange(arr, i, curMin);
        }
    }
}

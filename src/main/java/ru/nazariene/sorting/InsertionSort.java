package ru.nazariene.sorting;

/**
 * Depends on input
 * If already sorted - linear time (N-1)
 * If Completely unsorted - N^2 time (N^2/4 compares and N^2/4 exchanges - so slower than SelectionSort)
 *
 *
 * Average: between N and N^2
 * Stable: yes
 * In place: yes
 * Extra space: 1
 */
public class InsertionSort implements ISort {
    public void sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j > 0 && inputArray[j] < inputArray[j-1]; j--) {
                exchange(inputArray, j, j-1);
            }
        }
    }
}

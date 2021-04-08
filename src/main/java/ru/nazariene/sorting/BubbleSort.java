package ru.nazariene.sorting;

/**
 * O(n^2)
 * If optimized and nearly sorted - O(n)
 *
 * Average: between N and N^2
 * Stable: yes
 * In place: yes
 * Extra space: 1
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = arr.length -1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    exchange(arr, j, j-1);
                    swapped = true;
                }
            }
            if (!swapped) {   //Optimization. Without its always n^2. With it and nearly sorted array - close to n
                break;
            }
        }
    }
}

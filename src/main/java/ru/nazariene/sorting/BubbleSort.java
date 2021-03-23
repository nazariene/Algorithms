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
public class BubbleSort implements ISort {

    @Override
    public void sort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            boolean swapped = false;
            for (int j = inputArray.length -1; j > i; j--) {
                if (inputArray[j] < inputArray[j-1]) {
                    exchange(inputArray, j, j-1);
                    swapped = true;
                }
            }
            if (!swapped) {   //Optimization. Without its always n^2. With it and nearly sorted array - close to n
                break;
            }
        }
    }
}

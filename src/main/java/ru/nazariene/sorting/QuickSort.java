package ru.nazariene.sorting;

/**
 * NlogN time
 * Worst case  - (N+1)*N/2 when each time one of subarrays is empty
 * Has small auxiliary stack - i.e. need less extra memory (unlike MergeSort)
 * Works best when partition splits the array in even 2 halves
 *
 * Average: NlogN
 * Stable: no
 * In place: yes
 * Extra space: lgN
 */
public class QuickSort implements ISort {
    public void sort(int[] arr) {
        innerSort(arr, 0, arr.length-1);

    }

    private void innerSort(int[] input, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int partitionIndex = partition(input, lo, hi);

        innerSort(input, lo, partitionIndex);
        innerSort(input, partitionIndex + 1, hi);
    }

    private int partition(int[] input, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (input[++i] < input[lo]) {
                if (i == hi) {
                    break;
                }
            }
            while (input[--j] >= input[lo]) {
                if (j == lo) {
                    break;
                }
            }

            if (j <= i) {
                break;
            }

            exchange(input, i, j);
        }

        exchange(input, lo, j);
        return j;
    }
}

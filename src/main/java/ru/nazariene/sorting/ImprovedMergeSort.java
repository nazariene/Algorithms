package ru.nazariene.sorting;

/**
 * Nlg(N) running time
 * Divide & Conquer
 *
 * Cons - large memory footprint (for temp arrays)
 */
public class ImprovedMergeSort implements Sort {

    private static int CUTOFF = 3;

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];

        innerSort(arr, temp, 0, arr.length - 1);
    }

    private void innerSort(int[] input, int[] temp, int lo, int hi) {
        if (hi > lo) {

            //2 - if small array - use insertion sort, gives 10-15% speed boost
            if (hi - lo <= CUTOFF) {
                insertionSort(input, lo, hi);
            }

            int mid = lo + (hi - lo) / 2;
            innerSort(input, temp, lo, mid);
            innerSort(input, temp, mid + 1, hi);

            //1 - if already sorted - no need to merge
            if (input[mid] < input[mid+1]) {
                return;
            }

            for (int k = 0; k < input.length; k++) {
                temp[k] = input[k];
            }
            merge(input, temp, lo, mid, hi);
        }
    }

    private void merge(int[] a, int[] temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > hi) {
                a[k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }

    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && (a[j] < a[j-1]); j--)
                exchange(a, j, j-1);
    }
}

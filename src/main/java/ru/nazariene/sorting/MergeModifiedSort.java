package ru.nazariene.sorting;

public class MergeModifiedSort implements ISort {

    @Override
    public void sort(int[] arr) {
        //Merge sort - improvisation

        innerSort(arr, 0, arr.length - 1);
    }

    private void innerSort(int[] inputArray, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) /2;
            innerSort(inputArray, lo, mid);
            innerSort(inputArray, mid + 1, hi);

            merge(inputArray, lo, mid, hi);
        }
    }

    private void merge(int[] inputArray, int lo, int mid, int hi) {
        int leftSize = mid - lo + 1;
        int rightSize = hi - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = inputArray[lo + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = inputArray[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = lo; k <= hi; k ++) {
            if (i >= leftSize) {
                inputArray[k] = right[j++];
            }
            else if (j >= rightSize) {
                inputArray[k] = left[i++];
            }
            else if (left[i] < right[j]) {
                inputArray[k] = left[i++];
            }
            else {
                inputArray[k] = right[j++];
            }
        }
    }

}

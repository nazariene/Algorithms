package ru.nazariene.sorting;

public class TestSort implements ISort {

    @Override
    public void sort(int[] arr) {
        //Merge sort
        //Idea is - split array in half
        //recurse into subarrays
        //Then merge 2 sorted arrays together
        innerSort(arr, 0, arr.length - 1);
    }

    private void innerSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo)/2;

        innerSort(arr, lo, mid);
        innerSort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int leftSize = mid - lo + 1;
        int rightSize = hi - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];


        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = lo; k <= hi; k ++) {
            if (i >= leftSize) {
                arr[k] = right[j++];
            }
            else if (j >= rightSize) {
                arr[k] = left[i++];
            }
            else if (left[i] < right[j]) {
                arr[k] = left[i++];
            }
            else {
                arr[k] = right[j++];
            }
        }
    }

}

package ru.nazariene.sorting;

public class TestSort implements Sort {

    @Override
    public void sort(int[] arr) {
        //Quicksort
        //n*logn
        //n^2 worst case
        //stable
        //inplace
        //choose pivot element. Place all < pivot to left, all > to right
        //Repeat for subarrays

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
            right[i] = arr[mid + 1 + i];
        }

        int l = 0;
        int r = 0;
        for (int i = lo; i <= hi; i++) {
            if (l >= leftSize) {
                arr[i] = right[r++];
            } else if (r >= rightSize) {
                arr[i] = left[l++];
            } else if (left[l] < right[r]) {
                arr[i] = left[l++];
            } else {
                arr[i] = right[r++];
            }
        }
    }


}

package ru.nazariene.sorting;

public class TestSort implements ISort {

    @Override
    public void sort(int[] inputArray) {
        //Quicksort

        innerSort(inputArray, 0, inputArray.length - 1);
    }

    private void innerSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        int partition = arr[lo];

        while (i <= gt) {
            if (arr[i] < partition) {
                exchange(arr, i++, lt++);
            } else if (arr[i] > partition) {
                exchange(arr, i, gt--);
            } else {
                i++;
            }
        }

        innerSort(arr, lo, lt - 1);
        innerSort(arr, gt+1, hi);
    }



}

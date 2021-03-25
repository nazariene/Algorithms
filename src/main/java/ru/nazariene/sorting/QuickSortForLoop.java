package ru.nazariene.sorting;

public class QuickSortForLoop implements ISort{

    @Override
    public void sort(int[] inputArray) {
        innerSort(inputArray, 0, inputArray.length - 1);
    }

    private void innerSort(int[] inputArray, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int partition = partition(inputArray, lo, hi);
        innerSort(inputArray, lo, partition - 1);
        innerSort(inputArray, partition + 1, hi);
    }

    private int partition(int[] inputArray, int lo, int hi) {
        int k = lo;

        for (int i = lo + 1; i <= hi; i++) {
            if (inputArray[i] < inputArray[lo]) {
                exchange(inputArray, i, ++k);
            }
        }

        exchange(inputArray, lo, k);
        return k;
    }
}
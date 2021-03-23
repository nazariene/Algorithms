package ru.nazariene.sorting;

public class TestSort implements ISort {

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
            if (!swapped) {
                break;
            }
        }
    }
}

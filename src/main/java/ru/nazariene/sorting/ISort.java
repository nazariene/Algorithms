package ru.nazariene.sorting;

interface ISort {

    void sort(int[] inputArray);

    default void exchange(int[] inputArray, int i, int curMin) {
        int curMinValue = inputArray[curMin];
        inputArray[curMin] = inputArray[i];
        inputArray[i] = curMinValue;
    }
}

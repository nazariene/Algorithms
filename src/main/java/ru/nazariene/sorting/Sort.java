package ru.nazariene.sorting;

interface Sort {

    void sort(int[] arr);

    default void exchange(int[] inputArray, int i, int curMin) {
        int curMinValue = inputArray[curMin];
        inputArray[curMin] = inputArray[i];
        inputArray[i] = curMinValue;
    }
}

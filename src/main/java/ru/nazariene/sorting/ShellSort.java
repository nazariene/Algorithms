package ru.nazariene.sorting;

/**
 * Average: NlogN?
 * Stable: no
 * In place: yes
 * Extra space: 1
 */
public class ShellSort implements ISort {
    public void sort(int[] inputArray) {
        int N = inputArray.length;
        int h = 1;

        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && inputArray[j] < inputArray[j-h]; j -= h) {
                    exchange(inputArray, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

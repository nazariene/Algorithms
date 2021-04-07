package ru.nazariene.sorting;

/**
 * Average: NlogN?
 * Stable: no
 * In place: yes
 * Extra space: 1
 */
public class ShellSort implements ISort {
    public void sort(int[] arr) {
        int N = arr.length;
        int h = 1;

        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && arr[j] < arr[j-h]; j -= h) {
                    exchange(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

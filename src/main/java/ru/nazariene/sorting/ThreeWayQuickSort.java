package ru.nazariene.sorting;

/**
 * Maintain 3 pointers - less than, equal and greater than
 * Runs faster when:
 * 1) There are equal elements
 * 2) There are elements with equal keys (the more the better)
 * Djkstra in 60s, updated by Sedgewick in 90s
 *
 * Average: between N and lgN
 * Stable: no
 * In place: yes
 * Extra space: lgN
 */
public class ThreeWayQuickSort implements ISort {
    public void sort(int[] inputArray) {
        innerSort(inputArray, 0, inputArray.length - 1);
    }

    private void innerSort(int[] input, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int elem = input[lo];
        while (i <= gt) {
            if (input[i] < elem) {
                exchange(input, lt++, i++);
            } else if (input[i] > elem) {
                exchange(input, i, gt--);
            } else {
                i++;
            }
        }

        innerSort(input, lo, lt - 1);
        innerSort(input, gt + 1, hi);
    }
}

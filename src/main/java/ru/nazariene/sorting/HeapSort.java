package ru.nazariene.sorting;

/**
 * NlogN guaranteed time
 * Constant extra space
 *
 *
 * Idea is to keep array as binary, heap-ordered tree
 * Heap-ordered tree is binary tree that maintain condition: parent is > each children
 * if array[k] is parent, then array[2*k] and array[2*k+1] are children
 */
public class HeapSort implements ISort {
    public void sort(int[] inputArray) {
        int n = inputArray.length;


        for (int k = n / 2; k >= 0; k--)
            sink(inputArray, k, n);
        while (n > 0) {
            exchange(inputArray, 0, --n);
            sink(inputArray, 0, n);
        }
    }

    /**
     * Sink element down the binary tree to maintain the condition that tree is heap ordered (children < parent)
     * @param pq
     * @param k
     * @param n
     */
    private void sink(int[] pq, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && (pq[j] < pq[j+1])) j++;
            if (!(pq[k] < pq[j])) break;
            exchange(pq, k, j);
            k = j;
        }
    }
}

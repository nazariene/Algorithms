/**
 * Nlg(N) running time
 * Divide & Conquer
 *
 * Cons - large memory footprint (for temp arrays)
 *
 * Mergesort is an asymptotically optimal compare-based sorting algorithm.
 * That is, both the number of compares used by mergesort in the worst case
 * and the minimum number of compares that any compare-based sorting algorithm can guarantee are ~N lg N.
 *
 * Average: NlogN
 * Stable: yes
 * In place: no
 * Extra space: N
 */
public class MergeSort implements ISort {

    public void sort(Comparable[] input) {
        Comparable[] temp = new Comparable[input.length];

        innerSort(input, temp, 0, input.length - 1);
    }

    private void innerSort(Comparable[] input, Comparable[] temp, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            innerSort(input, temp, lo, mid);
            innerSort(input, temp, mid + 1, hi);

            if (!(input[mid].compareTo(input[mid+1]) < 0)) {
                for (int k = 0; k < input.length; k++) {
                    temp[k] = input[k];
                }

                merge(input, temp, lo, mid, hi);
            }

        }
    }

    private void merge(Comparable[] a, Comparable[] temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > hi) {
                a[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) < 0) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }
}

/**
 * Nlg(N) running time
 * Divide & Conquer
 *
 * Cons - large memory footprint (for temp arrays)
 */
public class ImprovedMergeSort implements ISort {

    private static int CUTOFF = 3;

    public void sort(Comparable[] input) {
        Comparable[] temp = new Comparable[input.length];

        innerSort(input, temp, 0, input.length - 1);
    }

    private void innerSort(Comparable[] input, Comparable[] temp, int lo, int hi) {
        if (hi > lo) {

            //2 - if small array - use insertion sort, gives 10-15% speed boost
            if (hi - lo <= CUTOFF) {
                insertionSort(input, lo, hi);
            }

            int mid = lo + (hi - lo) / 2;
            innerSort(input, temp, lo, mid);
            innerSort(input, temp, mid + 1, hi);

            //1 - if already sorted - no need to merge
            if (input[mid].compareTo(input[mid+1]) < 0) {
                return;
            }

            for (int k = 0; k < input.length; k++) {
                temp[k] = input[k];
            }
            merge(input, temp, lo, mid, hi);
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

    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && (a[j].compareTo(a[j-1]) < 0); j--)
                exch(a, j, j-1);
    }
}

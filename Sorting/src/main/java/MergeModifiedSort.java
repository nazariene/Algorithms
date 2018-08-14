
public class MergeModifiedSort implements ISort {

    @Override
    public void sort(Comparable[] inputArray) {
        //Merge sort - improvisation

        innerSort(inputArray, 0, inputArray.length - 1);
    }

    private void innerSort(Comparable[] inputArray, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) /2;
            innerSort(inputArray, lo, mid);
            innerSort(inputArray, mid + 1, hi);

            merge(inputArray, lo, mid, hi);
        }
    }

    private void merge(Comparable[] inputArray, int lo, int mid, int hi) {
        int leftSize = mid - lo + 1;
        int rightSize = hi - mid;

        Comparable[] left = new Comparable[leftSize];
        Comparable[] right = new Comparable[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = inputArray[lo + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = inputArray[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = lo; k <= hi; k ++) {
            if (i >= leftSize) {
                inputArray[k] = right[j++];
            }
            else if (j >= rightSize) {
                inputArray[k] = left[i++];
            }
            else if (left[i].compareTo(right[j]) < 0) {
                inputArray[k] = left[i++];
            }
            else {
                inputArray[k] = right[j++];
            }
        }
    }

}

package ru.nazariene.sorting;

public class MergeModifiedSort implements Sort {

    @Override
    public void sort(int[] arr) {
        //Merge sort - improvisation

        innerSort(arr, 0, arr.length - 1);
    }

    private void innerSort(int[] inputArray, int lo, int hi) {
        if (hi > lo) {
            int mid = lo + (hi - lo) /2;
            innerSort(inputArray, lo, mid);
            innerSort(inputArray, mid + 1, hi);

            merge(inputArray, lo, mid, hi);
        }
    }

    private void merge(int[] inputArray, int lo, int mid, int hi) {
        //+1 here because mid,lo,hi are index based (i.e. start with 0)
        //and size is value-based (start with 1).
        //So, need extra 1 here.
        int leftSize = mid - lo + 1;
        //Do not add 1 to rightSize, cause while hi and mid are index based
        //They are > 0
        int rightSize = hi - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = inputArray[lo + i];
        }
        for (int i = 0; i < rightSize; i++) {
            //arr[mid] goes to left side
            //So, start with mid + 1
            right[i] = inputArray[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = lo; k <= hi; k ++) {
            //>= cause i is index-based, and leftSize is value-based.
            //So need to consider i = leftSize as out of bounds case
            if (i >= leftSize) {
                inputArray[k] = right[j++];
            }
            else if (j >= rightSize) {
                inputArray[k] = left[i++];
            }
            else if (left[i] < right[j]) {
                inputArray[k] = left[i++];
            }
            else {
                inputArray[k] = right[j++];
            }
        }
    }

}

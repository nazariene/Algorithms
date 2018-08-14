import java.util.Arrays;

public class TestSort implements ISort {

    @Override
    public void sort(Comparable[] inputArray) {
       //Quicksort - 3 way

        innerSort(inputArray, 0, inputArray.length - 1);
    }

    private void innerSort(Comparable[] inputArray, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo ;
        int gt = hi;
        int i = lo + 1;
        Comparable elem = inputArray[lo];
        while (i <= gt) {
            int cmp = inputArray[i].compareTo(elem);
            if (cmp > 0) {
                exch(inputArray, gt--, i);
            }
            else if (cmp < 0) {
                exch(inputArray, lt++, i++);
            }
            else {
                i++;
            }
        }

        innerSort(inputArray, lo, lt -1);
        innerSort(inputArray, gt + 1, hi);
    }



}

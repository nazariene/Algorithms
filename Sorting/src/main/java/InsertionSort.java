/**
 * Depends on input
 * If already sorted - linear time (N-1)
 * If Completely unsorted - N^2 time (N^2/4 compares and N^2/4 exchanges - so slower than SelectionSort)
 *
 *
 * Average: between N and N^2
 * Stable: yes
 * In place: yes
 * Extra space: 1
 */
public class InsertionSort implements ISort {
    public void sort(Comparable[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j > 0 && inputArray[j].compareTo(inputArray[j-1]) < 0; j--) {
                exch(inputArray, j, j-1);
            }
        }
    }
}

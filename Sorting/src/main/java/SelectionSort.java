/**
 * N^2/2 array accesses
 * N comparisons
 * Overall N^2 performance
 *
 *
 * Average: N^2
 * Stable: no
 * In place: yes
 * Extra space: 1
 */
public class SelectionSort implements ISort {

    public void sort(Comparable[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            int curMin = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j].compareTo(inputArray[curMin]) < 0) {
                    curMin = j;
                }
            }

            exch(inputArray, i, curMin);
        }
    }
}

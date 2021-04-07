package ru.nazariene.search;

public class TestImpl implements Search {

    public int search(int[] inputArray, int searchFor) {
        int result = -1;

        int lo = 0;
        int hi = inputArray.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (inputArray[mid] > searchFor) {
                hi = mid - 1;
            }
            else if (inputArray[mid] < searchFor) {
                lo = mid + 1;
            }
            else {
                result = mid;
                break;
            }
        }


        return result;
    }
}

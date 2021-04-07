package ru.nazariene.search;

public class BinarySearch implements Search {

    public int search(int[] inputArray, int searchFor) {
        int result = -1;

        int hi = inputArray.length - 1;
        int lo = 0;


        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;   //You can calculate this as "(hi + lo)/2" if you're sure it will not overflow!

            int midElem = inputArray[mid];
            if (searchFor > midElem) {
                lo = mid + 1;
            } else if (searchFor < midElem) {
                hi = mid - 1;
            } else {
                result = mid;
                break;
            }
            System.out.println(hi + " " + lo);
        }

        return result;
    }
}

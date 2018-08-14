interface ISort {

    void sort(Comparable[] inputArray);

    default void exch(Comparable[] inputArray, int i, int curMin) {
        Comparable curMinValue = inputArray[curMin];
        inputArray[curMin] = inputArray[i];
        inputArray[i] = curMinValue;
    }
}

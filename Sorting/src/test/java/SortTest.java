import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SortTest {

    private ISort sort;

    @Test
    public void testSort() {
        sort = new TestSort();
        runTests(sort);
    }

    @Test
    public void testHeapSort() {
        sort = new HeapSort();
        runTests(sort);
    }

    @Test
    public void testQuickSort() {
        sort = new QuickSort();
        runTests(sort);
        sort = new ThreeWayQuickSort();
        runTests(sort);
    }

    @Test
    public void testMergeSort() {
        sort = new MergeSort();
        runTests(sort);
        sort = new ImprovedMergeSort();
        runTests(sort);
        sort = new BottomUpMergeSort();
        runTests(sort);
    }

    @Test
    public void testInsertionSort() {
        sort = new InsertionSort();
        runTests(sort);
    }

    @Test
    public void testSelectionSort() {
        sort = new SelectionSort();
        runTests(sort);
    }

    @Test
    public void testShellSort() {
        sort = new ShellSort();
        runTests(sort);
    }

    private void runTests(ISort sort) {
        testSort(sort);
        testSortWithSameElements(sort);
        testSortWithNegatives(sort);
        testLargeEvenData(sort);
        testLargeUnEvenData(sort);
    }

    private void testSort(ISort sort) {
        Integer[] array = {3,2,1};
        sort.sort(array);
        System.out.println(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 3", new Integer(3), array[2]);
    }

    private void testSortWithSameElements(ISort sort) {
        Integer[] array = {3,2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 2", new Integer(2), array[2]);
        Assert.assertEquals("Should be 3", new Integer(3), array[3]);
    }

    private void testSortWithNegatives(ISort sort) {
        Integer[] array = {3,-2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be -2", new Integer(-2), array[0]);
        Assert.assertEquals("Should be 1", new Integer(1), array[1]);
        Assert.assertEquals("Should be 2", new Integer(2), array[2]);
        Assert.assertEquals("Should be 3", new Integer(3), array[3]);
    }


    private void testLargeEvenData(ISort sort) {
        Integer[] array = {3,2,1,5,7,9,10,15,11,4};
        sort.sort(array);
        System.out.println(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 3", new Integer(3), array[2]);
        Assert.assertEquals("Should be 4", new Integer(4), array[3]);
        Assert.assertEquals("Should be 5", new Integer(5), array[4]);
        Assert.assertEquals("Should be 7", new Integer(7), array[5]);
        Assert.assertEquals("Should be 9", new Integer(9), array[6]);
        Assert.assertEquals("Should be 10", new Integer(10), array[7]);
        Assert.assertEquals("Should be 11", new Integer(11), array[8]);
        Assert.assertEquals("Should be 15", new Integer(15), array[9]);

    }

    private void testLargeUnEvenData(ISort sort) {
        Integer[] array = {3,2,1,5,7,9,10,15,4};
        sort.sort(array);
        System.out.println(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 3", new Integer(3), array[2]);
        Assert.assertEquals("Should be 4", new Integer(4), array[3]);
        Assert.assertEquals("Should be 5", new Integer(5), array[4]);
        Assert.assertEquals("Should be 7", new Integer(7), array[5]);
        Assert.assertEquals("Should be 9", new Integer(9), array[6]);
        Assert.assertEquals("Should be 10", new Integer(10), array[7]);
        Assert.assertEquals("Should be 15", new Integer(15), array[8]);

    }

}

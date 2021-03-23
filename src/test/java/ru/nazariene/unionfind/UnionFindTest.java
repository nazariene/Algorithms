package ru.nazariene.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

    private int N = 10;
    private List<String> data = new ArrayList<>();

    private IUnionFind unionFind;

    public void loadData(String fileName) throws IOException {
        //Load data
        BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)));
        N = Integer.parseInt(in.readLine());
        unionFind = new QuickFind(N);
        String nextLine;
        while ((nextLine = in.readLine()) != null) {
            String[] strData = nextLine.split(" ");
            unionFind.union(Integer.parseInt(strData[0]), Integer.parseInt(strData[1]));
            data.add(nextLine);
        }
    }
    @Before
    public void before() {
        unionFind = new WeightedQuickUnion(N);
    }


    @Test
    public void testSmallData() throws IOException {
        loadData("unionfind/smallData");
        Assert.assertTrue(unionFind.isConnected(0,5));
        Assert.assertTrue(unionFind.find(5) == unionFind.find(0));
    }

    @Test
    public void testMediumData() throws IOException {
        loadData("unionfind/mediumData");
        Assert.assertTrue(unionFind.isConnected(0,5));
        Assert.assertTrue(unionFind.find(5) == unionFind.find(0));
    }

    @Test
    public void testLargeData() throws IOException {
        loadData("unionfind/largeData");
        Assert.assertTrue(unionFind.isConnected(0,5));
        Assert.assertTrue(unionFind.find(5) == unionFind.find(0));
    }

    @Test
    public void testUnionOf2Elements() {
        unionFind.union(0,9);
        Assert.assertTrue("Elements are not connected!", unionFind.isConnected(0,9));
        Assert.assertFalse("Elements should not be connected!", unionFind.isConnected(0,8));
    }

    @Test
    public void testUnionOfAllElementsWithFirst() {
        for (int i = 0; i < N; i++) {
            unionFind.union(0, i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertTrue("Elements are not connected:" + i, unionFind.isConnected(0,i));
        }
    }

    @Test
    public void testUnionOfAllElements() {
        for (int i = 1; i < N; i++) {
            unionFind.union(i-1, i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertTrue("Elements are not connected!", unionFind.isConnected(0,i));
        }
    }

    @Test
    public void testCombine2Sets() {
        unionFind.union(0,1);
        unionFind.union(1,2);
        unionFind.union(2,3);

        unionFind.union(5,6);
        unionFind.union(7,6);
        unionFind.union(7,8);

        unionFind.union(0,8);

        Assert.assertTrue(unionFind.isConnected(0, 8));
        Assert.assertTrue(unionFind.isConnected(2, 5));
        Assert.assertTrue(unionFind.isConnected(1, 7));
        Assert.assertTrue(unionFind.isConnected(7, 3));
    }
}

package ru.nazariene.graph.princeton.mst;

/**
 * Quick Find impl of union find
 */
public class UnionFind {

    private int[] elements;

    public UnionFind(int capacity) {
        elements = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = i;
        }
    }

    public void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == find(b)) {
                elements[i] = find(a);
            }
        }
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int find(int a) {
        return elements[a];
    }

}

package ru.nazariene.unionfind;

/**
 * Find = constant time
 * Union = N array acceses
 * Overall = N^2
 */
public class QuickFind implements IUnionFind {

    private int[] elements;
    private int count;

    public QuickFind(int N) {
        elements = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            elements[i] = i;
        }
    }

    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) {
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == idP) {
                elements[i] = idQ;
            }
        }

        count--;
    }

    public int find(int p) {
        return elements[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return 0;
    }
}

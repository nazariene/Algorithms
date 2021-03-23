package ru.nazariene.unionfind;

/**
 * Find = N in worst case, constant in best
 * Union = 2N+1 in worst case
 *
 * Overall = from linear to Quadratic (depends in input)
 */
public class QuickUnion implements IUnionFind {

    private int[] elements;
    private int count;

    public QuickUnion(int N) {
        elements = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            elements[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        elements[rootP] = rootQ;

        count--;
    }

    public int find(int p) {
        while (p != elements[p]) {
            p = elements[p];
        }

        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}

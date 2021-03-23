package ru.nazariene.unionfind;

/**
 *Find = logN
 * Union = logN
 * Overall = ClogN
 */
public class WeightedQuickUnion implements IUnionFind {
    private int[] elements;
    private int count;
    private int[] treeSize;

    public WeightedQuickUnion(int N) {
        elements = new int[N];
        for (int i = 0; i < N; i++) {
            elements[i] = i;
        }

        count = N;

        treeSize = new int[N];
        for (int i = 0; i < N; i++) {
            treeSize[i] = 1;
        }
    }

    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) {
            return;
        }

        if (treeSize[idP] < treeSize[idQ]) {
            elements[idP] = idQ;
            treeSize[idQ] += treeSize[idP];
        }
        else {
            elements[idQ] = idP;
            treeSize[idP] += treeSize[idQ];
        }

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

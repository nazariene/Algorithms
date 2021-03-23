package ru.nazariene.unionfind;

/**
 * QuickFind: Keep an array of indexes. Find - return element by index. Union - change all elements that match to a new value.
 *             find = O(1), union = O(N)
 * QuickUnion: Elements a keeped in chain (have root). Union - update root. Find - return root.
 *             worst find = O(N), average: O(N/2)
 *             worst union: O(2*N+1), average: O(N)
 *     Issue: tree can grow large
 * WeightedQuickUnion: Like quick union, but keep extra array to hold weights of trees. When doing a union - attach small tree to larger tree
 *
 *
 */
public class Practice implements IUnionFind {

    private int[] array;
    private int[] weights;
    private int count;


    public Practice(int N) {
        array = new int[N];
        weights = new int[N];
        for (int i =0; i<N; i++) {
            array[i] = i;
            weights[i] = 1;
        }

        count = 0;
    }
    public int find(int p) {
        while(p != array[p]) {
            p = array[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) {
            return;
        }

        if (weights[idP] < weights[idQ]) {
            array[idP] = idQ;
            weights[idQ] += weights[idP];
        }
        else {
            array[idQ] = idP;
            weights[idP] += weights[idQ];
        }
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}

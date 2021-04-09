package ru.nazariene.graph.princeton.model_princeton;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Adjacency-list based graph implementation
 */
public class AdjListGraphImpl implements Graph {

    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adjacencyList;

    public AdjListGraphImpl(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a model.Graph must be nonnegative");
            adjacencyList = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adjacencyList[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a model.Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in model.Graph constructor", e);
        }
    }

    public AdjListGraphImpl(int V) {
        this.V = V;
        adjacencyList = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Bag<Integer>();
        }

        this.E = 0;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
        E++;
    }

    public Iterable<Integer> adjacentTo(int v) {
        return adjacencyList[v];
    }

    public int degree(int v) {
        return adjacencyList[v].size();
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     * followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append(NEWLINE);
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int w : adjacencyList[v]) {
                sb.append(w).append(" ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}

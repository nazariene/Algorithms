package ru.nazariene.graph.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class WeightedGraphAdjListImpl implements WeightedGraph {

    private static final String NEWLINE = System.getProperty("line.separator");

    protected final int V;
    int E;
    Bag<Edge>[] adjacencyList;

    public WeightedGraphAdjListImpl(int V) {
        this.V = V;
        adjacencyList = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new Bag<>();
        }

        this.E = 0;
    }

    public WeightedGraphAdjListImpl(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a model.Graph must be nonnegative");
            adjacencyList = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adjacencyList[v] = new Bag<>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a model.Graph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int from = in.readInt();
                int to = in.readInt();
                int weight = in.readInt();
                addEdge(from, to, weight);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in model.Graph constructor", e);
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        Edge edge = new Edge(from, to, weight);
        adjacencyList[from].add(edge);
        adjacencyList[to].add(edge);
        E++;
    }

    @Override
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();

        for(int v = 0; v < this.V; ++v) {
            int selfLoops = 0;
            Iterator iterator = this.adjacentTo(v).iterator();

            while(iterator.hasNext()) {
                Edge e = (Edge)iterator.next();
                if(e.other(v) > v) {
                    list.add(e);
                } else if(e.other(v) == v) {
                    if(selfLoops % 2 == 0) {
                        list.add(e);
                    }

                    ++selfLoops;
                }
            }
        }

        return list;
    }

    @Override
    public Iterable<Edge> adjacentTo(int v) {
        return adjacencyList[v];
    }

    @Override
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
            for (Edge edge : adjacencyList[v]) {
                sb.append(edge.toString());
                sb.append("\t");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}

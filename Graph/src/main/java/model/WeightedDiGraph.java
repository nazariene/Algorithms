package model;

import edu.princeton.cs.algs4.In;

import java.util.Set;

public class WeightedDiGraph extends WeightedGraphAdjListImpl {

    public WeightedDiGraph(int V) {
        super(V);
    }

    public WeightedDiGraph(In in) {
        super(in);
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        adjacencyList[from].add(new Edge(from, to, weight));
        E++;
    }
}

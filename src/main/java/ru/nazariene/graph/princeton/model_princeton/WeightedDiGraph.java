package ru.nazariene.graph.princeton.model_princeton;

import edu.princeton.cs.algs4.In;

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

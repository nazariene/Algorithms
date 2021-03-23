package ru.nazariene.graph.model;

public interface WeightedGraph {

    int V();

    int E();

    int degree(int v);

    void addEdge(int from, int to, int weight);

    Iterable<Edge> edges();

    Iterable<Edge> adjacentTo(int V);
}

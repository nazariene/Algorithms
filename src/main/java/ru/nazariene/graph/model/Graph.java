package ru.nazariene.graph.model;

public interface Graph {

    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adjacentTo(int v);

    int degree(int v);
}

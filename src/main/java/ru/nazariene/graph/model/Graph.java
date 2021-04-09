package ru.nazariene.graph.model;

import java.util.List;

public interface Graph {

    int numVertices();

    int numEdges();

    void addEdge(Edge edge);

    List<Edge> edges(int vertex);

    List<Edge> edges();
}

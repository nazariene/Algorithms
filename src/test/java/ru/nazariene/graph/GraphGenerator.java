package ru.nazariene.graph;

import java.util.ArrayList;
import java.util.List;

import ru.nazariene.graph.model.Edge;

public class GraphGenerator {

    public static List<Edge> smallGraph() {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 0));
        edges.add(new Edge(0, 2, 0));
        edges.add(new Edge(1, 2, 0));
        edges.add(new Edge(1, 3, 0));
        edges.add(new Edge(2, 4, 0));
        edges.add(new Edge(3, 5, 0));
        edges.add(new Edge(4, 3, 0));
        edges.add(new Edge(5, 4, 0));

        return edges;
    }

    public static List<Edge> smallWeightedGraph() {
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(0, 7, 8));
        edges.add(new Edge(0, 4, 9));
        edges.add(new Edge(1, 1, 12));
        edges.add(new Edge(1, 7, 4));
        edges.add(new Edge(2, 6, 11));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(4, 7, 5));
        edges.add(new Edge(4, 5, 4));
        edges.add(new Edge(4, 6, 20));
        edges.add(new Edge(3, 6, 9));
        edges.add(new Edge(5, 6, 13));
        edges.add(new Edge(5, 2, 1));
        edges.add(new Edge(7, 2, 7));
        edges.add(new Edge(7, 5, 6));
        return edges;

    }
}
package ru.nazariene.graph.model;

import java.util.ArrayList;

public class UnweightedGraph extends UnweightedDirectionalGraph implements Graph {

    @Override
    public void addEdge(Edge edge) {
        if (!edges.containsKey(edge.getFrom()) || edges.get(edge.getFrom()) == null) {
            edges.put(edge.getFrom(), new ArrayList<>());
        }

        edges.get(edge.getFrom()).add(edge);

        numEdges++;

        edge = edge.reverse();
        if (!edges.containsKey(edge.getFrom()) || edges.get(edge.getFrom()) == null) {
            edges.put(edge.getFrom(), new ArrayList<>());
        }

        edges.get(edge.getFrom()).add(edge);

        numEdges++;
    }
}

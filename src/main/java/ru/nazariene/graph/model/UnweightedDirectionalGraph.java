package ru.nazariene.graph.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UnweightedDirectionalGraph implements Graph {

    protected int numVertices;
    protected int numEdges;

    protected Set<Integer> vertices = new HashSet<>();
    protected Map<Integer, List<Edge>> edges = new HashMap<>();

    @Override
    public int numVertices() {
        return this.vertices.size();
    }

    @Override
    public int numEdges() {
        return this.numEdges;
    }

    @Override
    public void addEdge(Edge edge) {
        if (!edges.containsKey(edge.getFrom()) || edges.get(edge.getFrom()) == null) {
            edges.put(edge.getFrom(), new ArrayList<>());
        }

        edges.get(edge.getFrom()).add(edge);

        numEdges++;

        vertices.add(edge.getTo());
        vertices.add(edge.getFrom());
    }

    @Override
    public List<Edge> edges(int vertex) {
        return edges.get(vertex) != null ? edges.get(vertex) : Collections.emptyList();
    }

    @Override
    public List<Edge> edges() {
        return edges.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}

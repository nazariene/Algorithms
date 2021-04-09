package ru.nazariene.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.nazariene.graph.model.Edge;
import ru.nazariene.graph.model.Graph;

public class BFS {

    public List<Edge> perform(Graph graph, int startVertex) {
        List<Integer> visited = new ArrayList<>();

        visited.add(startVertex);
        Queue<Edge> toVisit = new LinkedList<>(graph.edges(startVertex));

        List<Edge> edgesFollowed = new ArrayList<>();

        while (!toVisit.isEmpty()) {
            Edge visiting = toVisit.poll();
            if (visited.contains(visiting.getTo())) {
                continue;
            }

            visited.add(visiting.getTo());
            toVisit.addAll(graph.edges(visiting.getTo()));

            edgesFollowed.add(visiting);
        }

        return edgesFollowed;
    }
}

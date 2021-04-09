package ru.nazariene.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ru.nazariene.graph.model.Edge;
import ru.nazariene.graph.model.Graph;

public class DFS {

    public List<Edge> perform(Graph graph, int startVertex) {
        List<Integer> visited = new ArrayList<>();

        visited.add(startVertex);
        Stack<Edge> toVisit = new Stack<>();
        toVisit.addAll(graph.edges(startVertex));

        List<Edge> edgesFollowed = new ArrayList<>();

        while (!toVisit.isEmpty()) {
            Edge visiting = toVisit.pop();
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

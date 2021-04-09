package ru.nazariene.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import ru.nazariene.graph.model.Edge;
import ru.nazariene.graph.model.Graph;

public class Djkstra {

    private int[] distance;
    private int[] path;
    private Set<Integer> unsettled;
    private Set<Integer> settled;

    public Stack<Integer> perform(Graph graph, int startVertex, int endVertex) {
        distance = new int[graph.numVertices()];
        path = new int[graph.numVertices()];
        unsettled = new HashSet<>();
        settled = new HashSet<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            unsettled.add(i);
        }

        distance[startVertex] = 0;

        while (!unsettled.isEmpty()) {
            int node = findClosestUnsettledNode(unsettled, distance);

            List<Edge> edges = graph.edges(node);

            edges.forEach(edge -> {
                if (distance[edge.getTo()] > distance[node] + edge.getWeight()) {
                    distance[edge.getTo()] = distance[node] + edge.getWeight();
                    path[edge.getTo()] = node;

                    if (!settled.contains(edge.getTo())) {
                        unsettled.add(edge.getTo());
                    }
                }
            });

            settled.add(node);
            unsettled.remove(node);
        }

        if (distance[endVertex] == Integer.MAX_VALUE) {
            return null;
        }

        Stack<Integer> pathTaken = new Stack<>();

        int node = endVertex;
        while (node != startVertex) {
            pathTaken.push(node);
            node = path[node];
        }

        pathTaken.push(startVertex);
        return pathTaken;
    }

    private int findClosestUnsettledNode(Set<Integer> unsettled, int[] distance) {
        int lowestDistance = Integer.MAX_VALUE;
        int node = -1;
        for (int i : unsettled) {
            if (distance[i] < lowestDistance) {
                node = i;
                lowestDistance = distance[i];
            }
        }

        return node;
    }

}

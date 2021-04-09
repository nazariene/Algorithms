package ru.nazariene.graph.princeton.mst;

import java.io.File;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import ru.nazariene.graph.princeton.model_princeton.Edge;
import ru.nazariene.graph.princeton.model_princeton.WeightedDiGraph;
import ru.nazariene.graph.princeton.model_princeton.WeightedGraph;

public class DijkstraTraining {

    private int[] distTo;
    private Edge[] edgeTo;
    private PriorityQueue<Integer> unVisitedNodes;

    public DijkstraTraining(WeightedGraph graph, int source) {
        distTo = new int[graph.V()];
        edgeTo = new Edge[graph.V()];

        unVisitedNodes = new PriorityQueue<>(Comparator.comparingInt(o -> distTo[o]));

        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Integer.MAX_VALUE;
            unVisitedNodes.add(i);
        }

        distTo[source] = 0;

        while (!unVisitedNodes.isEmpty()) {
            Integer currentNode = unVisitedNodes.poll();
            for (Edge e : graph.adjacentTo(currentNode)) {
                relax(e);
            }
        }
    }

    private void relax(Edge e) {
        int weight = e.getWeight();
        int from = e.getFromVertex();
        int to = e.getToVertex();

        if (distTo[to] > distTo[from] + weight) {
            distTo[to] = distTo[from] + weight;
            edgeTo[to] = e;
        }
    }


    private Iterable<Edge> pathTo(int i) {
        if (!hasPathTo(i)) {
            return null;
        }

        Stack<Edge> edges = new Stack<>();
        for (Edge e = edgeTo[i]; e != null; e = edgeTo[e.getFromVertex()]) {
            edges.push(e);
        }

        return edges;
    }

    private boolean hasPathTo(int i) {
        return distTo[i] < Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedDiGraph(new In(new File("C:\\work\\SandBox\\Algo_playground\\Graph\\src\\main\\resources\\tinyWeightedDiGraph")));
        System.out.println(graph);

        DijkstraTraining dijkstra = new DijkstraTraining(graph, 0);


        for (int i = 0; i < graph.V(); i++) {
            System.out.println(dijkstra.pathTo(i));
            int totalLength = 0;
            for (Edge e : dijkstra.pathTo(i)) {
                totalLength += e.getWeight();
            }
            System.out.println(totalLength);
        }
    }
}

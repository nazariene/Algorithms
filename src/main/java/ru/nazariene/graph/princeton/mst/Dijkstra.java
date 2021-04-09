package ru.nazariene.graph.princeton.mst;

import java.io.File;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import ru.nazariene.graph.princeton.model_princeton.Edge;
import ru.nazariene.graph.princeton.model_princeton.WeightedDiGraph;
import ru.nazariene.graph.princeton.model_princeton.WeightedGraph;

public class Dijkstra {

    private int[] distTo;
    private Edge[] edgeTo;
    private PriorityQueue<Integer> unVisitedNodes;
    public Dijkstra(WeightedGraph graph, int source) {

        unVisitedNodes = new PriorityQueue<>((o1, o2) -> Integer.compare(distTo[o1], distTo[o2]));

        distTo = new int[graph.V()];
        edgeTo = new Edge[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Integer.MAX_VALUE;
            unVisitedNodes.add(i);
        }
        distTo[source] = 0;

        while (unVisitedNodes.size() > 0) {
            //Get lowest distance node from currently known (lowest distance is implemented by PriorityQueue with comparator)
            int vertex = unVisitedNodes.poll();
            System.out.println(vertex);
            for (Edge e : graph.adjacentTo(vertex)) {
                relax(e);
            }
        }
    }

    private void relax(Edge e) {
        int from = e.getFromVertex();
        int to = e.getToVertex();
        int weight = e.getWeight();

        if (distTo[to] > distTo[from] + weight) {
            distTo[to] = distTo[from] + weight;
            edgeTo[to] = e;
        }
    }

    public Iterable<Edge> pathTo(int target) {
        if (!hasPathTo(target)) {
            return null;
        }
        Stack<Edge> path = new Stack<>();
        for (Edge e = this.edgeTo[target]; e != null; e = this.edgeTo[e.getFromVertex()]) {
            path.push(e);
        }

        return path;
    }

    public boolean hasPathTo(int target) {
        return distTo[target] < Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        //See jpg in resources for visualization
        WeightedGraph graph = new WeightedDiGraph(new In(new File("C:\\work\\SandBox\\Algo_playground\\Graph\\src\\main\\resources\\tinyWeightedDiGraph")));
        System.out.println(graph);

        Dijkstra dijkstra = new Dijkstra(graph, 0);


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

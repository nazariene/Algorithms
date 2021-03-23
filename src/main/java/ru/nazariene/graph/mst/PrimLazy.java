package ru.nazariene.graph.mst;

import java.io.File;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.princeton.cs.algs4.In;
import ru.nazariene.graph.model.*;

public class PrimLazy {

    private Queue<Edge> mst = new LinkedList<>();
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
    private WeightedGraph graph;
    private boolean[] visited;

    public PrimLazy(WeightedGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];

        visit(0);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int one = edge.getFromVertex();
            int another = edge.getToVertex();
            if (visited[one] && visited[another]) {
                continue;
            }
            mst.add(edge);
            if (!visited[one]) {
                visit(one);
            }
            else {
                visit(another);
            }
        }
    }

    private void visit(int vertex) {
        visited[vertex] = true;
        for (Edge e : graph.adjacentTo(vertex)) {
            int from = e.getFromVertex();
            int to = e.getToVertex();
            if (!visited[to]) {
                pq.add(e);
            }
            if (!visited[from]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraphAdjListImpl(new In(new File("C:\\work\\SandBox\\Algo_playground\\Graph\\src\\main\\resources\\tinyWeightedGraph")));
        System.out.println(graph);

        PrimLazy primLazy = new PrimLazy(graph);


        System.out.println(primLazy.edges());
    }
}
